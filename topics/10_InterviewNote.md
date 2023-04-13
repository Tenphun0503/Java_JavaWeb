# Java Technical Interview Note
## 1. Usage of Collections in coding:
### List, Set, Map (minimum ArrayList, LinkedList, HashMap(hashCode))
1. [Collection](../topics/3_CollectionsMaps.md)(I):
    - List(I): Elements in the List are ordered, not unique, indexable;
        - ArrayList(C): implemented by array. Default length 10, expand by 1.5
        - LinkedList(C): implemented by linkedList
    - Set(I): Elements in the Set are unordered, unique, not indexable;
        - HashSet(C): implemented by hashTable. Java uses Array, linkedList, RedBlackTree(JDK8+). Default length 16, load factor 0.75
        - LinkedHashSet(C): same as HashSet, but use doubleLinkedList to record each added node.
        - TreeSet(C): implemented by redBlackTree
2. Map(I):
    - HashMap(C): Same as HashSet but use entry as node and based on keys only
        - LinkedHashMap(C): Same as LinkedHashSet but use entry as node and based on keys only
    - TreeMap(C): Same as TreeSet but use entry as node and based on keys only
3. If using hashTable, then self defined class should override `equals()` and `hashCode()`
4. If using redBlackTree, then self defined class should implement `Comparable`, or define `Comparator`

### Sorting a List/Array in a given attribute. 
- Sorting a list of students by age or name.
1. Use of Comparator
   - Anonymous class
   - Lambda
2. Student class implements Comparable and override `CompareTo()`

## 2. Basic Java Coding: String, sub-class, constructor, getter/setter, etc.


## 3. Basic algorithm (leetcode easy level)

## 4. Advanced concept in java: OOP, SOLID, MVC, design patterns, multithreading
1. [OOP](../topics/2_ObjectOrientedProgramming.md): encapsulation, abstraction, inheritance, polymorphism.
2. SOLID:
3. MVC: 
   - Model:data and business logic
   - View: presenting the data from the Model to the use 
   - Controller: Intermediary between Model and View.
4. [Design Patterns](../topics/4_DesignPattern.md)
5. [Multithreading](../topics/7_Multithreading.md)

## 5. Basic network (HTTP, TCP)

## 6. Basic DB (SQL, joins, index)
