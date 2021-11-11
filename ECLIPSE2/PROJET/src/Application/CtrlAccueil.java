package Application;

import ENUMERATION.Enumerations;
import cpoa_DAO.Connexion;
import cpoa_DAO.DAOFactory;
import cpoa_DAO_metier.Abonnement;
import cpoa_DAO_metier.ClientsTM;
import cpoa_DAO_metier.Periodicite;
import cpoa_DAO_metier.Revue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;

public class CtrlAccueil implements Initializable {
    private Connexion connexion;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public Menu mnu_accueil;
    public Menu mnu_revue;
    public Menu mnu_clients;
    public Menu mnu_abo;
    public MenuItem mnu_itemrevue;

    @FXML
    private Label lbl_nbrev;

    @FXML
    private Label lbl_nbabo;

    @FXML
    private Label lbl_nbcl;


    @Override
    public void initialize(URL location, ResourceBundle resources){
        connexion = new Connexion();
        Connection laConnexion = connexion.creeConnexion();

        DAOFactory dao = DAOFactory.getDaoFactory(Enumerations.MYSQL);
        List<Revue> revueList = dao.getRevueDao().getAll();
        String nbrev = String.valueOf(revueList.size());
        lbl_nbrev.setText(nbrev);

        List<Abonnement> aboList = dao.getAbonnementDao().getAll();
        String nbabo = String.valueOf(aboList.size());
        lbl_nbabo.setText(nbabo);

        List<ClientsTM> clientList = dao.getClientDao().getAll();
        String nbclient = String.valueOf(clientList.size());
        lbl_nbcl.setText(nbclient);
    }

    public void switchRevue(ActionEvent event){
        try {
            root = FXMLLoader.load(getClass().getResource("app_revue.fxml"));
            stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void switchClient(ActionEvent event){
        try {
            root = FXMLLoader.load(getClass().getResource("app_client.fxml"));
            stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void switchAbo(ActionEvent event){
        try {
            root = FXMLLoader.load(getClass().getResource("app_abonnement.fxml"));
            stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void switchPerio(ActionEvent event){
        try {
            root = FXMLLoader.load(getClass().getResource("app_period.fxml"));
            stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
