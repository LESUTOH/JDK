package com.hollyland.stream.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName StreamOperationTest
 * @Description TODO
 * @Author wangqiang
 * @Date 2022/9/7 16:49
 **/
public class StreamOperationTest {
    public static void main(String[] args) {
        String[] strArray = {"a", "b", "c"};
        List<String> worldList = Arrays.asList(strArray);
        // 转换大小写
        List<String> output = worldList.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());

        System.out.println(output);
    }
}
