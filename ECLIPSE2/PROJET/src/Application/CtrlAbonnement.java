package Application;

import ENUMERATION.Enumerations;
import abonnement_DAO.MySqlDao_abonnement;
import client_DAO.MySqlDao_client;
import com.mysql.cj.xdevapi.Client;
import cpoa_DAO.Connexion;
import cpoa_DAO.DAOFactory;
import cpoa_DAO.MySQLFactoryDAO;
import cpoa_DAO_metier.*;
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

public class CtrlAbonnement implements Initializable {

    private static MySqlDao_client instance;
    private static MySqlDaoPeriodicite instance_perio;
    private Connexion connexion;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button btn_accueil;

    @FXML
    private Button btn_creer;

    @FXML
    private Button btn_suppr;

    @FXML
    private ListView listview_abonnement;

    @FXML
    private ComboBox<String> mnu_duree;

    @FXML
    private ComboBox<String> mnu_idClient;

    @FXML
    private ComboBox<String> mnu_idRevue;

    @FXML
    private TextField txt_dateDebut;

    @FXML
    private TextField txt_dateFin;


    @Override
    public void initialize(URL location, ResourceBundle resources){

        DAOFactory dao = DAOFactory.getDaoFactory(Enumerations.MYSQL);
        List<DureeTM> abocbb = dao.getDureeDao().getAll();

        List<String> abo = new ArrayList<>();

        for (DureeTM rev: abocbb) {
            int idnum = rev.getId_duree();
            String idstr = String.valueOf(idnum);

            abo.add(idstr);
        }

        this.mnu_duree.setItems(FXCollections.observableArrayList(abo)); //initialise la ccb durée

        List<ClientsTM> clcbb = dao.getClientDao().getAll();

        List<String> cl = new ArrayList<>();

        for (ClientsTM rev: clcbb) {
            int idnum = rev.getId_client();
            String idstr = String.valueOf(idnum);

            abo.add(idstr);
        }

        this.mnu_idClient.setItems(FXCollections.observableArrayList(abo)); //initialise la ccb client


        List<Revue> revuecbb = dao.getRevueDao().getAll();

        List<String> revue = new ArrayList<>();

        for (Revue rev: revuecbb) {
            int idnum = rev.getId_revue();
            String idstr = String.valueOf(idnum);

            revue.add(idstr);
        }

        this.mnu_duree.setItems(FXCollections.observableArrayList(abo)); //initialise la ccb revue

        this.initListView();
    }

    public void creerAbonnement(ActionEvent event) {
        String duree = mnu_duree.getValue();
        String cl = mnu_idClient.getValue();
        String revue = mnu_idRevue.getValue();

        int idduree = Integer.valueOf(duree);
        int idcl = Integer.valueOf(duree);
        int idrevue = Integer.valueOf(duree);


        String dateDebut  = this.txt_dateDebut.getText();
        String dateFin= this.txt_dateFin.getText();

        if ((dateDebut == "") || (dateFin == "") || (duree == "") || (cl == "") || (revue == "")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ajout d'abonnement");
            alert.setContentText("Veuillez remplir tout les champs !");

            alert.showAndWait();
        }
        else {

            connexion = new Connexion();
            Connection laConnexion = connexion.creeConnexion();

            DAOFactory dao = MySQLFactoryDAO.getDaoFactory(Enumerations.MYSQL);
            List<Abonnement> ab = dao.getAbonnementDao().getAll();

            int abnb = ab.size();

            int idabonnement = abnb + 1;
            Abonnement newAbo = new Abonnement(idabonnement, dateDebut, dateFin, idcl, idrevue, idduree );

            try {
                dao.getAbonnementDao().create(newAbo);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Ajout d'abonnement");
                alert.setContentText("Abonnement créé avec succès !");

                alert.showAndWait();

                this.initListView();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void supp(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Suppression d'abonnement");
        alert.setContentText("Etes-vous sûr de vouloir supprimer l'abonnement sélectionné ?");

        Optional<ButtonType> option = alert.showAndWait();

        if (option.get() == ButtonType.OK){
            String strList = (String) listview_abonnement.getSelectionModel().getSelectedItem(); //Récupère la ligne entière
            System.out.println(strList);

            String strList2 = strList.substring(strList.indexOf('°')).trim(); //Récupère la ligne jusqu'au °
            System.out.println(strList2);

            String strList3 = strList2.substring(strList2.indexOf('|')).trim();
            System.out.println(strList3);

            Matcher matcher = Pattern.compile("\\d+").matcher(strList3);
            matcher.find();
            int selectRev = Integer.valueOf(matcher.group());



            DAOFactory dao = MySQLFactoryDAO.getDaoFactory(Enumerations.MYSQL);
            Revue supp = dao.getRevueDao().getById(selectRev);


            dao.getRevueDao().delete(supp);
            this.initListView();

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

    public void initListView(){
        DAOFactory daoData = DAOFactory.getDaoFactory(Enumerations.MYSQL);
        List<Abonnement> tridata = daoData.getAbonnementDao().getAll();

        List<String> lbl = new ArrayList<>();

        for (Abonnement rev: tridata) { //Boucle pour traiter chaque abonnement
            int intabo = rev.getId();
            String idabo = String.valueOf(intabo);

            String date_deb = rev.getDateDebut();
            String date_fin = rev.getDateFin();
            int idcl = rev.getIdClient();
            int idrev = rev.getIdRevue();
            int idduree= rev.getDuree();

            lbl.add( idabo + " || " + date_deb + " || " + date_fin + " || " + idcl + " || " + idrev+ " || " +idduree);
        }

        this.listview_abonnement.setItems(FXCollections.observableArrayList(lbl));
    }

}
