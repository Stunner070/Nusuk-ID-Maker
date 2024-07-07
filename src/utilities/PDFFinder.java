package utilities;

import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PDFFinder {

    public List<File> findPDF() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload PDFs");
        List<File> files = fileChooser.showOpenMultipleDialog(null);
        return files;
    }
}
