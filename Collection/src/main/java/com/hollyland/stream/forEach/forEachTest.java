package com.hollyland.stream.forEach;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName forEachTest
 * @Description TODO
 * @Author wangqiang
 * @Date 2022/9/8 14:01
 **/
public class forEachTest {
    public static void main(String[] args) {
        List<Fruit> fruitList = new ArrayList<>();
        Fruit fruit1 = new Fruit(1, "pear", "small", 11);
        Fruit fruit2 = new Fruit(2, "apple", "big", 11);
        Fruit fruit3 = new Fruit(3, "banana", "small", 11);
        Fruit fruit4 = new Fruit(4, "cherryBomb", "big", 11);
        Fruit fruit5 = new Fruit(5, "watermelon", "big", 11);
        fruitList.add(fruit1);
        fruitList.add(fruit2);
        fruitList.add(fruit3);
        fruitList.add(fruit4);
        fruitList.add(fruit5);
        // 获取type类型为big的水果名称并打印
        fruitList.stream()
            .filter(f -> "big".equals(f.getType()))
            .forEach(f -> System.out.println(f.getName()));
    }
}
