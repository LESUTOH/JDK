package com.hollyland.stream.flatMap;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName StreamFlatMapTest
 * @Description TODO
 * @Author wangqiang
 * @Date 2022/9/7 18:21
 **/
public class StreamFlatMapTest {
    public static void main(String[] args) {
        Stream<List<Integer>> inputStream = Stream.of(
            Arrays.asList(1),
            Arrays.asList(2, 3),
            Arrays.asList(4, 5, 6)
        );
        List<Integer> outputStream = inputStream.
            flatMap(Collection::stream)
            .collect(Collectors.toList());
        System.out.println(outputStream);
    }
}
