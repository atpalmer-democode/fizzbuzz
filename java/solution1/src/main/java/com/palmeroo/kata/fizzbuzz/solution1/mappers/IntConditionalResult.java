package com.palmeroo.kata.fizzbuzz.solution1.mappers;

import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

class IntConditionalResult<T> {
    private final IntPredicate predicate;
    private final T result;

    public IntConditionalResult(IntPredicate predicate, T result) {
        this.predicate = Objects.requireNonNull(predicate);
        this.result = Objects.requireNonNull(result);
    }

    public static <T> IntConditionalResult<T> combine(Supplier<Stream<IntConditionalResult<T>>> predicates, Collector<? super T, ?, T> collector) {
        IntPredicate predicate = i -> predicates.get().allMatch(p -> p.getPredicate().test(i));
        T result = predicates.get().map(p -> p.getResult()).collect(collector);
        return new IntConditionalResult<>(predicate, result);
    }

    public IntPredicate getPredicate() {
        return predicate;
    }

    public T getResult() {
        return result;
    }
}
