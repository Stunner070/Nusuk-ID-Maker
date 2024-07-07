package utilities;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PDFReader {

    private final PDFExtractor pdfExtractor;
    private final PDFFinder pdfFinder;

    public PDFReader() {
        this.pdfExtractor = new PDFExtractor();
        this.pdfFinder = new PDFFinder();
    }

    public List<String> pdfReader(List<File> pdfs) throws IOException {
        List<String> info = null;
        for (File file : pdfs) {
            try {
                PDDocument document = Loader.loadPDF(file);
                PDFTextStripper pdfStripper = new PDFTextStripper();
                String text = pdfStripper.getText(document);

                info = pdfExtractor.extractInfo(text);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return info;
    }

}
