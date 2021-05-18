

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.ProductService;
import services.PurchaseService;
import services.UserService;


public class Main extends Application {




    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        UserService.loadUsers();
        ProductService.loadPRODUCTS();
        PurchaseService.loadPURCHASE();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("LOGIN.fxml"));
        primaryStage.setScene(new Scene(root, 737, 524));
        primaryStage.setResizable(false);
        primaryStage.show();


    }


}