package controllers;

//import exceptions.EmptyFieldsException;
import exceptions.UsernameAlreadyExistsException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
//import exceptions.UsernameAlreadyExistsException;
import javafx.stage.Stage;
import services.UserService;
//import services.UserService;

public class RegisterController {

    @FXML
    public Text registrationMessage;
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
    private Label wronglogin;

    @FXML
    private Button cancelButton;

    @FXML
    public Label accountSuccesfullLabel;

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