package myjava.basic.multithreading;

public class DeskTest {
    public static void main(String[] args) {
        Thread foodie = new Foodie();
        Thread cook = new Cook();

        foodie.setName("Foodie");
        cook.setName("Cook");

        cook.start();
        foodie.start();
    }

}
