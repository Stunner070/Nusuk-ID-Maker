package services;

import javafx.animation.FadeTransition;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class LabelService {

    public void showNoPDFsText(Text noPDFsText) {
        noPDFsText.setOpacity(1.0);
        noPDFsText.setVisible(true);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), noPDFsText);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.play();
    }
}
