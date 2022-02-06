package fizzbuzz;

import fizzbuzz.mappers.Mapper;

import java.util.Objects;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MappedIntGenerator<T> {
    private final IntFunction<T> mapper;

    public MappedIntGenerator(IntFunction<T> mapper) {
        this.mapper = Objects.requireNonNull(mapper);
    }

    public Stream<T> getResult(int start, int end) {
        if(end < start){
            throw new IllegalArgumentException(String.format("End (%s) cannot precede start (%s).", end, start));
        }

        return IntStream.rangeClosed(start, end).mapToObj(mapper);
    }

    public static void main(String[] args) {
        MappedIntGenerator<String> generator = new MappedIntGenerator<>(Mapper.FIZZ_BUZZ_MAPPER);
        Stream<String> values = generator.getResult(1, 100);
        values.forEach(System.out::println);
    }
}
