package Controllers;

import com.google.inject.Inject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import main.Main;

public class FrontPageController {
    private final MainCtrl mainCtrl;


    @FXML
    private Button importPDFs;

    @Inject
    public FrontPageController(MainCtrl mainCtrl) {
        this.mainCtrl = mainCtrl;
    }

}
