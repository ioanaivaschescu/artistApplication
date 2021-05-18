package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import models.UserModel;
import services.UserService;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameTextField;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button registerButton;

    @FXML
    void loginButtonAction() throws IOException {

        String password1 = UserService.encodePassword(usernameTextField.getText(),passwordTextField.getText());

        if(usernameTextField.getText().isEmpty() && passwordTextField.getText().isEmpty())
        {

        }
        else{
            String role;
            FXMLLoader fxmlLoader = new FXMLLoader();

            int ok =0;

            for (UserModel user : UserService.users) {




                if (usernameTextField.getText().equals(user.getUsername()) && password1.equals(user.getPassword())){
                    role = user.getRole();

                    if(role.equals("Artist")){ fxmlLoader.setLocation(getClass().getResource("/ArtistMainPage.fxml"));}
                    else{ fxmlLoader.setLocation(getClass().getResource("/Customer.fxml"));}

                    ok = 1;


                }

            }
            if(ok == 1){
                Stage stage1 = new Stage();
                stage1.setScene(new Scene((Parent) fxmlLoader.load(), 1146 ,692));
                stage1.show();

                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.close();

        }



        }

    }

    @FXML
    void registerButtonAction() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/Register.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load(),716,805);
        Stage stage1 = new Stage();
        stage1.setScene(scene);
        stage1.setResizable(false);
        stage1.show();

    }

}

