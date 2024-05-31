import commons.PDFReader;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.devtools.v123.domsnapshot.model.StringIndex;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NusukIdMaker {

    public static void main(String[] args) throws IOException {
        PDFReader pdfReader = new PDFReader();
        System.out.println(pdfReader.pdfReader("C:\\Users\\sofya\\Downloads\\rana.pdf"));
    }








}
