# Java Basics

---
### _[1. datatype](#Datatype)_
### _[2. methods](#Method)_
### _[3. operator](#Operators)_
### _[4. control structure](#ControlStructures)_
### _[5. array](#Array)_
### _[6. string](#String)_
### _[7. collections](#Collections)_

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

---
### Datatype
1. int (byte, short, long)
   - `int a = 2`
   - `long b = 2L`
2. float (double)
   - `float myNum = 5.75f;`
   - `double myNum = 19.99;`
3. char
4. boolean
5. String

### Casting
1. Widening Casting: small to large
   - `double myDouble = myInt;`
2. Narrowing Casting: large to small
   - `int myInt = (int) myDouble;`
- See example:
    ```java
    class TypeCasting(){
        public static void main(String[] args) {
            byte a = 3, b = 4;
            byte c = a + b;             // This will cause error 
            //byte c = (byte)(a + b)    // byte is promoted into int when involved in mathematical operation.
                                        // Same for short and char type
  
            byte d = 3 + 4;             // This won't cause error 
                                        // a and b are variables, but 3 and 4 are constant. 
                                        // Java has constant propagation optimization
                                        // 3 + 4 is computed at compile time (javac).
                                        // It equals to byte d = 7;
  
            a += 1;                     // This won't cause error
                                        // This equals to a = (byte)(a + 1);
        }
    }
    ```

---
### Method
1. Use small camel naming convention
2. Method Overloading: different number/type/order of parameters
```java
class Example(){
   // Method Overloading
   int sumOfNum(int x, int y){return x + y;}
   float sumOfNum(float x, float y){return x + y;}
}

```

---
### Operators
1. &&-like are logical operators
2. &-like are bitwise operators
3. ^ is bitwise XOR operators
   - a ^ b ^ b = a
   ```java
    class Example(){
        public static void main(String[] args){
            int a = 10; b = 20;
            a = a ^ b;                  // a = 10 ^ 20
            b = a ^ b;                  // b = 10 ^ 20 ^ 20 = 10
            a = a ^ b;                  // a = 10 ^ 20 ^ 10 = 20
            System.out.println(a);      // a = 20
            System.out.println(b);      // b = 10
        }
    }
   ```
   
### Ternary operator
- `variable = (condition) ? expressionTrue : expressionFalse;`

---
### Memory space
In Java, memory is managed automatically by the Java Virtual Machine (JVM), 
which provides automatic garbage collection. The JVM divides the memory into 5 areas;
1. **Method Area:** The method area is a section of memory that stores class-level data,
   such as class definitions, method and field names, and static variables.
   It is shared among all threads and is created at JVM startup.
2. **Stack:** Each thread in the JVM has its own stack, which is used to store local variables and method calls.
   When a method is called, a new frame is added to the top of the stack, which contains the local variables and method arguments.
   When the method returns, the frame is removed from the stack.
3. **Heap:** The heap is the area of memory where objects are allocated.
   It is a large pool of memory that is shared among all threads in the JVM. Objects are created on the heap using the "new" keyword,
   and they are automatically garbage collected when they are no longer referenced.
4. **Program Counter:** The program counter is a register in the JVM that stores the address of the current instruction being executed.
5. **Native Heap:** The native heap is a separate memory space outside the JVM that is used to allocate native objects, 
such as those created by JNI (Java Native Interface) calls. This memory is not automatically managed by the JVM and must be explicitly freed by the program.
```java
class Example{
   public static void main(String[] args) {
      int number = 100;
      System.out.println(number);           // number = 100
      change(number);
      System.out.println(number);           // number = 100
   }
   public static void change(int number){
       number = 200;
   }
}
```
> int variable store in stack with their value. 
> 'number' in change() is only a local variable passed in and will be released them when exit the method. 
> If number is an array, the result changes.
```java
class Example{
   public static void main(String[] args) {
      int[] array1 = {1, 2, 3};
      int[] array2 = array1;
              array2[0] = 0;
              System.out.println(array1[0]);        // array1[0] = 0
   }
}
```
> Variables store in the stack, they record the address, where the object are allocated in the heap.

---
### ControlStructures
1. If...Else
2. Switch case 
   - control flow fall-through if case doesn't contain `break`
   - can be used to execute same action for multiple case.
   - same as `case 1,2,3,4` for JDK above 14
   - simplify the switch code
   ```java
    public class Example{
        public static void main(String[] args){
            int week = 3;
            switch (week){
                case 1, 2, 3, 4, 5 -> System.out.println("Weekday");
                case 6, 7 -> System.out.println("Weekend");
                default -> System.out.println("Error"); 
            } 
        }   
    }
   ```
   - use a labeled break statement to break out of a nested loop, and specify which loop to break out of by using the label.
   ```
   label: {
    // code block
    break label;
   }
   ```
   - Or we can use `System.exit(0)` to stop the JVM.
3. For Loop: 
   - `5.fori` == `for (int i=0; i<5; i++)` 
4. While loop, do while loop
5. Break/Continue

---
### Array
1. Declare
   - `type[] variableName = new type[]{ };` simplify as `type[] variableName = { };`
   - `type[][] variableName = {{},{},...};`
   - Dynamically initialize: `type[] variableName = new type[5]`
2. Print a int[], we get `[I@27d6c5e0`
   - `[`: This is an array; `@`: separate symbol; `I`: int type; `27d6c5e0`: memory address in hex
   - if we print int[][], we get `[[I@...`
3. Default value for using dynamically initialize an array:
   - integer: 0
   - decimal: 0.0
   - boolean: false
   - char:    '\u0000'
   - String(reference type):  null 
4. For-Each Loop
   - `for (type variableName : arrayName);`
5. Exceptions:
   - `ArrayIndexOutOfBoundsExcpetion`
   - `NullPointerException`

---
### String
1. Immutable: String object can't be modified after creation. But can be replaced by another String object.
2. String objects can be shared in a special area of memory called the "String Constant Pool". 
When you create a string literal, it is automatically added to the pool. 
If you create a new string object with the same value as an existing string in the pool, 
the new object will actually reference the existing object in the pool rather than creating a new object
3. Constructors:
   1. `public String()`
   2. `public String(char[] chs)`
   3. `public String(String original)`
4. Common method
   1. `String.equals()`
   2. `String.equalsIgnoreCase()`
   3. `toCharArray()`
   4. `charAt()`
   5. `substring()`
   6. `replace()`
   7. `split()`: `.` means anything, so if you want to split based on `.`, use`\\.`
```java
class  Example(){
   public static void main(String[] args) {
      String s1 = "abc";                    // s1 reference to address of string literal "abc" in String Constant Pool
      String s2 = new String("abc");        // s2 reference to address of String object in heap
                                            // which has a copy of "abc" in the pool
      System.out.println(s1 == s2);         // false
   }
}
```
```java
class Example(){
   public static void main(String[] args) {
      String s1 = "abc";
      String s2 = "ab";
      String s3 = s2 + "c";                 // In heap memory, a StringBuilder is created to concatenate "ab" and "c"
                                            // Then StringBuilder uses toString() create a String object "abc"
                                            // s3 reference to the address of the String object "abc"
      System.out.println(s1 == s3);         // false
   }
}
```
```java
class Example(){
   public static void main(String[] args) {
      String s1 = "abc";
      String s2 = "a"+"b"+"c";              // "a","b","c" are literals, they are combined at compile time
                                            // Java has constant propagation optimization
      System.out.println(s1 == s2);         // true
   }
}
```

### StringBuilder
1. Common Methods
   1. `append()`
   2. `reverse()`
2. Convert to and from String
   1. `StringBuilder sb = new StringBuiler(string)`
   2. `String str = sb.toString()`
3. `StringBuilder` is not safe to use concurrently in multiple threads without proper synchronization (`StringBuffer` is safe)

---
### Collections
- `<>` is used for type inference in **generics**
- `<>` take wrapper class such as `Integer`

### ArrayList
1. Declare
   - `ArrayLst list = new ArrayList()`
   - `ArrayList<type> myArrayList = new ArrayList<>();`
2. Common Methods
   - `boolean add(E e)`
   - `void add(int i, E e)`
   - `E get(int i)`
   - `E set(int i, E e)`:    set value e to index i and return the replaced value
   - `E remove(int i)`
   - `boolean remove(Object o)`
   - `boolean contains(Object o)`
   - `clear()`
   - `size()`
3. `ArrayList` is created with a default capacity of 10.
4. Once it needs more capacity, it copies all values to a new List with 1.5 of capacity than original one
```java
class Example{
   public static void main(String[] args) {
      ArrayList<String> list = new ArrayList<>();
      process(list);                // we pass the address as the argument into the process() method
                                    // so in process(), it references same ArrayList object in the memory
   }
   private static void process(ArrayList<String> list){
       // processing the list
   }
}
```

### HashMap
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
   - `containsKey(key)`

### HashSet
A collection of items where every item is unique.
1. Declare
    `HashSet<type> myHashSet = new HashSet<type>();`
2. Methods
   - `add(value)`
   - `contains(value) //check if a value exists`
   - `remove(value)`
   - `clear()`
   - `size()`

---
### Others
1. To compare string with string literal, we put literal at the front (so we don't have to care if string is null)
   - `"abca".equals(s)`
2. ArrayList.remove(Object o), it removes the first occurrence of the specified element from the list and shifts any subsequent elements to the left. 
So if we iterate the List and remove multiple elements, we'd better iterate from back to front.
Or `i--` everytime after removing.
