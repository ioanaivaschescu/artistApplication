package controllers;

import exceptions.UsernameAlreadyExistsException;
import javafx.fxml.FXML;
import javafx.scene.control.*;


import javafx.stage.Stage;
import services.UserService;


public class RegisterController {


    @FXML
    public PasswordField passwordField;
    @FXML
    public TextField usernameField;
    @FXML
    public ChoiceBox role;

    @FXML
    public TextField firstNameField;
    @FXML
    public TextField lastNameField;
    @FXML
    private Button cancelButton;


    @FXML
    public void initialize() {
        role.getItems().addAll("Artist", "Customer");
    }

    @FXML
    public void handleRegisterAction(){

            try {

                UserService.addUser(usernameField.getText(), passwordField.getText(), firstNameField.getText(), lastNameField.getText(),(String) role.getValue());

            } catch (UsernameAlreadyExistsException ignored) {

            }



        }








    @FXML
    public void cancelButtonAction(){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}