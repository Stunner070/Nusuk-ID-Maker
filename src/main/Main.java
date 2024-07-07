package main;

import Controllers.FrontPageController;
import Controllers.MainCtrl;
import Controllers.PersonsPageController;
import com.google.inject.Injector;
import javafx.application.Application;
import javafx.stage.Stage;

import static com.google.inject.Guice.createInjector;

public class Main extends Application {

    private static final Injector injector = createInjector(new MyModule());
    private static final MyFXML FXML = new MyFXML(injector  );

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        var frontPage = FXML.load(FrontPageController.class, "scenes/frontPage.fxml");
        var personsPage = FXML.load(PersonsPageController.class, "scenes/personsPage.fxml");

        var mainctrl = injector.getInstance(MainCtrl.class);
        mainctrl.initialize(primaryStage, frontPage, personsPage);

    }
}
