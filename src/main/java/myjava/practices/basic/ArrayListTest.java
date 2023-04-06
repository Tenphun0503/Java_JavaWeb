package myjava.practices.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest {
    /*
        Create an ArrayList of Student, store 3 student objects
        Traversal the ArrayList
        Name and age of the student scanned from input
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println("Input name");
            String name = sc.next();
            System.out.println("Input age");
            int age = sc.nextInt();
            students.add(new Student(name, age));
        }
        for (Student s:students){
            System.out.println(s);
        }
    }
}
