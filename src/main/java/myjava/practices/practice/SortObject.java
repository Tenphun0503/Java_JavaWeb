package myjava.practices.practice;

import myjava.practices.basic.Student;

import java.util.Arrays;
import java.util.Comparator;

public class SortObject {
    public static void main(String[] args) {
        Student s1 = new Student("Jack", 29);
        Student s2 = new Student("Jack", 18);
        Student s3 = new Student("Zack", 23);
        Student s4 = new Student("Daniel", 23);
        Student s5 = new Student("Rose", 29);

        Student[] students = {s1,s2,s3,s4,s5};

        // sort by age first, then by name
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int res = Integer.compare(o1.getAge(), o2.getAge());
                return res == 0? o1.getName().compareTo(o2.getName()) : res;
            }
        });

        System.out.println(Arrays.toString(students));

        // sort by name first, then by age with lambda
        Arrays.sort(students, (o1, o2) ->{
            int res = o1.getName().compareTo(o2.getName());
            return res==0 ? o1.getAge() - o2.getAge() : res;
        });

        System.out.println(Arrays.toString(students));
    }
}
