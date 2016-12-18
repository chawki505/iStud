package iStud.view;

import javafx.fxml.FXML;

/**
 * Created by chawki on 10/12/16.
 */
public class ConeexionController {


    @FXML
    private void Menuetudiant() {

        RootLayoutControl.initRootLayout();
        PersonOverviewController.showPersonOverview();
    }

}
