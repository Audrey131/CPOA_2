package Application;

import ENUMERATION.Enumerations;
import abonnement_DAO.MySqlDao_abonnement;
import cpoa_DAO.Connexion;
import cpoa_DAO.DAOFactory;
import cpoa_DAO.MySQLFactoryDAO;
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

        DAOFactory daoData = DAOFactory.getDaoFactory(Enumerations.MYSQL);
        List<Revue> tridata = daoData.getRevueDao().getAll();

        List<String> lbl = new ArrayList<>();

        for (Revue rev: tridata) { //Boucle pour traiter chaque Revue
            String title = rev.getTitre();
            String desc = rev.getDescription();
            float price = rev.getTarif_numero();

            lbl.add(title + " || " + desc + " || " + price + "€");
        }

        this.listview_data.setItems(FXCollections.observableArrayList(lbl)); //Initialise les revues deja presentes dans la bdd

    }

    public void create(ActionEvent event) {
        String tarifstring = this.txt_tarif.getText().trim();

        String titre = this.txt_titre.getText().trim();
        String desc = this.txt_desc.getText().trim();
        String perio = this.cbb_period.getSelectionModel().getSelectedItem();
        String visu = this.lbl_img.toString().trim();

        if ((tarifstring == "") || (desc == "") || (perio == "")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Création de revue");
            alert.setContentText("Veuillez remplir tout les champs !");

            alert.showAndWait();
        }else {
            float tarif = valueOf(tarifstring);

            connexion = new Connexion();
            Connection laConnexion = connexion.creeConnexion();

            String cbb = cbb_period.toString();

            PreparedStatement requete;

            try {
                requete = laConnexion.prepareStatement("select id_periodicite from Periodicite where libelle = ?");
                requete.setString(1, cbb);

                ResultSet res = requete.executeQuery();

                int idperiod = Integer.parseInt(res.getObject(1).toString());
                Revue newrev = new Revue(10, titre, desc, tarif, visu, idperiod);

                //instance.create(newrev);
                //String aff = newrev.toString();
                //System.out.println(aff);

                DAOFactory dao = MySQLFactoryDAO.getDaoFactory(Enumerations.MYSQL);
                dao.getRevueDao().create(newrev);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Création de revue");
                alert.setContentText("Revue créée avec succès !");

                alert.showAndWait();
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
            String strList = (String) listview_data.getSelectionModel().getSelectedItem();
            String strList2 = strList.substring(strList.indexOf('|'));
            String selectRev = strList.substring(strList.indexOf(strList2)).trim();

            DAOFactory dao = MySQLFactoryDAO.getDaoFactory(Enumerations.MYSQL);
            List<Revue> supp = dao.getRevueDao().getByLibelle(selectRev);

            while(!supp.isEmpty()){
                dao.getRevueDao().delete(supp.get(1));
            }
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




}
