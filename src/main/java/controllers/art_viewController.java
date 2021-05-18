package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import models.ProductModel;
import services.ProductService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class art_viewController{

    @FXML
    private Label sizeLabel;

    @FXML
    private Label materialsLabel;

    @FXML
    private Label descLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label categoryLabel;

    public void setData(String size,String price,String materials,String category,String description){


        sizeLabel.setText(size);
        materialsLabel.setText(materials);
        categoryLabel.setText(category);
        descLabel.setText(description);
        priceLabel.setText(price);






    }


    }


