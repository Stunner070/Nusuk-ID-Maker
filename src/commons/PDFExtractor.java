package commons;

import java.util.ArrayList;
import java.util.List;

public class PDFExtractor {

    public List<String> extractInfo(String text) {
        List<String> res = new ArrayList<>();

        String dateOfBirth = null;
        String visaNumber = null;
        String passportNumber = null;
        String nationality = null;

        String[] lines = text.split("\\r?\\n"); // Split text into lines

        for (int i = 0; i < lines.length; i++) {
            if (lines[i].contains("Birth Date") && !res.contains(dateOfBirth)) {
                // Try to find a number in the same line or the next line
                dateOfBirth = extractDate(lines[i]);
                if (dateOfBirth == null && i + 1 < lines.length) {
                    dateOfBirth = extractDate(lines[i + 1]);
                }
                res.add(dateOfBirth);
            } else if (lines[i].contains("Visa No") && !res.contains(visaNumber)) {
                // Try to find a number in the same line or the next line
                visaNumber = extractNumber(lines[i]);
                if (visaNumber == null && i + 1 < lines.length) {
                    visaNumber = extractNumber(lines[i + 1]);
                }
                res.add(visaNumber);
            } else if (lines[i].contains("Passport No") && !res.contains(passportNumber)) {
                // Try to find a number in the same line or the next line
                passportNumber = extractPassportNumber(lines[i]);
                res.add(passportNumber);
            } else if (lines[i].contains("Nationality")) {
                // Try to find a number in the same line or the next line
                nationality = extractNationality(lines[i]);
                res.add(nationality);
            }
        }

        return res;

    }

    public String extractNationality(String line) {
        // Split the line into words and find the first number
        String[] words = line.split("\\s+");
        return words[1];
    }

    public String extractPassportNumber(String text) {
        String[] t = text.split("\\s+");
        return t[2];
    }


    public String extractNumber(String line) {
        // Split the line into words and find the first number
        String[] words = line.split("\\s+");
        for (String word : words) {
            if (word.matches("\\d+")) { // Check if the word is a number
                return word;
            }
        }
        return null;
    }

    public String extractDate(String line) {
        // Split the line into words and find the first number
        String[] words = line.split("\\s+");
        return words[2];
    }
}
