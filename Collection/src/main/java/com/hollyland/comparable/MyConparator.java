package com.hollyland.comparable;

import java.util.Comparator;

/**
 * @author Lesuto
 * @Date：2022/10/18 11:25
 * @description xxx
 */
public class MyConparator implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getAge() < o2.getAge() ? -1 : (o1.getAge() == o2.getAge() ? o1.getName().compareTo(o2.getName()) : 1);
    }
}