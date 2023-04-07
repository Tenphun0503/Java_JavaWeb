# Object-Oriented Programming

---
### _[1. class](#Class)_
### _[2. encapsulation](#Encapsulation)_
### _[3. inheritance](#Inheritance)_
### _[4. abstraction](#Abstraction)_
### _[5. interface](#Interface)_
### _[6. polymorphism](#Polymorphism)_

---
## Class
- Follow the Big camel naming convention
- A java file can have multiple class, but only one public class and its name must be same as the filename

### Structure
```
class ClassName{
    fields;             // variables, attributes
    constructors;
    getter and setter;
    methods;
}
```

### Memory Analyze
For `Student stu = new Student();`
- first `Student` shows in context, loads Student Class into method area
- declare a `stu` by type of `Student`, creates a reference variable in the stack memory
- `new Student` 
  - allocate a block in heap memory for all the fields. 
  - Initialize fields with default values if no explicit initialization is provided. 
- memory address of the newly created Student object is returned by the `new` operator, and this address is stored in the `stu` reference variable in the stack memory.
- we use `this.` to recognize fields and local variables with same names. `this` is a reference variable stored in the stack and its value is the address of the object in the heap

### Constructor
1. A constructor initializes object's attributes.
2. It's a method which named same as the class, and no return type. 
3. Constructors can take parameters 

### Getter and Setter
For the situation below:
```java
public class Student{
    public int age;
}
```
We can access `age` and assign any value to it, like `age = -11`, which is unreasonable.
With Getter and Setter, we can keep the attributes reasonable.
```java
public class Student{
    private int age;
    public void setAge(int age){
        if (age >= 1 && age <= 120) this.age = age;
    }
}
```

### Standard Java Bean
```
class ClassName{
    private attributes;             
    public default constructors;
    public constructors with arguments;
    getter and setter for all attributes;
}
```
> For future development, we only store the data in Java Bean Objects.
> The processing of data(methods) is handed over to other classes to complete

---
## Encapsulation
Encapsulation is a key concept in OOP that allows bundling data and methods within a class and controlling access to them from outside the class.

### Modifier
In Java, encapsulation is achieved by using access modifiers such as private, public, protected,
and default to control the visibility of data members and methods in a class.
#### Access Modifier
1. `private`: can only be accessed within the class where it is declared
2. `(default)`: can be accessed by the classes within the same packages
3. `protected`: can be accessed by the classes within the same package and the subclasses, even if they are in a different package.
4. `public`: can only be accessed by any other class
#### Non-Access Modifier
1. `static`: can modify attributes, methods.
   - `static` members are shared among all instances of the class.
   - `static` members can be accessed directly from the class, without creating an instance of the class.
   - `static` members are initialized when the class is loaded, before any instances of the class are created.
   - when the class is loaded in the method area, memory is allocated for its static attributes in heap memory with default value.
   - `static` methods can be used to implement utility methods. (ToolClass, we can set the constructor private then)
2. `final`:  can modify attributes(can't be modified), methods(can't be overridden), classes(can't be inherited)
   - Primitive datatype: value can't be modified;
   - Referenced datatype: address can't be modified;
   - Constant: the naming convention is to use all capital letters and separate words with underscores
   - use if you don't want to overwrite existing values. 
   - `final int myNum = 15;`

---
## Inheritance
The child classes inherit all non-private attributes (fields) and methods of the parent class.
- `extends`
### Attribute:
- Private attributes and methods of Parent class are not accessible by Children classes
- However, the child class can still indirectly access or modify a private attribute, (e.g. public getter or setter)
- Attribute hiding or Variable shadowing.
  - If a child class defines an attribute with the same name as an attribute in its parent class, the child class attribute will refer to the child class declaration.
  - To refer to the parent class attribute explicitly, you can use the `super` keyword followed by the name of the attribute.
### Override:
- `super.method()` keep the function of method of the parent class.
### Memory
- In Heap memory, a class object has space to store attributes of its parent class 
### Other
- `super()` calls constructor of Parent Class
- `this()` calls constructor (Use to add attributes)
```java
class Parent{
    public Parent(){
        System.out.println("Parent default");
    }
    public Parent(int num){
        System.out.println("Parent parameter");
    }
}
class Child extends Parent{
    // the Child constructor will call the default constructor of the Parent class automatically
    public Child(){
        // implicitly calls the default constructor of its parent class
        // super();
        System.out.println("Child default");        // new Child(), will print:     
                                                    // Parent default
                                                    // Child default
    }
    public Child(int num){
        System.out.println("Child parameter");      // new Child(10), will print
                                                    // Parent default
                                                    // Child parameter
    }
}
```
    
---
## Abstraction
Abstraction focuses on the essential features of an object and ignores all the other details that are not relevant to its use
- Abstract class: `abstract class ClassName{}`
- Abstract method: `abstract Type methodName();`
### Features
- Abstract methods must be in an abstract class
- Child class of an abstract class must override abstract methods, or can be an abstract class too.
- Abstract class can have constructors
- Abstract class can not be instantiated.
- Abstract class can have normal methods
- `abstract` can't be used with `final`, `private`, `static`

---
## Interface
An interface is a collection of abstract methods and constant declarations that define a contract that a class must adhere to if it wants to implement that interface.
- Interface: `interface InterfaceName{}`
### Features
- Child class implements an interface must implements all of its methods, or can be an abstract class.
- Interface has no constructor.
- All member attributes are implicitly `public`, `static` and `final`
- All methods are implicitly `public` and `abstract`
- A class can implements multiple interfaces.
- Interface can `extends` other Interfaces, even more than one Interfaces.
- Usually used to define behavior (e.g. service).

---
## Polymorphism
Polymorphism is the ability of an object to take on many forms. 
Specifically, it refers to the ability of a variable, method, or object to take on different forms depending on the context in which it is used.
```java
interface Service{}
class A implements Service{}
class B implements Service{}
class Example{
    public static void main(String[] args) {
        Service service;
        service = A;                    // we can take different forms depends on different context;
        service = B; 
        //perform service.method()      // if we choose A, we use methods of class A, vice versa.
        
        
        
        // Benefit of polymorphism:
        // we need to write two methods for calling useX method normally,
        // but with declaring as Service and assign with A or B
        // we can call useService and pass any of object of A or B
    }
    public static void useA(A a){}
    public static void useB(B b){}
    public static void useService(Service s){}
}
```
- Parameters of a method can be defined as a parent Class or Interface, then the method can take objects of any child of its as arguments.
- Same object assigned with different child classes can perform different behaviors.
```java
class Parent{
    int num = 10;
    public void show(){
        System.out.println("Parent");
    }
    public static staticMethod(){}
}
class Child extends Parent{
    int num = 20;
    public void show(){
        System.out.println("Child");
    }
    public static staticMethod(){}
}
class Example{
    /*
        Feature of polymorphism access members:    
            For member attributes:  compile based on left, execute based on left
            For member methods:     compile based on left, execute based on right
                                    In case the called method is abstract method in parent
            For static members:     when compiling, it becomes Parent.staticMethod()
     */
    public static void main(String[] args) {
        Parent p = new Child();
        System.out.println(p.num);      // p.num = 10
        p.show();                       // Child
        p.staticMethod();               // this will call Parent.staticMethod at compile time
    }
}
```
- Polymorphism can't call unique methods of children class
- But we can do like follow
```java 
public class Example{
    public static void main(String[] args) {
        Parent p = new Child();
        // child.uniqueMethod();            // will cause error since Parent doesn't have uniqueMethod
        Child c = (Child) p;
        c.uniqueMethod();                   // now it's good to go
    }
}
```
- `instanceof` is a keyword that is used to check if an object is an instance of a particular class or interface.
```java
public class Example {
    public static void main(String[] args) {
        Animal animal1 = new Animal();
        Animal animal2 = new Cat();
        Animal animal3 = new Dog();

        System.out.println(animal1 instanceof Animal);  // Output: true
        System.out.println(animal1 instanceof Cat);     // Output: false
        System.out.println(animal1 instanceof Dog);     // Output: false

        System.out.println(animal2 instanceof Animal);  // Output: true
        System.out.println(animal2 instanceof Cat);     // Output: true
        System.out.println(animal2 instanceof Dog);     // Output: false

        System.out.println(animal3 instanceof Animal);  // Output: true
        System.out.println(animal3 instanceof Cat);     // Output: false
        System.out.println(animal3 instanceof Dog);     // Output: true
    }
}
```
