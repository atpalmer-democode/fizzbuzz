package com.palmeroo.kata.fizzbuzz.solution1.util;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ReverseIterator<T> implements Iterator<T> {
    private final ListIterator<T> listIterator;

    public ReverseIterator(ListIterator<T> listIterator) {
        this.listIterator = listIterator;
    }

    public static <T> Iterable<T> getIterable(List<T> list) {
        return () -> new ReverseIterator<>(list.listIterator(list.size()));
    }

    @Override
    public boolean hasNext() {
        return listIterator.hasPrevious();
    }

    @Override
    public T next() {
        return listIterator.previous();
    }
}
