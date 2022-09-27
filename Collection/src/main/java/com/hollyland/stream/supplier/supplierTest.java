package com.hollyland.stream.supplier;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName supplierTest
 * @Description TODO
 * @Author wangqiang
 * @Date 2022/9/9 10:05
 **/
public class supplierTest {
    public static void main(String[] args) {
        // 生成三个两位随机数
        Random seed = new Random();
        // Supplier<Integer> random = seed::nextInt;
        Supplier<Integer> random = () -> seed.nextInt() % 100;
        Stream.generate(random).limit(3).forEach(System.out::println);
        System.out.println();
        // 另一种方法直接使用IntStream
        IntStream.generate(() -> seed.nextInt() % 100)
            .limit(3).forEach(System.out::println);
    }
}
