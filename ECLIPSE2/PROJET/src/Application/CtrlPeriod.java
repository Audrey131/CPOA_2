package Application;

import ENUMERATION.Enumerations;
import cpoa_DAO.Connexion;
import cpoa_DAO.DAOFactory;
import cpoa_DAO.MySQLFactoryDAO;
import cpoa_DAO_metier.Periodicite;
import cpoa_DAO_metier.Revue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class CtrlPeriod implements Initializable {
    private Connexion connexion;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public ListView listview_period;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        DAOFactory dao = DAOFactory.getDaoFactory(Enumerations.MYSQL);
        List<Periodicite> periodList = dao.getPeriodiciteDao().getAll();

        List<String> period = new ArrayList<>();
        List<String> lbl = new ArrayList<>();

        for (Periodicite rev: periodList) { //Boucle pour traiter chaque Revue
            int id = rev.getID();
            String title = rev.getLib();

            lbl.add("numéro " + id + " || " + title );
        }

        this.listview_period.setItems(FXCollections.observableArrayList(lbl)); //Initialise les revues deja presentes dans la bdd

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

    public void delete(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Suppression de périodicitée");
        alert.setContentText("Etes-vous sûr de vouloir supprimer la périodicitée sélectionnée ?");

        Optional<ButtonType> option = alert.showAndWait();

        if (option.get() == ButtonType.OK){
            String strList = (String) listview_period.getSelectionModel().getSelectedItem();
            String str = strList.replaceAll("\\D+","");

            int idperio = Integer.valueOf(str);


            DAOFactory dao = MySQLFactoryDAO.getDaoFactory(Enumerations.MYSQL);
            Periodicite supp = dao.getPeriodiciteDao().getById(idperio);

            dao.getPeriodiciteDao().delete(supp);

        }
    }
}
