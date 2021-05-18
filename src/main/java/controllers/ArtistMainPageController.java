package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class ArtistMainPageController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private Pane centrePane;

    @FXML
    private Button artbutton;

    @FXML
    private Button customersbutton;

    @FXML
    private Button signoutbutton;

    @FXML
    void artbuttonAction() throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/art_list.fxml"));
        BorderPane view = fxmlLoader.load();
        borderPane.setCenter(view);

    }

    @FXML
    void customersbuttonAction() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/artistCustomets.fxml"));
        BorderPane view = fxmlLoader.load();
        borderPane.setCenter(view);

    }

    @FXML
    private void signoutbuttonAction() throws IOException {

            Stage stage = (Stage) signoutbutton.getScene().getWindow();
            stage.close();

            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("LOGIN.fxml"));
            primaryStage.setScene(new Scene(root, 737, 524));
            primaryStage.setResizable(false);
            primaryStage.show();

        }

    }


