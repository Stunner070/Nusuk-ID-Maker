import net.jqwik.api.*;
import net.jqwik.api.constraints.FloatRange;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.constraints.Size;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static java.util.Collections.reverseOrder;
import static org.assertj.core.api.Assertions.assertThat;

class GradeTest {

    private final Grade pg = new Grade();

    @Property
    void fail(
        @ForAll
        @FloatRange(min = 1f, max = 5f, maxIncluded = false)
        float grade) {
//        System.out.println(grade);
        Assertions.assertFalse(pg.passed(grade));
    }

    @Property
    void unique(
        @ForAll
        @Size(value = 100)
        List<@IntRange(min = 1, max = 20) Integer> numbers
    ) {
        int[] doubles = convertListToArray(numbers);
        int[] result = Grade.unique(doubles);

        assertThat(result)
            .contains(doubles)
            .doesNotHaveDuplicates()
            .isSortedAccordingTo(reverseOrder());
    }

    @Property
    void isPalindrome(
        @ForAll("palindromes")
        String str
    ) {
        System.out.println(str);
        boolean expected = str.equals(new StringBuilder(str).reverse().toString());
        boolean actual = Grade.isPalindrome(str);
        assertThat(actual).isEqualTo(expected);
    }

    @Provide
    Arbitrary<String> palindromes() {
        return Arbitraries.strings().alpha().ofMinLength(5)
            .flatMap(this::makePalindrome);
    }

    private Arbitrary<String> makePalindrome(String base) {
        String reversed = new StringBuilder(base).reverse().toString();
        return Arbitraries.of(base + reversed);
    }

    private int[] convertListToArray(List<Integer> numbers) {
        return numbers
            .stream()
            .mapToInt(x -> x)
            .toArray();
    }
}
