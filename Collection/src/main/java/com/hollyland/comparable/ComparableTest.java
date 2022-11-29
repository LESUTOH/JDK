package com.hollyland.comparable;

import java.util.*;

/**
 * @author Lesuto
 * @Date：2022/10/17 17:33
 * @description xxx
 */
public class ComparableTest {
    public static void main(String[] args) {

        TreeSet<Student> set = new TreeSet<>();
        set.add(new Student("li4", 19));
        set.add(new Student("zhang3", 18));
        set.add(new Student("wang5", 20));
        set.add(new Student("xiao6", 21));
        set.add(new Student("xiao7", 21));

        Iterator<Student> iterator = set.iterator();
        while (iterator.hasNext()) {
            Student next = iterator.next();
            System.out.println(next);
        }

        List<Human> list = new ArrayList<>();
        list.add(new Human("li4", 19));
        list.add(new Human("zhang3", 18));
        list.add(new Human("wang5", 20));
        list.add(new Human("xiao6", 21));
        list.add(new Human("xiao7", 21));

        Iterator<Human> iterator1 = list.iterator();
        while (iterator.hasNext()) {
            Human next = iterator1.next();
            System.out.println(next);
        }

        Set<Student> hashSet = new HashSet<>();
        Student A = new Student("zhang3", 1);
        Student B = new Student("zhang3", 1);
        Student C = new Student("zhang3", 1);

        hashSet.add(A);
        hashSet.add(B);
        hashSet.add(C);

        System.out.println(hashSet);
        System.out.println(hashSet.size());
    }
}