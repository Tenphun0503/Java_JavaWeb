# Object-Oriented Programming
### *class and object, inheritance, polymorphism, encapsulation, abstraction*

---
## Class
- Follow the Big camel naming convention

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

## Encapsulation
Encapsulation is a key concept in OOP that allows bundling data and methods within a class and controlling access to them from outside the class.

### [Modifier](https://www.w3schools.com/java/java_modifiers.asp)
In Java, encapsulation is achieved by using access modifiers such as private, public, protected,
and default to control the visibility of data members and methods in a class.
#### Access Modifier
1. `private`: can only be accessed within the class where it is declared
2. `(default)`: can be accessed by the classes within the same packages
3. `protected`: can be accessed by the classes within the same package and the subclasses, even if they are in a different package.
4. `public`: can only be accessed by any other class
#### Non-Access Modifier
1. `static`: can be accessed without creating an object
2. `final`: use if you don't want to overwrite existing values.
    - `final int myNum = 15;`
3. `abstract`

## Inheritance
- `extends`: inherit from a class  
```
class subClass extends superClass
```

## Abstraction, Interface
- Abstract class: `extends`
- Interface class: `implements`

