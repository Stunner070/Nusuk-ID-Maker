package Controllers;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.File;
import java.util.List;

public class MainCtrl {

    private Stage primaryStage;

    private Scene frontScene;
    private FrontPageController frontPageController;

    private Scene personsScene;
    private PersonsPageController personsPageController;

    public void initialize(Stage primaryStage, Pair<FrontPageController, Parent> frontPage, Pair<PersonsPageController, Parent> personsPage) {
        this.primaryStage = primaryStage;

        this.frontPageController = frontPage.getKey();
        this.frontScene = new Scene(frontPage.getValue());

        this.personsPageController = personsPage.getKey();
        this.personsScene = new Scene(personsPage.getValue());


        showHomePage();
        primaryStage.show();
    }

    public void showHomePage() {
        primaryStage.setScene(frontScene);
    }

    public void showPersonsPage() {
        primaryStage.setScene(personsScene);
    }

    public List<File> getFiles() {
        return frontPageController.getFiles();
    }

}
