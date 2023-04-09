# Collections

---
### _[1. ArrayList](#ArrayList)_
### _[2. HashMap](#HashMap)_
### _[3. HashSet](#HashSet)_

---
## Collections
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