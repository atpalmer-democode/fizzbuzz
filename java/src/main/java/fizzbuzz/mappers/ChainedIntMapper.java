package fizzbuzz.mappers;

import fizzbuzz.util.ReverseIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;

class ChainedIntMapper<T> implements IntFunction<T> {
    private final IntPredicate predicate;
    private final T successValue;
    private final IntFunction<T> failureFunction;

    public ChainedIntMapper(IntPredicate predicate, T successValue, IntFunction<T> failureFunction) {
        this.predicate = Objects.requireNonNull(predicate);
        this.successValue = Objects.requireNonNull(successValue);
        this.failureFunction = Objects.requireNonNull(failureFunction);
    }

    @Override
    public T apply(int value) {
        return predicate.test(value)
            ? successValue
            : failureFunction.apply(value);
    }

    public static <T> ChainedIntMapperBuilder<T> startWith(IntConditionalResult<T> conditionalResult) {
        return ChainedIntMapperBuilder.startWith(conditionalResult);
    }

    public static class ChainedIntMapperBuilder<T> {
        private final List<IntConditionalResult<T>> conditionalResult = new ArrayList<>();

        public static <T> ChainedIntMapperBuilder<T> startWith(IntConditionalResult<T> conditionalResult) {
            ChainedIntMapperBuilder<T> result = new ChainedIntMapperBuilder<>();
            return result.chainWith(conditionalResult);
        }

        public ChainedIntMapperBuilder<T> chainWith(IntConditionalResult<T> conditionalResult) {
            this.conditionalResult.add(conditionalResult);
            return this;
        }

        public IntFunction<T> chainWith(IntFunction<T> last) {
            IntFunction<T> current = last;
            for (IntConditionalResult<T> p : ReverseIterator.getIterable(conditionalResult)) {
                current = new ChainedIntMapper<>(p.getPredicate(), p.getResult(), current);
            }
            return current;
        }
    }
}
