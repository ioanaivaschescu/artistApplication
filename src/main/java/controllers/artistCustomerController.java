package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import models.ProductModel;
import services.ProductService;
import services.PurchaseService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class artistCustomerController implements Initializable {

    @FXML
    private BorderPane searchPane;

    @FXML
    private HBox hbox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (ProductModel product : PurchaseService.products) {




                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/art_view.fxml"));


                try {


                    BorderPane pane = fxmlLoader.load();
                    art_viewController art = fxmlLoader.getController();
                    art.setData(product.getSize(), product.getPrice(), product.getMaterials(), product.getCategory(), product.getDescription());

                    hbox.getChildren().add(pane);


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


        }
    }

