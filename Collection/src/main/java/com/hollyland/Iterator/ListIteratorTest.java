package com.hollyland.Iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @ClassName ListIteratorTest
 * @Description TODO
 * @Author wangqiang
 * @Date 2022/9/7 13:47
 **/
public class ListIteratorTest {
    public static void main(String[] args) {
        List<String> fruit = new ArrayList<>();
        fruit.add("apple");
        fruit.add("banana");
        fruit.add("strawberry");
        fruit.add("cherryBomb");
        fruit.add("watermelon");
        System.out.println("原始 ：" + fruit);

        ListIterator<String> stringListIterator = fruit.listIterator();
        while (stringListIterator.hasNext()) {
            if ("watermelon".equals(stringListIterator.next())) {
                stringListIterator.set("pear");
                stringListIterator.add("peach");
            }
        }

        System.out.println("处理后:" + fruit);
    }
}
