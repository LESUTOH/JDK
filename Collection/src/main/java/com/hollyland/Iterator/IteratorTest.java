package com.hollyland.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName IteratorTest
 * @Description TODO
 * @Author wangqiang
 * @Date 2022/9/7 10:04
 **/
public class IteratorTest {
    public static void main(String[] args) {
        List<String> fruit = new ArrayList<>();
        fruit.add("apple");
        fruit.add("banana");
        fruit.add("strawberry");
        fruit.add("cherryBomb");
        fruit.add("watermelon");
        System.out.println("当前的list= " + fruit);
        Iterator<String> iterator = fruit.iterator();
        System.out.println("传统的迭代器");
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println(str + " ");
            if (str.equals("apple")) {
                iterator.remove();
            }
        }
        System.out.println();

        System.out.println("使用Iterator的forEachRemaining方法第一次");
        iterator.forEachRemaining(System.out::println);
        System.out.println();

        System.out.println("使用Iterator的forEachRemaining方法第二次");
        iterator.forEachRemaining(System.out::println);
        System.out.println();

        System.out.println("直接使用顶级接口forEach方法");
        fruit.forEach(System.out::println);
    }
}
