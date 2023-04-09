# Java & JavaWeb
[Reference: w3schools](https://www.w3schools.com/java/default.asp)

---
### *This repository contains my notes of Java and JavaWeb*

---
### Outline
<table>
    <tr>
        <th>Topic</th>
        <th>Description</th>
    </tr>
    <tr>
        <td><a href="topics/1_JavaBasics.md">Java Basics</a></td>
        <td>Variables and data types, control structures, methods and functions, arrays and collections</td>
    </tr>
    <tr>
        <td><a href="topics/2_CollectionsMaps.md">Collections and Maps</a></td>
        <td>Collections and Maps</td>
    </tr>
    <tr>
        <td><a href="topics/3_ObjectOrientedProgramming.md">Object-Oriented Programming</a></td>
        <td>Classes and objects, inheritance, polymorphism, encapsulation, abstraction</td>
    </tr>
    <tr>
        <td><a href="topics/4_DesignPattern.md">Design Pattern</a></td>
        <td>Design Patterns and their purpose and use case.</td>
    </tr>
    <tr>
        <td><a href="topics/5_CommonAPI.md">Common API</a></td>
        <td>Object, Math, System, BigDecimal</td>
    </tr>
    <tr>
        <td><a href="#exceptions">Exception Handling</a></td>
        <td>Handling exceptions, try-catch-finally blocks</td>
    </tr>
    <tr>
        <td><a href="topics/5_InputAndOutput.md">Input and Output</a></td>
        <td>Reading and writing files, working with streams</td>
    </tr>
    <tr>
        <td><a href="#threads">Multithreading and Concurrency</a></td>
        <td>Creating and managing threads, synchronization and locks</td>
    </tr>
    <tr>
        <td><a href="topics/6_JavaWeb.md">Java Web</a></td>
        <td>Quick look of database, the front end. Web-related knowledge</td>
    </tr>
    <tr>
        <td><a href="topics/7_ToolsAndFrameworks.md">Tools and Frameworks</a></td>
        <td>Build tools like Maven or Gradle, unit testing frameworks like JUnit or TestNG, web frameworks like Spring or Struts</td>
    </tr>
</table>

---
<div id="exceptions">

### [Exceptions](https://www.w3schools.com/java/java_try_catch.asp)
#### try, catch, finally
```
try{
    // try to execute some code
} catch (Exception e) {
    // do this if catch an error
} finally {
    // do this after try...catch
}
```
#### throw
`throw` lets you define custom errors: 
- `throw new ExceptionType("custom error")`
```
if (age < 18){throw new ArithmeticException("Access denied");}
```
</div>

<div id="threads">

### [Threads](https://www.w3schools.com/java/java_threads.asp)
Thread allows doing multiple things at the same time
- two ways to create a thread: `extends` and `implement`
- use `implement`, you can still extend other class, like:
- `MyClass extends OtherClass implements Runnable`
#### Concurrency Problem
- use `isAlive()`
</div>

### [Regular Expression](https://www.w3schools.com/java/java_regex.asp)
`java.util.regex`
- `Pattern`
- `Matcher`
- `PatternSyntaxException`

### [Lambda Expression](https://www.w3schools.com/java/java_lambda.asp)
`parameter -> expression`

```
ArrayList<Integer> numbers = new ArrayList<Integer>();
numbers.forEach( (n) -> { System.out.println(n); } );
```