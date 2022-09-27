package com.hollyland.spliterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @ClassName spliteratorTest
 * @Description TODO
 * @Author wangqiang
 * @Date 2022/9/7 11:08
 **/
public class spliteratorTest {
    public static void main(String[] args) {
        List<String> fruit = new ArrayList<>();
        fruit.add("apple");
        fruit.add("banana");
        fruit.add("strawberry");
        fruit.add("cherryBomb");
        fruit.add("watermelon");

        Spliterator<String> spliterator = fruit.spliterator();

        Spliterator<String> split1 = spliterator.trySplit();

        Spliterator<String> split2 = spliterator.trySplit();

        System.out.println("spliterator.consumer :");

        // 非lambda传统写法
        spliterator.forEachRemaining(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        System.out.println("split1.consumer :");
        split1.forEachRemaining(System.out::println);
        System.out.println("split1.consumer :");
        split2.forEachRemaining(System.out::println);
    }
}
