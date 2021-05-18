package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.ProductModel;
import services.ProductService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class art_listController implements Initializable {

    @FXML
    private BorderPane searchPane;

    @FXML
    private VBox vbox;

    @FXML
    private Button add_art;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (ProductModel product : ProductService.products) {

            {


                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/art_view.fxml"));


                try {


                    BorderPane pane = fxmlLoader.load();
                    art_viewController art = fxmlLoader.getController();
                    art.setData(product.getSize(), product.getPrice(), product.getMaterials(), product.getCategory(), product.getDescription());

                    vbox.getChildren().add(pane);


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


        }
    }




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
