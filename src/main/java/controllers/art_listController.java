package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class art_listController {

    @FXML
    private BorderPane searchPane;

    @FXML
    private VBox apartmentsLayout;

    @FXML
    private Button add_art;

    @FXML
    void add_artAction() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/art_add.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load(),500,500);
        Stage stage1 = new Stage();
        stage1.setTitle("Add Art");
        stage1.setScene(scene);
        stage1.setResizable(false);
        stage1.show();
    }

}
