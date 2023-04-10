# Collections and Maps

---
### _[1. Collection](#Collection)_
### _[2. List](#List)_
### _[3. ArrayList](#ArrayList)_
### _[4. LinkedList](#LinkedList)_
### _[2. HashMap](#HashMap)_
### _[3. HashSet](#HashSet)_

---
## Intro
1. Collections take single elements and Maps take pairs.  
2. Collection(I):
   - List(I)
      - ArrayList(C)
      - LinkedList(C)
      - Vector(C)
   - Set(I)
      - HashSet(C)
         - LinkedHashSet(C)
      - TreeSet(C)
3. Elements in the List are ordered, not unique, indexable;
4. Elements in the Set are unordered, unique, not indexable;


---
## Collection
### Common Methods
- `public boolean add(E e)`
- `public void clear()`
- `public boolean remove(E e)`
- `public boolean contains(Object obj)`
- `public boolean isEmpty()`
- `public int size()`
### Traversal Method
1. Iterator
   - `Iterator<E> iterator`
   - `boolean hasNext()`
   - `E next()`
   - `void remove()`
2. for-each
3. Lambda
   - `default void forEach(Consumer<? super T> action`
   - e.g. `collection.forEach(e->System.out.println(s))` (e is each element in the collection)

---
## List
### Common Methods
- `void add(int index, E element)`: insert element to index position
- `E remove(int index)`: remove element at index position
- `E set(int index, e element)`: set element at index position and return the original value
- `E get(int intdex)`: get element at index position
### Traversal Method
1. Iterator
2. List iterator
   - `ListIterator<E> iterator`
   - `add(<E> e)`
   - `hasPrevious()`
   - `previous()`
3. for-each
4. Lambda
5. normal for loop (since List is indexed)

---
## ArrayList
1. Declare
    - `ArrayLst list = new ArrayList()`
    - `ArrayList<type> myArrayList = new ArrayList<>();`
2. `ArrayList` is created with a default capacity of 10.
3. Once it needs more capacity, it copies all values to a new List with 1.5 of capacity than original one
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

---
## LinkedList

---
## HashSet
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
## HashMap
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

