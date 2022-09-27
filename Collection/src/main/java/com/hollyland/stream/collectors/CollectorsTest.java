package com.hollyland.stream.collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName CollectorsTest
 * @Description TODO
 * @Author wangqiang
 * @Date 2022/9/7 15:56
 **/
public class CollectorsTest {
    public static void main(String[] args) {
        // 1. Array
        Stream<String> stream1 = Stream.of("a", "b", "c");
        String[] strArray = stream1.toArray(String[]::new);
        // 2. Collection
        Stream<String> stream2 = Stream.of("a", "b", "c");
        List<String> list = stream2.collect(Collectors.toList());

        Stream<String> stream3 = Stream.of("a", "b", "c");
        ArrayList<String> list2 = stream3.collect(Collectors.toCollection(ArrayList::new));

        Stream<String> stream4 = Stream.of("a", "b", "c");
        Set<String> set = stream4.collect(Collectors.toSet());

        Stream<String> stream5 = Stream.of("a", "b", "c");
        Stack<String> stack1 = stream4.collect(Collectors.toCollection(Stack::new));

        // 3. String(joining标识合并字符串）
        Stream<String> stream6 = Stream.of("a", "b", "c");
        String str = stream6.collect(Collectors.joining()).toString();
    }
}
