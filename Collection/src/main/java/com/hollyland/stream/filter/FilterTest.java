package com.hollyland.stream.filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName FilterTest
 * @Description TODO
 * @Author wangqiang
 * @Date 2022/9/8 13:55
 **/
public class FilterTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("aa", "bb", "", "cc", "", "dd", "");
        // 过滤空白字符串
        List<String> notNullStrings = strings.stream()
            .filter(x -> !x.isEmpty())
            .collect(Collectors.toList());

        System.out.println(notNullStrings);
    }
}
