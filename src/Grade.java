import java.util.Iterator;
import java.util.TreeSet;

public class Grade {

    public boolean passed(float grade) {
        if (grade < 1.0 || grade > 10.0)
            throw new IllegalArgumentException();
        return grade >= 5.0;
    }


    public static int[] unique(int[] data) {
        TreeSet<Integer> values = new TreeSet<Integer>();
        for (int i = 0; i < data.length; i++) {
            values.add(data[i]);
        }
        final int count = values.size();
        final int[] out = new int[count];

        Iterator<Integer> iterator = values.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            out[count - ++i] = iterator.next();
        }
        return out;
    }

    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(String str) {
        return new StringBuilder(str).reverse().toString().equals(str);
    }

}
