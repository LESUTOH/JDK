package com.hollyland;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName Test1
 * @Description TODO
 * @Author wangqiang
 * @Date 2022/9/9 16:37
 **/
public class Test1 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
    }

    @org.junit.jupiter.api.Test
    void test() {
//        String sn = "0422330X 00AAAAA";
//        System.out.println(sn.substring(1, 2));
//        String[] split = sn.split("");
//        System.out.println(split[1]);
//
//        List<Integer> treeMap = new ArrayList<>();
//        treeMap.add(55);
//        treeMap.add(56);
//        treeMap.add(57);
//        List<Integer> collect = treeMap.stream().filter(x -> x == 55).collect(Collectors.toList());
//        System.out.println(collect);

        List<String> whiteStrList = Stream.of(
                        "0422010X_0011111"
                        , "0422010X_0111112", "0422010X_0011115", "0422010X_0111116", "0422010X_0011117")
                .collect(Collectors.toList());
        System.out.println(groupByContinuous(whiteStrList));
    }

    private static List<List<String>> groupByContinuous(List<String> collect) {
        List<List<String>> result = new ArrayList<>();
        List<String> section = new ArrayList<>();
        result.add(section);
        for (int i = 0; i < collect.size(); i++) {
            int j = i + 1;
            String curSn = collect.get(i);
            long cur = format(curSn);
            if (j == collect.size()) {
                section.add(curSn);
                return result;
            } else {
                long next = format(collect.get(j));
                if (isSamePrefix(collect.get(i), collect.get(j)) && next - cur == 1L) {
                    section.add(curSn);
                } else {
                    section.add(curSn);
                    section = new ArrayList<>();
                    result.add(section);
                }
            }
        }
        return result;
    }

    private static long format(String sn) {
        sn = sn.substring(11);
        return Long.parseLong(sn, 16);
    }

    public static boolean isSamePrefix(String sn1, String sn2) {
        String[] bit1 = sn1.split("");
        String[] bit2 = sn2.split("");
        return bit1[1].equals(bit2[1])
                && bit1[6].equals(bit2[6])
                && bit1[9].equals(bit2[9])
                && bit1[10].equals(bit2[10]);
    }
}

