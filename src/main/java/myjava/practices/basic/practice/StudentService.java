package myjava.practices.basic.practice;

import myjava.practices.basic.domain.Student;

import java.util.*;

public class StudentService {
    public void sortByName(ArrayList<Student> students){
        Collections.sort(students, new Comparator<Student>(){
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });
    }

    public void sortByAge(ArrayList<Student> students){
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.getAge(), s2.getAge());
            }
        });

    }

    private void addStudentByInput(ArrayList<Student> students) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input name");
        String name = sc.next();
        System.out.println("Input age");
        int age = sc.nextInt();
        students.add(new Student(name, age));
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Zack", 18));
        students.add(new Student("Cathy", 19));
        students.add(new Student("Rose", 17));
        System.out.println(students);

        StudentService ss = new StudentService();
        ss.sortByAge(students);
        System.out.println(students);
        ss.sortByName(students);
        System.out.println(students);
    }
}
