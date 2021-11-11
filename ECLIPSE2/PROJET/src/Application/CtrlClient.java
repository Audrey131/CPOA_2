package Application;

import ENUMERATION.Enumerations;
import abonnement_DAO.MySqlDao_abonnement;
import client_DAO.MySqlDao_client;
import com.mysql.cj.xdevapi.Client;
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
import javafx.stage.Stage;
import periodicite_dao.MySqlDaoPeriodicite;
import revue_dao.MySqlDao_revue;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Float.valueOf;

public class CtrlClient implements Initializable {

    private static MySqlDao_client instance;
    private static MySqlDaoPeriodicite instance_perio;
    private Connexion connexion;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label labelAffCodePostal;

    @FXML
    private Button labelAffCreer;

    @FXML
    private Label labelAffNom;

    @FXML
    private Label labelAffNumeroDeRue;

    @FXML
    private Label labelAffPays;

    @FXML
    private Label labelAffPrenom;

    @FXML
    private Label labelAffVille;

    @FXML
    private Label labelAffVoie;

    @FXML
    private TextField txt_code_postal;

    @FXML
    private TextField txt_nom;

    @FXML
    private TextField txt_num_rue;

    @FXML
    private TextField txt_pays;

    @FXML
    private TextField txt_prenom;

    @FXML
    private TextField txt_ville;

    @FXML
    private TextField txt_voie;

    @Override // permet d'initialiser ???
    public void initialize(URL location, ResourceBundle resources){

    }

    public void creerClient(ActionEvent event) {


        String num_rue = this.txt_num_rue.getText();

        String code_postal = this.txt_code_postal.getText();

        String nom = this.txt_nom.getText();

        String prenom = this.txt_prenom.getText();

        String voie = this.txt_voie.getText();

        String ville = this.txt_ville.getText();

        String pays = this.txt_pays.getText();


        connexion = new Connexion();
        Connection laConnexion = connexion.creeConnexion();

        DAOFactory dao = MySQLFactoryDAO.getDaoFactory(Enumerations.MYSQL);
        List<ClientsTM> cl = dao.getClientDao().getAll();

        int clnb = cl.size();

        int idclient = clnb+1;
        ClientsTM newClient = new ClientsTM(idclient, nom,prenom, num_rue , voie, code_postal, ville, pays);

        instance.create(newClient);

    }

    public void supp(){

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
