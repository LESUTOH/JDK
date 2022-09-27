package com.hollyland.stream.map.peek;

import com.hollyland.stream.forEach.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName PeekTest
 * @Description TODO
 * @Author wangqiang
 * @Date 2022/9/8 14:18
 **/
public class PeekTest {
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

        fruitList.stream()
            .filter(f -> "big".equals(f.getType()))
            .peek(fruit -> System.out.println(fruit.getName()))
            .peek(fruit -> {
                String upperString = fruit.getName().toUpperCase();
                fruit.setName(upperString);
            })
            .peek(fruit -> System.out.println(fruit.getName()))
            .collect(Collectors.toList());
    }
}
