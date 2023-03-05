package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        User userA = new User("A", 0); //name, age, money
        System.out.println("userA.hashCode() = " + userA.hashCode());
        userA.age = 20;
        System.out.println("userA.age = 20");
        System.out.println("userA.hashCode() = " + userA.hashCode());

        User userB = new User("A", 20);
        System.out.println("userA.equals(userB) = " + userA.equals(userB));
        System.out.println();
        System.out.println("userA.hashCode() = " + userA.hashCode());
        System.out.println("userB.hashCode() = " + userB.hashCode());
        System.out.println("userA.hashCode() == userB.hashCode() : "
                + (userA.hashCode() ==  userB.hashCode()));
        System.out.println("userA == userB : " + (userA == userB));


    }

    static class User implements org.example.User {
        private String name;
        private int age;

        public User(String name, int age) {

            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(User obj) {
            if (this == obj) {
                return true;
            }

            String objName = obj.name;
            int objAge = obj.age;
            if (obj instanceof User) {
                if(objName.equals(this.name)
                        && objAge == this.age) { return true;}
            }

            return false;
        }

        @Override
        public int hashCode() {
            int hash = 17;
            Random random = new Random();
            int randomHash = random.nextInt(1000);
            hash = 31 * hash + name.hashCode();
            hash = 31 * hash + age + randomHash;
            return hash;
        }
    }
}
