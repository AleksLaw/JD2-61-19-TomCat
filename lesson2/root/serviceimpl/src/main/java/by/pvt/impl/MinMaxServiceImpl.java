package by.pvt.impl;

import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;

import by.pvt.MinMaxService;

/**
 *
 */
public class MinMaxServiceImpl implements MinMaxService {

    public Integer findMin(List<Integer> values) {
        if (values == null || values.isEmpty())
            throw new IllegalArgumentException("Input value cannot be null or empty");

        OptionalInt optInt = values.stream()
                .filter(Objects::nonNull)
                .mapToInt(value -> value)
                .min();

        System.out.println(optInt);

        return optInt.orElseThrow(() -> new RuntimeException("Not defined"));
    }

    public Integer findMax(List<Integer> values) {
        return null;
    }
}
