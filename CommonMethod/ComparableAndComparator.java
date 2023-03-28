package org.example.CommonMethod;

import java.util.*;

import static java.lang.Integer.compare;

public class ComparableAndComparator{
    public static void main(String[] args) {
        //primitiveCompare();
        referenceCompare();
    }

    public static class User implements Comparator{
        String name;
        int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }


        @Override
        public int compare(Object o1, Object o2) {
            User user1 = (User) o1;
            User user2 = (User) o2;
            return Integer.compare(user1.age, user2.age);
        }
    }
    public static void referenceCompare() {
        User user1 = new User("조민서", 100);
        User user2 = new User("나비", 3000);
        User comp = new User("", 0); // 비교용 객체

        System.out.println(comp.compare(user1, user2));
        System.out.println(comp.compare(user1, user2));

    }

    public static void primitiveCompare() {
        int a = 2;
        int b = 3;

        if(a > b) {
            System.out.println("a가 b보다 큽니다.");
        } else if(a == b) {
            System.out.println("a와 b는 같습니다.");
        } else if(a < b) {
            System.out.println("a는 b보다 작습니다.");
        }
    }
}
