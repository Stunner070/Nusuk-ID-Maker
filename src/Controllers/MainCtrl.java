package Controllers;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Pair;

public class MainCtrl {

    private Stage primaryStage;

    private Scene frontScene;
    private FrontPageController frontPageController;

    public void initialize(Stage primaryStage, Pair<FrontPageController, Parent> frontPage) {
        this.primaryStage = primaryStage;

        this.frontPageController = frontPage.getKey();
        this.frontScene = new Scene(frontPage.getValue());

        showHomePage();
        primaryStage.show();
    }

    private void showHomePage() {
        primaryStage.setScene(frontScene);
    }

}
