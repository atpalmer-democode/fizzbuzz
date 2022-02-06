package fizzbuzz;

import fizzbuzz.mappers.Mapper;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class MappedArrayGeneratorTests {
    @Test
    public void test_valid_input() {
        MappedIntGenerator<String> generator = new MappedIntGenerator<>(Mapper.FIZZ_BUZZ_MAPPER);
        String[] result = generator.getResult(1, 15).toArray(String[]::new);
        String[] expected = new String[]{
            "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"
        };
        assertThat(result, is(equalTo(expected)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_invalid_input() {
        MappedIntGenerator<String> generator = new MappedIntGenerator<>(Mapper.FIZZ_BUZZ_MAPPER);
        String[] result = generator.getResult(15, 1).toArray(String[]::new);
        Assert.fail();
    }
}
