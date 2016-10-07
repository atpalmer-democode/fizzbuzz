package com.palmeroo.kata.fizzbuzz.solution1.mappers;

import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mapper {
    private static class MapperPredicateItem {
        private static final IntConditionalResult<String> FIZZ =
            new IntConditionalResult<>(i -> i % 3 == 0, "Fizz");

        private static final IntConditionalResult<String> BUZZ =
            new IntConditionalResult<>(i -> i % 5 == 0, "Buzz");

        private static final IntConditionalResult<String> FIZZ_BUZZ =
            IntConditionalResult.combine(() -> Stream.of(FIZZ, BUZZ), Collectors.joining());
    }

    public static final IntFunction<String> FIZZ_BUZZ_MAPPER = ChainedIntMapper
        .startWith(MapperPredicateItem.FIZZ_BUZZ)
        .chainWith(MapperPredicateItem.BUZZ)
        .chainWith(MapperPredicateItem.FIZZ)
        .chainWith(Integer::toString);
}
