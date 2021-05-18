package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Customer {

    @FXML
    private BorderPane borderPane;

    @FXML
    private Pane centrePane;

    @FXML
    private Button artCatalog;

    @FXML
    private Button signoutbutton;

    @FXML
    private Button BrowseArt;

    @FXML
    void BrowseAction() {



    }

    @FXML
    void artCatalogAction() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/artCatalog.fxml"));
        Pane pane = fxmlLoader.load();


        borderPane.setCenter(pane);


    }


    @FXML
    void signoutbuttonAction() throws IOException {

        Stage stage = (Stage) signoutbutton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("LOGIN.fxml"));
        primaryStage.setScene(new Scene(root, 737, 524));
        primaryStage.setResizable(false);
        primaryStage.show();



    }
}
