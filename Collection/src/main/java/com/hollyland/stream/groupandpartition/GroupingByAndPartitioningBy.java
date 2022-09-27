package com.hollyland.stream.groupandpartition;

import com.hollyland.stream.forEach.Fruit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName GroupingByAndPartitioningBy
 * @Description TODO
 * @Author wangqiang
 * @Date 2022/9/14 14:04
 **/
public class GroupingByAndPartitioningBy {
    @Test
    void groupBy() {
        ArrayList<Fruit> fruits = new ArrayList<>();
        Fruit fruitA2 = new Fruit(2, "pear", "small", 11);
        Fruit fruitB2 = new Fruit(1, "apple", "big", 15);
        Fruit fruitC2 = new Fruit(3, "banana", "small", 4);
        Fruit fruitD2 = new Fruit(4, "cherryBomb", "big", 10);
        Fruit fruitE2 = new Fruit(5, "watermelon", "big", 22);
        fruits.add(fruitA2);
        fruits.add(fruitB2);
        fruits.add(fruitC2);
        fruits.add(fruitD2);
        fruits.add(fruitE2);

        Map<String, List<Fruit>> collect = fruits.stream()
            .collect(Collectors.groupingBy(Fruit::getType));

        Iterator<Map.Entry<String, List<Fruit>>> iterator = collect.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Fruit>> next = iterator.next();
            System.out.println("Type: " + next.getKey() + " = " + next.getValue().size());
        }
    }

    @Test
    void partition() {
        ArrayList<Fruit> fruits = new ArrayList<>();
        Fruit fruitA2 = new Fruit(2, "pear", "small", 11);
        Fruit fruitB2 = new Fruit(1, "apple", "big", 15);
        Fruit fruitC2 = new Fruit(3, "banana", "small", 4);
        Fruit fruitD2 = new Fruit(4, "cherryBomb", "big", 10);
        Fruit fruitE2 = new Fruit(5, "watermelon", "big", 22);
        fruits.add(fruitA2);
        fruits.add(fruitB2);
        fruits.add(fruitC2);
        fruits.add(fruitD2);
        fruits.add(fruitE2);

        Map<Boolean, List<Fruit>> collect = fruits.stream()
            .collect(Collectors.partitioningBy(f -> f.getPrice() < 10));
        System.out.println(" 便宜水果种类： " + collect.get(true).size());
        System.out.println(" 昂贵水果种类： " + collect.get(false).size());
    }
}
