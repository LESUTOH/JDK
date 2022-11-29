package com.hollyland.map;

import java.util.TreeMap;

/**
 * @author Lesuto
 * @Date：2022/10/26 14:33
 * @description xxx
 */
public class TreeMapRepeat {
    public static void main(String[] args) {
        // 如果仅把此处的TreeMap换成HashMap，则size = 1
        TreeMap treeMap = new TreeMap();
        treeMap.put(new Key(), "value one");
        treeMap.put(new Key(), "value two");
        // TreeMap, size = 2,因为key的去重规则是根据排序结果
        System.out.println(treeMap.size());
    }


}

class Key implements Comparable<Key> {

    @Override
    // 返回负的常数，表示此对象永远小于输入的other对象，此处决定TreeMap的size = 2
    public int compareTo(Key o) {
        return -1;
    }

    // hash是相等的
    @Override
    public int hashCode() {
        return 1;
    }

    // equals 比较也是相等的
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}