# Java Basics
### [Code Reference](https://github.com/Tenphun0503/Practices_Java/blob/main/src/TopicReference.java)

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
- `variable = (condition) ? expressionTrue : expressionFalse;`

### Array
1. Declare
- `type[] variableName = { };`
- `type[][] variableName = {{},{},...};`
2. For-Each Loop
- `for (type variableName : arrayName);`

### [ArrayList](https://www.w3schools.com/java/java_arraylist.asp)
1. Declare
- `ArrayList<type> myArrayList = new ArrayList<type>();`
2. Methods
- `add(value)`
- `get(index)`
- `set(index, value)`
- `remove(index)`
- `clear()`
- `size()`
3. A String in Java is an object (not a primitive type). 
To use other types, you must specify an equivalent [**wrapper class**](https://www.w3schools.com/java/java_wrapper_classes.asp)  
4. Can be sorted using `sort()` of `Collections`

### [HashMap](https://www.w3schools.com/java/java_hashmap.asp)
1. Declare
- `HashMap<type, type> myHashMap = new HashMap<type, type>();`
2. Methods
- `put(key, value)`
- `get(key)`
- `remove(key)`
- `clear()`
- `size()`
- `keySet() //All the keys`
- `values() //All the values`

### HashSet
A collection of items where every item is unique.
1. Declare
`HashSet<type> myHashSet = new HashSet<type>();`
1. Methods
- `add(value)`
- `contains(value) //check if a value exists`
- `remove(value)`
- `clear()`
- `size()`

### Others
- User Input ([Scanner](https://www.w3schools.com/java/java_user_input.asp))
- Use `Iterator` to create an iterator to loop through collections
- `Iterator` can remove items in the looping, which `for` can't do
- a wrapperClass.typeValue() can get corresponding value:   
```
Integer myInt = 5;
int myIntValue = myInt.intValue()
```
- wrapper class can use `toString()` and `length()`