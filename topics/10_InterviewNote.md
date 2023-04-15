# Java Technical Interview Note
## 1. [Usage of Collections in coding:](../src/main/java/myjava/basic/practice/CollectionsAndMap.java)
### List, Set, Map (minimum ArrayList, LinkedList, HashMap(hashCode))
1. [Collection](../topics/3_CollectionsMaps.md#collection)(I):
    - List(I): Elements in the List are ordered, not unique, indexable;
        - ArrayList(C): implemented by array. Default length 10, expand by 1.5
        - LinkedList(C): implemented by linkedList
    - Set(I): Elements in the Set are unordered, unique, not indexable;
        - HashSet(C): implemented by hashTable. Java uses Array, linkedList, RedBlackTree(JDK8+). Default length 16, load factor 0.75
        - LinkedHashSet(C): same as HashSet, but use doubleLinkedList to record each added node.
        - TreeSet(C): implemented by redBlackTree
2. [Map](../topics/3_CollectionsMaps.md#map)(I):
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


## 3. Basic algorithm (leetCode easy level)

## 4. Advanced concept in java: OOP, SOLID, MVC, design patterns, multithreading
### [OOP](../topics/2_ObjectOrientedProgramming.md): 
encapsulation, abstraction, inheritance, polymorphism.
### SOLID:
SOLID is a set of design principles that are used to make software more maintainable and easier to extend. The SOLID principles are:
- Single Responsibility Principle (SRP): A class should have only one reason to change.
- Open/Closed Principle (OCP): Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.
- Liskov Substitution Principle (LSP): Subtypes must be substitutable for their base types.
- Interface Segregation Principle (ISP): A client should not be forced to depend on methods it does not use.
- Dependency Inversion Principle (DIP): High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions.
### MVC: 
   - Model:data and business logic
   - View: presenting the data from the Model to the use 
   - Controller: Intermediary between Model and View.
### [Design Patterns](../topics/4_DesignPattern.md)
### [Multithreading](../topics/7_Multithreading.md)

## 5. Basic network (HTTP, TCP)
HTTP requests and responses are typically sent over TCP connections.
### HTTP
HTTP (Hypertext Transfer Protocol) is a protocol used for communication between web servers and clients. 
When a web browser requests a web page from a server, it sends an HTTP request to the server. 
The server then responds with an HTTP response, which includes the requested page or other information.
### TCP
TCP (Transmission Control Protocol) is a protocol that provides reliable, ordered, and error-checked delivery of data between applications running on hosts communicating over an IP network. 
TCP ensures that data is delivered to its destination without errors and in the correct order. 
It also includes mechanisms for congestion control, which helps to prevent network congestion and ensure that network resources are used efficiently.

## 6. Basic DB (SQL, joins, index)
A database is a collection of organized data that can be easily accessed, managed, and updated.
In database management, the most common operations performed on data are Create, Read (Query), Update, and Delete, which are commonly abbreviated as CRUD.
### SQL
SQL (Structured Query Language) is a programming language used to manage relational databases.
- create, modify, and query databases
- creating and modifying tables
- inserting, updating, deleting and retrieving data
### Joins
Joins are used in SQL to combine data from two or more tables based on a related column.
There are different types of joins in SQL: 
- inner join:  Inner join returns only the rows that match between the two tables based on a specified condition
- left join:  left join returns all the rows from the left table and the matching rows from the right table.
- right join: Right join returns all the rows from the right table and the matching rows from the left table
- full outer join: Full outer join returns all the rows from both tables and matches the rows based on a specified condition.
### Index
Indexes are used to speed up the querying process in a database.
An index is a data structure that stores a copy of a subset of the data in a table, organized in a way that allows for faster searches.
When a query is executed, the database can use the index to quickly locate the relevant data, rather than searching through the entire table.
This can greatly improve the performance of queries, especially when dealing with large datasets. 
However, indexes can also slow down data updates and inserts, as the database needs to update the index as well as the table. 