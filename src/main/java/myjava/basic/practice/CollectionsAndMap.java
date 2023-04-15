package myjava.basic.practice;

import java.util.*;

public class CollectionsAndMap {
    public static void collection(){
        /*
            Collection is a single column collection
            Two Categories: List and Set
            - List is ordered, can be duplicated, and is indexed
            - Set is unordered, unique and no-indexed
            List is implemented as ArrayList and LinkedList
            Set is implemented as HashSet, LinkedHashSet and TreeSet
         */

        /*
            ArrayList is implemented by array
            It is efficient to query but slow for adding and deleting
         */
        ArrayList<Integer> arrayList = new ArrayList<>();
        // add() to add
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(2);
        System.out.println("ArrayList: " + arrayList);
        /*
            LinkedList is implemented by linkedList
            It is efficient to add and delete at the head or tail
            but slow for query
         */
        LinkedList<Integer> linkedList = new LinkedList<>();
        // use addAll to add a list
        linkedList.addAll(arrayList);
        StringJoiner sj = new StringJoiner(", ","[","]");
        for (Integer listNode : linkedList) {
            sj.add(listNode.toString());
        }
        System.out.println("LinkedList: " + sj);
        /*
            HashSet is implemented by array, linkedList, red-blackTree
            Since it use hashcode to compute index, it's efficient to query
            HashSet is unordered, and every element is unique
         */
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(3);
        hashSet.add(2);
        hashSet.add(1);
        System.out.println("HashSet " + hashSet);
        /*
            LinkedHashSet is implement by array, linkedList, red-blackTree
            But it uses one double-linked-list to record adding order,
            so it is order rather than HashSet
         */
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(1);
        linkedHashSet.add(3);
        linkedHashSet.add(2);
        System.out.println("LinkedHashSet " + linkedHashSet);
        /*
            TreeSet is implemented by red-blackTree, which is a BST
            So TreeSet is sorted
         */
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(2);
        System.out.println("TreeSet " + treeSet);

        // iterate a collection, we have multiple ways
        // Iterator
        Iterator<Integer> it = arrayList.iterator();
        System.out.println("Iterator Example");
        while(it.hasNext()) System.out.println(it.next());

        // For-each
        System.out.println("For-each Example");
        for (Integer listNode : linkedList) {
            System.out.println(listNode);
        }

        // Lambda
        System.out.println("Lambda Example");
        hashSet.forEach(e-> System.out.println(e));

        // method Reference
        System.out.println("Method Reference");
        linkedHashSet.forEach(System.out::println);
    }

    public static void map(){
        /*
            Map is a Bi-column collection
            Usually has entries composed by key-value
            We usually use HashMap.
         */
        /*
            HashMap is implemented by array, linkedList, red-blackTree
            almost like HashSet but take entries
         */
        HashMap<Integer, String> hashMap = new HashMap<>();
        // we use put to put pairs of value
        hashMap.put(1, "A");
        hashMap.put(3, "C");
        hashMap.put(2, "B");
        System.out.println("HashMap: " + hashMap);

        // to iterate a map, we can do in multiple ways
        // use keySet()
        System.out.println("keySet()");
        hashMap.keySet().forEach(k-> System.out.println(k + " " + hashMap.get(k)));

        // use entrySet()
        System.out.println("entrySet()");
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


    }
    public static void main(String[] args) {
        // collection sample
        collection();
        // map sample
        map();
        
        // Sorting a list/array
        // for example, we have 5 teachers
        Teacher t1 = new Teacher("Jack", 29);
        Teacher t2 = new Teacher("Jack", 18);
        Teacher t3 = new Teacher("Zack", 23);
        Teacher t4 = new Teacher("Daniel", 23);
        Teacher t5 = new Teacher("Rose", 29);

        // we want to sort them, first put them into an array
        ArrayList<Teacher> list = new ArrayList<>();
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        list.add(t5);
        list.forEach(System.out::println);

        // we first sort by name
        Collections.sort(list, new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        list.forEach(System.out::println);

        // Then use lambda, we sort by age
        Collections.sort(list, (o1, o2)-> o1.getAge()-o2.getAge());
        // or use list call sort
        list.sort((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge()));
        list.forEach(System.out::println);
    }
}

class Teacher {
    private String name;
    private Integer age;

    public Teacher() {
    }
    public Teacher(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
