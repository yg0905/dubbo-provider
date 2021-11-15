package com.sxkj.strem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {

        // 求最值 3
        List<Integer> list = Arrays.asList(1, 2, 3);
        Integer maxValue = list.stream().collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(a -> a)), Optional::get));


        // 最小值 1
        Integer minValue = list.stream().collect(Collectors.collectingAndThen(Collectors.minBy(Comparator.comparingInt(a -> a)), Optional::get));

        // 求和 6
        Integer sumValue = list.stream().mapToInt(item -> item).sum();

        // 平均值 2.0
        Double avg = list.stream().collect(Collectors.averagingDouble(x -> x));
        System.out.println(maxValue);
    }
}
