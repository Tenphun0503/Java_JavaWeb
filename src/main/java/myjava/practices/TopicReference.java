package myjava.practices;

/**
 * This class shows the basic of Java
 * Author: Tenphun
 * 1. This is a document comment
 */
public class TopicReference {
    /* it's better to code while looking the tutorial
     2. This is a multi-line comment */

    // Method Overloading
    int sumOfNum(int x, int y){return x + y;}
    float sumOfNum(float x, float y){return x + y;}

    // A public method
    public void myPrint(){
        System.out.println("Object called me");
    }

    public static void main(String[] args){
        String name = "Tenphun";
        char init = 'T';
        int age = 25;
        float height = 179.99f;
        double weight = 79.999; // default double if no end letter
        boolean isMan = true;

        // Printing
        System.out.println("I am " + name);
        // Shorthand of if/else
        System.out.println(isMan ? "I'm a boy" : "I'm a girl");

        // Declare an array
        int[] numbs = {1,2,3};
        // For each loop
        for (int num : numbs){
            System.out.println(num);
        }

        // Create an object
        TopicReference myObj = new TopicReference();
        myObj.myPrint();
    }
}
