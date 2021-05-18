package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class onePieceController {


    @FXML
    private Label priceLabel;

    @FXML
    private Label sizeLabel;

    @FXML
    private Label materialsLabel;

    @FXML
    private Label categoryLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Button purchaseButton;


    public void setlabels(String size, String materials, String category, String price, String Description){
        priceLabel.setText(price);
        sizeLabel.setText(size);
        materialsLabel.setText(materials);
        categoryLabel.setText(category);
        descriptionLabel.setText(Description);
    }

    @FXML
    void purchaseButtonAction() {



    }
}
