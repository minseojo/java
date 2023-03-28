package org.example;

import java.util.Random;

public class IdentityEquality {
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

    static class User {
        private String name;
        private int age;

        public User(String name, int age) {

            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj instanceof User) {
                String objName =  ((User) obj).name;
                int objAge =  ((User) obj).age;
                if(this.name.equals(objName)
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
