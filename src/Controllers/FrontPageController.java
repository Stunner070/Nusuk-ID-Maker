package Controllers;

import com.google.inject.Inject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class FrontPageController {

    private final MainCtrl mainCtrl;

    @FXML
    private Button btn;

    @Inject
    public FrontPageController(MainCtrl mainCtrl) {
        this.mainCtrl = mainCtrl;
    }

    public void test(){
        System.out.println("test");
    }

}
