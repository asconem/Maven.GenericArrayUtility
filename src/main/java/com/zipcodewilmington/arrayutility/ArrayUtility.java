package com.zipcodewilmington.arrayutility;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    T[] genArr;

    public ArrayUtility(T[] arr) {
        this.genArr = arr;
    }

    public Integer getNumberOfOccurrences(T t) {
        return (int) Arrays.stream(genArr).filter(z -> z.equals(t)).count();
    }

    public Integer getNumberOfOccurrences(T[] arr, T t) {
        return (int) Arrays.stream(arr).filter(z -> z.equals(t)).count();
    }

    public T[] removeValue(T valueToRemove) {
        return Arrays.stream(genArr).filter(i -> i != valueToRemove).toArray(size -> Arrays.copyOf(genArr, size));
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        genArr = Stream.concat(Stream.of(genArr), Stream.of(arrayToMerge)).toArray(size -> Arrays.copyOf(genArr, size));
        return Stream.of(genArr).max(Comparator.comparingInt(this::getNumberOfOccurrences))
                .get();
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        return (int) Stream.concat(Stream.of(genArr), Stream.of(arrayToMerge))
                .filter(i -> i.equals(valueToEvaluate)).count();
    }
}
