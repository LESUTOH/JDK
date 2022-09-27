package com.hollyland.stream.sorted;

import com.hollyland.stream.forEach.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName SortedTest
 * @Description TODO
 * @Author wangqiang
 * @Date 2022/9/8 14:57
 **/
public class SortedTest {
    public static void main(String[] args) {
        List<Fruit> fruitList = new ArrayList<>();
        Fruit fruit1 = new Fruit(5, "pear", "small", 11);
        Fruit fruit2 = new Fruit(4, "apple", "big", 11);
        Fruit fruit3 = new Fruit(3, "banana", "small", 11);
        Fruit fruit4 = new Fruit(2, "cherryBomb", "big", 11);
        Fruit fruit5 = new Fruit(1, "watermelon", "big", 11);
        fruitList.add(fruit1);
        fruitList.add(fruit2);
        fruitList.add(fruit3);
        fruitList.add(fruit4);
        fruitList.add(fruit5);

        List<String> fruits = fruitList.stream()
            .sorted((A, B) -> A.getId() > B.getId() ? 1 : -1)
            .map(fruit -> fruit.getId() + ":" + fruit.getName())
            .collect(Collectors.toList());
        System.out.println(fruits);
    }
}
