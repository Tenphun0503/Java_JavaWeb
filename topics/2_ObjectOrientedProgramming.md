# Object-Oriented Programming
### [Code Reference](https://github.com/Tenphun0503/Practices_Java/blob/main/src/main/java/myjava/practices/TopicReference.java)

---
### *Classes and objects, inheritance, polymorphism, encapsulation, abstraction*

---

### Class of Java
1. Must start with an uppercase letter

### Structure
```
class ClassName{
    attributes;
    methods;
}
```

### Attribute
#### Constructors
- Initialize object's attributes.  
- A method named same as the class, and no return type.  
```
class ClassName{
    public ClassName(){}
}
```
- Constructors take parameters
- Set attributes `private` and use `get` and `set` to access or update the value.

### Method 
A method is a block of code which only runs when it is called.  
- Overloading: accept and return different type of value
#### Static vs. Public  
- They are called **[modifier.](https://www.w3schools.com/java/java_modifiers.asp)**  
- `static` means it can be accessed without creating an object  
- `public` can only be accessed by object.

### Inheritance
- `extends`: inherit from a class  
```
class subClass extends superClass
```

### Abstraction, Interface
- Abstract class: `extends`
- Interface class: `implements`

