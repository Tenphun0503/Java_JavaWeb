package myjava.basic;

import java.util.*;

public class test {
    public static void main(String[] args) {
        /*
            Collection & Map
            1. Collection: List & Set
                1.1 List: ordered, indexed, elements can be repeated
                    1.1.1 ArrayList: implemented by array, easy to search,
                    1.1.2 LinkedList: implemented by linkedList, easy to add or remove at the head or tail
                1.2 Set: unordered, not indexed, elements cannot be repeated
                    1.2.1 HashSet: implemented by hash table

            2. Map
                2.1 HashMap: implemented by hash table
         */


        LinkedList<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        Collections.sort(list);
        System.out.println(list);

        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        System.out.println(map);

        Student stu = new Student("wwt", 'F', 23);
        Student t1 = new Student("Jack",'M', 29);
        Student t2 = new Student("Jack",'M', 18);
        Student t3 = new Student("Zack",'M', 23);
        Student t4 = new Student("Daniel",'M', 23);
        Student t5 = new Student("Rose",'F', 29);

        ArrayList<Student> list1 = new ArrayList<>();
        list1.add(stu);
        list1.add(t1);
        list1.add(t2);
        list1.add(t3);
        list1.add(t4);
        list1.add(t5);

        System.out.println(list1);

        // lambda: () -> {}
        list1.sort(Comparator.comparingInt(Student::getAge));
        System.out.println(list1);

        list1.sort(Comparator.comparing(Student::getName));
        System.out.println(list1);

        list1.sort((o1, o2) -> {
            int i = Character.compare(o1.getGender(), o2.getGender());
            // condition ? true : false
            i = i == 0 ? o1.getName().compareTo(o2.getName()) : i;
            i = i == 0 ? Integer.compare(o2.getAge(), o1.getAge()) : i;

            return i;
        });

        System.out.println(list1);
    }
}


class Student{
    private String name;
    private Character gender;
    private int age;
    
    public Student(String name, Character gender, int age){
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    
    public void setGender(Character gender){
        this.gender = gender;
    }
    public Character getGender(){
        return gender;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    
    public Student(){
        
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
