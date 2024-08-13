package Controllers;

import com.google.inject.Inject;
import commons.Person;
import utilities.PDFReader;
import utilities.PersonMaker;

import java.io.File;
import java.util.List;

public class PersonsPageController {

    private final MainCtrl mainCtrl;
    private List<File> files;
    private List<Person> persons;
    private PDFReader reader;

    @Inject
    public PersonsPageController(MainCtrl mainCtrl) {
        this.mainCtrl = mainCtrl;
        this.reader = new PDFReader();
    }






}
