package commons;

import java.util.Objects;

public class Person {

    private String name;
    private String visaNumber;
    private String passportNumber;
    private String nationality;
    private String dateOfBirth;
    private String phoneNumber;
    private String email;

    public Person(String visaNumber, String passportNumber, String nationality, String dateOfBirth){
        this.visaNumber = visaNumber;
        this.passportNumber = passportNumber;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
            Objects.equals(visaNumber, person.visaNumber) &&
            Objects.equals(passportNumber, person.passportNumber) &&
            Objects.equals(nationality, person.nationality) &&
            Objects.equals(dateOfBirth, person.dateOfBirth) &&
            Objects.equals(phoneNumber, person.phoneNumber) &&
            Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, visaNumber, passportNumber, nationality, dateOfBirth, phoneNumber,
            email);
    }
}
