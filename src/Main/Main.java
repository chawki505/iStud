package Main;


import iStud.view.PersonOverviewController;
import iStud.view.RootLayoutControl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {


    private static Stage primaryStage;


    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        Main.primaryStage = primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../iStud/view/Connexion.fxml"));
        Main.primaryStage = primaryStage;
        Main.primaryStage.setTitle("iStud");
        primaryStage.setScene(new Scene(root));
        Main.primaryStage.setResizable(false);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
