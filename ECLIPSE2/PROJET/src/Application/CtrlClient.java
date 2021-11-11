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
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @FXML
    private ListView listview_client;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        this.initListView();
    }

    public void creerClient(ActionEvent event) {


        String num_rue = this.txt_num_rue.getText();

        String code_postal = this.txt_code_postal.getText();

        String nom = this.txt_nom.getText();

        String prenom = this.txt_prenom.getText();

        String voie = this.txt_voie.getText();

        String ville = this.txt_ville.getText();

        String pays = this.txt_pays.getText();

        if ((num_rue == "") || (code_postal == "") || (nom == "") || (prenom == "") || (voie == "") || (ville == "") || (pays == "")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ajout de client");
            alert.setContentText("Veuillez remplir tout les champs !");

            alert.showAndWait();
        }
        else {

            connexion = new Connexion();
            Connection laConnexion = connexion.creeConnexion();

            DAOFactory dao = MySQLFactoryDAO.getDaoFactory(Enumerations.MYSQL);
            List<ClientsTM> cl = dao.getClientDao().getAll();

            int clnb = cl.size();

            int idclient = clnb + 1;
            ClientsTM newClient = new ClientsTM(idclient, nom, prenom, num_rue, voie, code_postal, ville, pays);

            try {
                dao.getClientDao().create(newClient);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Ajout de client");
                alert.setContentText("Client créé avec succès !");

                alert.showAndWait();

                this.initListView();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void supp(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Suppression de client");
        alert.setContentText("Etes-vous sûr de vouloir supprimer le client sélectionné ?");

        Optional<ButtonType> option = alert.showAndWait();

        if (option.get() == ButtonType.OK){
            String strList = (String) listview_client.getSelectionModel().getSelectedItem(); //Récupère la ligne entière
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
        List<ClientsTM> tridata = daoData.getClientDao().getAll();

        List<String> lbl = new ArrayList<>();

        for (ClientsTM rev: tridata) { //Boucle pour traiter chaque client
            int intcl = rev.getId_client();
            String idcl = String.valueOf(intcl);

            String nom = rev.getNom();
            String prenom = rev.getPrenom();
            String num_rue = rev.getNoRue();
            String voie = rev.getVoie();
            String code_postal= rev.getCodePostal();
            String ville = rev.getVille();
            String pays = rev.getPays();

            lbl.add( nom + " || " + prenom + " || " + num_rue + " || " + voie + " || " + code_postal+ " || " +ville+ " || " +pays + " || n°" +idcl );
        }

        this.listview_client.setItems(FXCollections.observableArrayList(lbl));
    }

}
