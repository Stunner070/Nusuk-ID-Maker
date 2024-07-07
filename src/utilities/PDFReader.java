package utilities;

import commons.Person;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PDFReader {

    private final PDFExtractor pdfExtractor;
    private final PDFFinder pdfFinder;
    private PersonMaker personMaker;

    public PDFReader() {
        this.pdfExtractor = new PDFExtractor();
        this.pdfFinder = new PDFFinder();
        this.personMaker = new PersonMaker();
    }

    public List<Person> pdfReader(List<File> pdfs) throws IOException {
        List<Person> persons = new ArrayList<>();
        List<Person> wrongPersons = new ArrayList<>();
        for (File file : pdfs) {
            try {
                PDDocument document = Loader.loadPDF(file);
                PDFTextStripper pdfStripper = new PDFTextStripper();
                String text = pdfStripper.getText(document);

                List<String> info = pdfExtractor.extractInfo(text);
                Person person = personMaker.personator(info);

                if (person != null) {
                    persons.add(person);
                } else {
                    wrongPersons.add(person);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return persons;
    }

}
