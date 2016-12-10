package Main;


import ch.makery.address.view.PersonOverviewController;
import ch.makery.address.view.RootLayoutControl;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {


    private static Stage primaryStage;


    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("../ch/makery/address/view/PersonOverview.fxml"));
//
//        primaryStage.setTitle("test");
//        primaryStage.setScene(new Scene(root));
//        primaryStage.setResizable(false);
//        primaryStage.show();
        Main.primaryStage = primaryStage;
        Main.primaryStage.setTitle("iStud");
        Main.primaryStage.getIcons().add(new Image(String.valueOf("file:../ch/makery/address/resource/image/icone.png")));
        Main.primaryStage.setResizable(false);
        RootLayoutControl.initRootLayout();
        PersonOverviewController.showPersonOverview();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
