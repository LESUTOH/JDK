package com.hollyland.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName CreateStreamTest
 * @Description TODO
 * @Author wangqiang
 * @Date 2022/9/7 15:40
 **/
public class CreateStreamTest {
    public static void main(String[] args) {
        // 1.直接创建
        Stream<String> stream = Stream.of("a", "b", "c");
        // 2.数组创建Stream
        String[] strArray = {"a", "b", "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);
        // 3.集合类方法创建
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();
    }
}
