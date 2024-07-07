package utilities;

import commons.Person;

import java.util.List;

public class PersonMaker {

    public Person personator(List<String> info) {
        return new Person(info.get(0), info.get(1), info.get(2), info.get(3));
    }
}
