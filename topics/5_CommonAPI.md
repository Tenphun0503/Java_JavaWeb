# Common API

---
### _[1. Object](#Object)_
### _[2. Math](#Math)_
### _[3. System](#System)_
### _[4. BigDecimal](#BigDecimal)_
### _[5. Wrapped Class](#WrappedClass)_
### _[6. Arrays](#Arrays)_

---
## Object
`Object` is the root class for all classes. 
Every class in Java is a subclass of Object, and therefore inherits certain methods from Object.
### Common methods
- `equals(Object obj)`: Compares the object to the specified object for equality and returns true if they are equal.
  - `return (this == equal)`
- `toString()`: Returns a string representation of the object.
  - `return getClass().getName() + "@" + Integer.toHexString(hashCode());`
- `clone()`
- `hashCode()`: Returns a hash code value for the object.
- `getClass()`: Returns the runtime class of the object.
- `wait()`, `notify()`, and `notifyAll()`: Used for inter-thread communication and synchronization.

---
## Math
`Math` class provides a set of static methods for performing common mathematical operations.
### Common methods
- `abs(a)`: Returns the absolute value of a value.
- `ceil(double a)`: Returns the smallest double value that is greater than or equal to the argument and is equal to a mathematical integer.
- `floor(double a)`: Returns the largest double value that is less than or equal to the argument and is equal to a mathematical integer.
- `round(float a)`: Returns the closest int to the argument.
- `max(a, b)`: Returns the greater of two values.
- `min(a, b)`: Returns the smaller of two values.
- `sqrt(double a)`: Returns the square root of a double value.
- `pow(double a, double b)`: Returns the value of the first argument raised to the power of the second argument.
- `random()` return a random value range in [0.0, 1.0)

---
## System
`System` class provides a set of useful methods and variables for interacting with the operating system, the environment, and the Java Virtual Machine (JVM). 
### Common methods
- `exit(int status)`: Terminates the currently running Java Virtual Machine (JVM) with the given exit status. (0: normal shutdown)
- `currentTimeMillis()`: Returns the current time in milliseconds since the epoch (January 1, 1970 00:00:00 UTC).
- `arraycopy(Object src, int srcPos, Object dest, int destPos, int length)`: Copies an array from the specified source array, beginning at the specified position, to the specified position of the destination array.

---
## BigDecimal
`BigDecimal` is a class that provides arbitrary-precision decimal arithmetic. 
It can be used to perform exact decimal calculations with an arbitrary number of digits after the decimal point.
```java
import java.math.BigDecimal;

class Example {
  public static void main(String[] args) {
    double num1 = 0.1;
    double num2 = 0.2;
    System.out.println(num1 + num2);        // 0.30000000000000004    This is not precise

    BigDecimal num3 = new BigDecimal(0.1);  // unpredictable new call
    BigDecimal num4 = new BigDecimal(0.2);  
    System.out.println(num3.add(num4));     // 0.3000000000000000166533453693773481063544750213623046875

    BigDecimal num5 = new BigDecimal("0.1");
    BigDecimal num6 = new BigDecimal("0.2");
    System.out.println(num5.add(num6));     // 0.3

    BigDecimal num5 = new BigDecimal.valueOf(0.1);
    BigDecimal num6 = new BigDecimal.valueOf(0.2);
    System.out.println(num5.add(num6));     // 0.3
  }
}
```
### Common Methods
- `add()`
- `subtract()`
- `multiply()`
- `divide()`
- `divide(BigDecimal divisor, int scale, RoundingMode rm)`: `RoundingMode.UP/DOWN/HALF_UP`
- `doubleValue()`: get double type value

---
## WrappedClass
A wrapped class is a class that provides a way to represent primitive data types as objects.  
- Boxing and Unboxing
  - boxing: int -> Integer: use `public static Integer valueOf(int i)`  
  - unboxing: Integer -> int: use `public in intValue()`  
- from JDK5 
  - boxing: `Integer i = num`
  - unboxing: `int num = i`

### Common Methods
- `toBinaryString(int i)`
- `toOtcalString(int i)`
- `toHexString(int i)`
- `parseInt(String s)`: parse string of number into int type

### Question
when boxing, if the range of the number is -128~127, `==` is true, else is false
```
public static Integer valueOf(int i){
  if (i >= -128 && i <= 127)
    return IntegerCache.cache[i + (-IntegerCache.low)];   // we directly get from an exsited array
      return new Integer(i);          // here we new a object
}
```

```java
class Example{
  public static void main(String[] args) {
    Integer i1 = 127;
    Integer i2 = 127;
    System.out.println(i1 == i2);   // true
    // return IntegerCache.cache[127 + (-(-128))] //cache is a Integer[] with length of 256 
    
    Integer i1 = 129;
    Integer i2 = 129;
    System.out.println(i1 == i2);   // false
    
    
  }
}
```

---
## Arrays
`Arrays` class provides a set of static methods for working with arrays. 
These methods can be used to perform various operations on arrays, such as sorting, searching, and copying.
### Common Methods
- `public static String toString(T[] a)`
- `public static boolean equals(T[], T[] b)`
- `public static int binarySearch(int[], int key)`: Searches the specified array for the specified object using the binary search algorithm.
- `public static void sort(T[] a)`
- `public static void sort(T[] a, Comparator<? super T> c)`: Sorts the specified array of objects according to the order induced by the specified comparator.