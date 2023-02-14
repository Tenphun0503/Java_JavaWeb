# Java Basics
### [Reference](https://github.com/Tenphun0503/Practices_Java/blob/main/src/TopicReference.java)

---
### *Variables and data types, control structures, methods and functions, arrays and collections*

---

### Comment in Java
1. Single-line `//`
2. Multi-line `/* */`
3. Document
```
/**
 *  Document comment
 *  Development document description
 */
```

### Variables and data types
1. String
2. int (byte, short, long)
3. float (double)
- `float myNum = 5.75f;`
- `double myNum = 19.99d;`
4. char
5. boolean

### Casting
1. Widening Casting: small to large
- `double myDouble = myInt;`
2. Narrowing Casting: large to small
-  `int myInt = (int) myDouble;`

### Keywords
1. final: use if you don't want to overwrite existing values.
- `final int myNum = 15;`

### Control structures
1. If...Else
2. Switch
3. While Loop
4. For Loop
5. Break/Continue

### Short Hand If...Else
- `variable = (condition) ? expressionTrue : expressionFalse`

### Array
1. Declare
- `type[] variableName = { }`
- `type[][] variableName = {{},{},...}`
2. For-Each Loop
- `for (type variableName : arrayName)`

### Method
A method is a block of code which only runs when it is called.
1. `static` means that the method belongs to the class and not an object of the class.
2. Overloading
