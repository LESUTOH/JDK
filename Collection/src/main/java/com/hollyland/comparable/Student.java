package com.hollyland.comparable;

/**
 * @author Lesuto
 * @Date：2022/10/17 17:17
 * @description xxx
 */
public class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return getAge() == student.getAge() && getName().equals(student.getName());
    }

    @Override
    public int hashCode() {
        return age + name.hashCode();
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.age > o.age ? 1 : (this.age == o.age ? this.name.compareTo(o.name) : -1);
    }
}