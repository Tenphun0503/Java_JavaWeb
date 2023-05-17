# Design Pattern
A design pattern is a reusable solution to a recurring problem that arises during software design and development.
Design patterns provide a structured and proven approach to solving common software design problems by defining a set of best practices that can be applied to different situations.

---
### _[1. Singleton pattern](#Singleton)_
### _[2. Factory pattern](#Factory)_
### _[3. Adapter pattern](#Adapter)_
### _[4. Template pattern](#Template)_


---
## Singleton
The Singleton pattern ensures a class has only one instance and provides a global point of access to that instance. 
It is commonly used in scenarios where only a single instance of a class is required to control actions or coordinate activities throughout a system.
- Define a `private` `static` object;
- `private` constructor;
- Define a `static` `synchronized` `getInstace()` method;
- Override `clone()` method (implement `Coneable`)

---
## Factory

---
## Adapter
This pattern converts the interface of one class into another interface that clients expect, 
allowing classes with incompatible interfaces to work together.
- For example, use an abstract class implements an interface, and then extends the abstract class so that we don't have to implement all methods in the interface;

---
## Template
This pattern defines the skeleton of an algorithm in a method, deferring some steps to subclasses. 
It allows subclasses to redefine certain steps of an algorithm without changing the algorithm's structure.