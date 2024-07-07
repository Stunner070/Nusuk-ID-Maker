package Controllers;

import com.google.inject.Inject;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import services.LabelService;
import utilities.PDFFinder;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class FrontPageController implements Initializable {

    private final MainCtrl mainCtrl;
    private final PDFFinder pdfFinder = new PDFFinder();
    private final LabelService labelService = new LabelService();


    @FXML
    private Button btn;
    @FXML
    private Text welcomeText;
    @FXML
    private ComboBox<String> languageComboBox;
    @FXML
    private Text noPDFsText;

    @Inject
    public FrontPageController(MainCtrl mainCtrl) {
        this.mainCtrl = mainCtrl;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void uploadPDFs() throws IOException {
        List<File> files = pdfFinder.findPDF();
        if(files == null || files.isEmpty()){
            labelService.showNoPDFsText(noPDFsText);
        }
    }

}
