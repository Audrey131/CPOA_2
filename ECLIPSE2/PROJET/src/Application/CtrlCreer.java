package Application;

import ENUMERATION.Enumerations;
import abonnement_DAO.MySqlDao_abonnement;
import cpoa_DAO.Connexion;
import cpoa_DAO.DAOFactory;
import cpoa_DAO.MySQLFactoryDAO;
import cpoa_DAO_metier.ClientsTM;
import cpoa_DAO_metier.Periodicite;
import cpoa_DAO_metier.Revue;
import duree_DAO.MySqlDaoDureeTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import periodicite_dao.MySqlDaoPeriodicite;
import revue_dao.MySqlDao_revue;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Float.valueOf;

public class CtrlCreer implements Initializable {

    private static MySqlDao_revue instance;
    private static MySqlDaoPeriodicite instance_perio;
    private Connexion connexion;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ListView listview_data;

    @FXML
    private ImageView img_view;

    @FXML
    private Label lbl_img;

    @FXML
    private Button btn_create;

    @FXML
    private Button btn_delete;

    @FXML
    private Button btn_modify;

    @FXML
    private Button btn_detail;

    @FXML
    private Button btn_modifyimg;

    @FXML
    private ComboBox<String> cbb_period;

    @FXML
    private TextArea txt_desc;

    @FXML
    private TextField txt_tarif;

    @FXML
    private TextField txt_titre;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        DAOFactory dao = DAOFactory.getDaoFactory(Enumerations.MYSQL);
        List<Periodicite> periodcbb = dao.getPeriodiciteDao().getAll();

        List<String> period = new ArrayList<>();

        for (Periodicite rev: periodcbb) { //Boucle pour traiter chaque Revue
            String title = rev.getLib();

            period.add(title);
        }

        this.cbb_period.setItems(FXCollections.observableArrayList(period)); //initialise la ccb périodicité

        this.initRevue();

    }

    public void create(ActionEvent event) {
        String tarifstring = this.txt_tarif.getText().trim();
        String titre = this.txt_titre.getText().trim();
        String desc = this.txt_desc.getText().trim();
        String perio = this.cbb_period.getSelectionModel().getSelectedItem();
        String visu = this.img_view.getId(); // NE RETOURNE PAS LA BONNE VALEUR

        if ((tarifstring == "") || (desc == "") || (perio == "")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Création de revue");
            alert.setContentText("Veuillez remplir tout les champs !");

            alert.showAndWait();
        }else {

            float tarif = valueOf(tarifstring);

            connexion = new Connexion();
            Connection laConnexion = connexion.creeConnexion();

            String cbb = cbb_period.getValue();
            System.out.println(cbb);

            PreparedStatement requete;

            try {

                //Recuperation de l'ID de la periodicitée sélectionnée

                requete = laConnexion.prepareStatement("select id_periodicite from Periodicite where libelle = ?");
                requete.setString(1, cbb);

                ResultSet res = requete.executeQuery();

                if(res.next()){
                    int idperiod = Integer.parseInt(String.valueOf(res.getInt(1)));

                    //Recuperation de l'ID de la nouvelle revue
                    DAOFactory dao = MySQLFactoryDAO.getDaoFactory(Enumerations.MYSQL);
                    List<Revue> revue = dao.getRevueDao().getAll();

                    int revuenb = revue.size();

                    int idrevue = revuenb+1;
                    Revue newrev = new Revue(idrevue, titre, desc, tarif, visu, idperiod);

                    DAOFactory dao2 = MySQLFactoryDAO.getDaoFactory(Enumerations.MYSQL);
                    dao2.getRevueDao().create(newrev);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Création de revue");
                    alert.setContentText("Revue créée avec succès !");

                    alert.showAndWait();

                    this.initRevue();
                }



            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void selectImg(){
        //FileChooser fileChooser = new FileChooser();

        //fileChooser.setTitle("Choisir l'image de couverture");

    }

    public void btnSupp(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Suppression de revue");
        alert.setContentText("Etes-vous sûr de vouloir supprimer la revue sélectionnée ?");

        Optional<ButtonType> option = alert.showAndWait();

        if (option.get() == ButtonType.OK){
            String strList = (String) listview_data.getSelectionModel().getSelectedItem(); //Récupère la ligne entière
            System.out.println(strList);

            String strList2 = strList.substring(strList.indexOf('€')).trim(); //Récupère la ligne jusqu'au €
            System.out.println(strList2);

            String strList3 = strList2.substring(strList2.indexOf('|')).trim(); //Récupère la ligne entière - la ligne sans le numéro
            System.out.println(strList3);

            Matcher matcher = Pattern.compile("\\d+").matcher(strList3);
            matcher.find();
            int selectRev = Integer.valueOf(matcher.group());



            DAOFactory dao = MySQLFactoryDAO.getDaoFactory(Enumerations.MYSQL);
            Revue supp = dao.getRevueDao().getById(selectRev);


            dao.getRevueDao().delete(supp);
            this.initRevue();

        }
    }
    public void switchAccueil(ActionEvent event){
        try {
            root = FXMLLoader.load(getClass().getResource("app_accueil.fxml"));
            stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initRevue(){
        DAOFactory daoData = DAOFactory.getDaoFactory(Enumerations.MYSQL);
        List<Revue> tridata = daoData.getRevueDao().getAll();

        List<String> lbl = new ArrayList<>();

        for (Revue rev: tridata) { //Boucle pour traiter chaque Revue
            int idrev = rev.getId_revue();
            String title = rev.getTitre();
            String desc = rev.getDescription();
            float price = rev.getTarif_numero();

            lbl.add( title + " || " + desc + " || " + price + "€ || " +idrev);
        }

        this.listview_data.setItems(FXCollections.observableArrayList(lbl)); //Initialise les revues deja presentes dans la bdd
    }


}
