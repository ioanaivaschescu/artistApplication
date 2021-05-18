package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import services.ProductService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerArtController implements Initializable {

    @FXML
    private BorderPane searchPane;


    @FXML
    private HBox hbox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (int i = 0; i < ProductService.products.size(); i++) {

            FXMLLoader temp = new FXMLLoader();
            temp.setLocation(getClass().getResource("/oneArtPiece.fxml"));

            try {
                BorderPane pane = temp.load();

                onePieceController one = temp.getController();
                one.setlabels(ProductService.products.get(i).getSize(), ProductService.products.get(i).getSize(), ProductService.products.get(i).getMaterials(),ProductService.products.get(i).getCategory(),ProductService.products.get(i).getDescription());
                hbox.getChildren().add(pane);


            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}