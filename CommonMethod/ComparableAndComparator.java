// https://velog.io/@minseojo/Java-Comparable-Comparator
package org.example.CommonMethod;

import java.util.*;

import static java.lang.Integer.compare;

public class ComparableAndComparator{
    public static void main(String[] args) {
        //primitiveCompare();
        //referenceCompare();
        priorityQueueTest();
    }

    public static void priorityQueueTest() {
        Queue<User> pq = new PriorityQueue<>();
        User user1 = new User("조민서", 3);
        User user2 = new User("조민서", 2);
        User user3 = new User("가오리", 4);
        User user4 = new User("가오리", 1);
        pq.add(user1);
        pq.add(user2);
        pq.add(user3);
        pq.add(user4);
        while(!pq.isEmpty()) {
            User user = pq.poll();
            System.out.println(user.name + " " + user.age);
        }
    }
    public static class User implements Comparable{
        String name;
        int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Object o) {
            User user = (User) o;
            if(this.name == user.name) {
                return Integer.compare(this.age, user.age); // 이름이 같으면, 나이는 오름차순
            } else {
                return this.name.compareTo(user.name); // 이름이 다르면, 이름 오름차순
            }
        }
    }
    public static void referenceCompare() {
        User user1 = new User("조민서", 100);
        User user2 = new User("나비", 3000);
        User user3 = new User("가오리", 40);

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);

        list.sort((User a, User b) -> Integer.compare(a.age, b.age));
        for(User user : list) {
            System.out.println(user.name + " " + user.age);
        }

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
