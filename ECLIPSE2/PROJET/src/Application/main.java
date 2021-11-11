package Application;

import abonnement_DAO.MySqlDao_abonnement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

import cpoa_DAO.*;

import java.net.URL;
import java.sql.Connection;

public class main extends Application {



    @Override
    public void start(Stage primaryStage){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("app_accueil.fxml"));

            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.setTitle("RevuesOnLine");
            primaryStage.setResizable(false);
            primaryStage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public static void main(String[] args) {

        launch(args);
    }

}
