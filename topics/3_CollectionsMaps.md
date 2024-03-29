# Collections and Maps

---
### _[1. Collection](#Collection)_
### _[2. List](#List)_
### _[3. ArrayList](#ArrayList)_
### _[4. LinkedList](#LinkedList)_
### _[5 Note: Tree](#Tree)_
### _[6. Set](#Set)_
### _[7. HashSet](#HashSet)_
### _[8. LinkedHashSet](#LinkedHashSet)_
### _[9. TreeSet](#TreeSet)_
### _[10. Map](#Map)_
### _[11. HashMap](#HashMap)_
### _[12. LinkedHashMap](#LinkedHashMap)_
### _[13. TreeMap](#TreeMap)_
### _[14. Collections](#Collections)_

---
## Intro
1. Collections take single elements and Maps take entries (Key-Value).  
2. Collection(I):
   - List(I): Elements in the List are ordered, not unique, indexable;
     - ArrayList(C)
     - LinkedList(C)
     - Vector(C)
   - Set(I): Elements in the Set are unordered, unique, not indexable;
     - HashSet(C)
     - LinkedHashSet(C)
     - TreeSet(C)
3. Map(I):
   - HashMap(C)
     - LinkedHashMap(C)
   - TreeMap(C)


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
- `E get(int index)`: get element at index position
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
### Unmodifiable list
- unmodifiable list can not be added, removed, etc.
- `static <E> List<E> of(E...e)`

---
## ArrayList
Implemented by array
### Features
1. Array: query is fast, deletion is slow, insertion is super slow
2. Array in memory is a continuous space, so address of arr[i] is address of arr plus i;
### Underlying Principle
1. with default constructor, create a array with capacity of 0 `Object[] elementData = {}`
2. when adding the first element, ArrayList create an array with capacity of 10
3. when running out of capacity of 10, expand capacity by 1.5
4. when adding multiple elements at once(`addAll()`), and number of them is more than 1.5*10, then create an array with actual size
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
Implemented by double linked list
### Features
1. LinkedList: query is slow, deletion and insertion is fast.
### Exclusive methods
- `public void addFirst(E e)`
- `public void addLast(E e)`
- `public E getFirst()`
- `public E getLast()`
- `public E removeFirst()`
- `public E removeLast()`
### Underlying Principle
1. class Node<E>: item, next, prev;
2. when adding an element, call linkLast(e)
3. linkLast add element at the tail of the linkedList

--- 
## Tree
### BinaryTree
Degree of each node <= 2
### BinarySearchTree
node.left.val < node.val < node.right.val
### BinaryBalancedTree
A BST that height of the left and right subtrees of any node differs by at most one
- when adding a node causes unbalance. Search the unbalanced node from the added node upward to root
- Find the unbalanced node, if number of left sub-nodes less than right part, use left rotation.
- left rotation:
   - make unbalanced node as pivot, it will be replaced by a new node
   - left rotate the pivot as a left child of the new node
   - left rotate the original right child of the pivot as the new node
   - if original right child has left child, make that left child as the right child of the pivot
- right rotation:
   - make unbalanced node as pivot, it will be replaced by a new node
   - right rotate the pivot as a right child of the new node
   - right rotate the original left child of the pivot as the new node
   - if original left child has right child, make that right child as the left child of the pivot
- left and left: if adding a node to the left subtree of the left subtree of the root causes unbalance
   - make one right rotate on the root
- left and right: if adding a node to the right subtree of the left subtree of the root causes unbalance
   - left rotate the left subtree of the root (it becomes ll) and then right rotate the root
- right and right: if adding a node to the right subtree of the right subtree of the root causes unbalance
   - make one left rotate on the root
- right and left: if adding a node to the left subtree of the right subtree of the root causes unbalance
   - right rotate the right subtree of the root (it becomes rr) and then left rotate the root
### RedBlackTree
- Is a type of self-balancing Binary Search Tree
- Key properties:
   - each node must be red or black
   - root must be black
   - In a Red-Black Tree, a **Nil** node is a special type of node that represents a null or empty node in the tree.
   - Nil can be children of the leaves or parent of the root, and should be black.
   - if a node is red, its children must be black
   - black-height: for every node, the path from it to all of its leaves(Nils) should have same amount of black nodes.
- Adding a node
   1. by default, the added node should be a red node, use it as current node.
   2. if current node is root
      - change it to black
   3. if parent of current node is black
      - do nothing
   4. if parent of current node is red
      - if uncle is red:
         1. set parent black, set uncle black
         2. set grandparent red
         3. use grandparent as current node, and do all the previous steps again
      - if uncle is black, and current node is right child of the parent
         1. set parent as current node and left rotate it, and do all the previous steps again
      - if uncle is black, and current node is left child of the parent
         1. set parent as black
         2. set grandparent as red
         3. right rotate the grandparent

---
## Set
Has no order, no duplicate, no index
### Implementations
1. HashSet: no order, no duplicate, no index
2. LinkedHashSet: **ordered**, no duplicate, no index
3. TreeSet: **sortable**, no duplicate, no index
### Unmodifiable set
- unmodifiable set can not be added, removed, etc.
- `static <E> Set<E> of(E...e)`

---
## HashSet
Implemented by hashtable.
### HashCode
- **Hash code**: A unique numeric value that is generated by a hash function.
- In java, is an int value, and the function `hashCode()` defined in Object class, but can be overridden
- Features:
  - if `hashCode()` is not overridden, different objects have different hashCode (depends on address)
  - if `hashCode()` is overridden, different objects have same hashCode as long as they have same attributes.
  - in some cases, different addresses or attributes bring same hashCode (Hash Collision) (e.g. "abc" "acD")
### Underlying Principle
1. Before JDK8: Array + linkedList
   - Create a `length=16`, `loadFactor=0.75` array named `table`
   - when adding a value, compute the index of where it should go: `int index = (length - 1) & hashCode`
   - if `table[index]` is null, insert; 
   - if `table[index]` is not null, compare hashCode && `equals()` 
     - if same, end the insertion
     - if !same, put new element in the array, old element linked after the element
   - if `table` stores `16*0.75=12` elements, it expands the length by double of original size
2. After JDK8: Array + LinkedList + RedBlackTree
   - same step as above but if `!equals()`, linked new element after the old one
   - if `linkedList.size() > 8` and `length > 64`, linkedList will turn to RedBlackTree

---
## LinkedHashSet
ordered: the order of insertion and query is same
### Underlying Principle
- same as above, but use a double linked list to connect each added element
  - the first added element is the head of the linked list and the last added one is the tail
  - traversal the set by traversal the linked list rather than index of the array

---
## TreeSet
implemented by Red-Black Tree, so it is sorted
### Features
- for numeric types, sorts from ascending
- for char, string, sorts from ascending according to ASCII table
- for self-defined class, have to implements Comparable interface and override `compareTo()`
- also can create a comparator when creating the TreeSet

---
## Map
### Common Methods
- `V put(K key, V value)`
- `V get(Object key)`
- `V remove(Object key)`
- `void clear()`
- `boolean containsKey(Object key)`
- `boolean containsValue(Object value)`
- `boolean isEmpty()`
- `int size()`
### Traversal Methods
1. use **keys**: `map.keySet()` get set of keys, and use keys traversal each value
2. use **entries**: `entrySet()` get all entries, and then use `getValue()` and `getKey()`
3. use **lambda**: `forEach(BiConsumer<? super K, ? super V? action)`
### Unmodifiable map
- unmodifiable map can not be added, removed, etc.
- `static <K, V> Map<K, V> of(K k1, V v1)`
- `of()` of Map can take max up to 20 parameters, which are 10 entries. 
- But can use `ofEntries()` to input more than 10 entries.
- From JDK10, we can use `copyOf()` to create an immutableMap from a map

---
## HashMap
Implemented by HashTable. All keys have no order, are unique and are not indexed.
### Underlying Principle
- Same as hashSet
- But this time, create an entry object that records key and value, and store the entry in the array
- the computation of index doesn't involve value of the entry
- when `equal()` two objects with same index, only compare their keys

---
## LinkedHashMap
All keys are ordered
### Underlying Principle
- same as linkedHashSet

---
## TreeMap
All keys are sorted
### Underlying Principle 
- same as TreeSet

---
## HashTable

---
## Properties

---
## Collections
the `java.util.Collections` class provides a set of utility methods for working with collections.
### Common Methods
- `public static <T> boolean addAll(Collection<T> c, T... elements)` `elements` is a length-variable parameter
- `public static void shuffle(List<?> list)`: shuffles the elements in a List.
- `public static <T> void sort(List<T> list)`
- `public static <T> int binarySearch(List<T> list, T key)`
- `public static <T> void copy(List<T> dest, List<T> src)`
- `public static <T> int fill(List<T> list, T obj)`
- `public static <T> void max/min(Collection<T> coll)`
- `public static <T> swap(List<?> list, int i, int j)`

---
## Stream
### Features
stream will be closed after one operation, so better to use chain programming. (don't have to record intermediate value)
### Common Methods
- `default Stream<E> stream()` e.g. `list.stream()`
- `public static<T> Stream<T> stream(T[] array)`  : for array
- `public static<T> Stream<T> of (T... values)`
- `Stream<T> filter(Predicate<? super T> predicate)`
- `Stream<T> limit(long maxSize)`
- `Stream<T> skip(long n)`
- `Stream<T> distinct()`
- `static <T> Stream <T> concat(Stream a, Stream b)`
- `Stream<R> map(Function<T, R> mapper`
- `void forEach(Consumer action`
- `long count()`
- `toArray()`: put in array
- `collect(Collector collector)`: put in collection
  - `Collector.toList()`
  - `Collector.toSet()`
  - `Collector.toMap`
```java
class Example{
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "Jack", "Jenny", "Rose", "John", "Lisa", "Lisa");
        
        list.stream().foreach(s-> System.out.println(s));                   // create stream and print each element 
        list.stream().filter(s->s.startsWith("J"));                         // filter names start with J
        list.stream().filter(s->s.startsWith("J")).filter(s->s.length==4);  // filter names start with J then filter length of 4
        
        list.stream().limit(3);         // get first 3 elements
        list.stream().skip(3);          // skip first 3 elements
        
        list.stream().distinct();       // element deduplication, based on hashCode() and equals(), so have to override
        
        Stream.concat(list.stream(), list.stream());    // concat two streams
    }
}
```
- `map()` and `toArray()` 
```java
class Example{
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "Jack-15", "Jenny-18", "Rose-16", "John-19", "Lisa-20");
        
        // get age of each person
        list.stream().map(new Function<String, Integer>() {
           @Override
           public Integer apply(String s){
               return s.split("-")[1];
           } 
        });
        
        // with lambda
        list.stream().map(s -> s.split("-")[1]).forEach(s-> System.out.println(s));
        
        // toArray()
        // IntFunction generic: the type wanted to turn to
        // apply() para: size of the array
        String[] ages = list.stream().map(s -> s.split("-")[1]).toArray(new IntFuction<String[]>() {
            @Override
            public String[] apply(int value){
                return new String[value];
            }
        });
        // with lambda
        String[] list1 = list.stream().toArray(v-> new String[v]);
        // with method reference
        String[] list2 = list.stream().toArray(String[]::new);
    } 
}
```
- Collect to Map (key should be unique)
```java
class Example {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "Jack-15", "Jenny-18", "Rose-16", "John-19", "Lisa-20");
        
        // toMap() takes two paras
        //      1. key generation definition
        //      2. value generation definition
        // Function generics:
        //      1. type of element in the stream
        //      2. type of key, value in the map
        Map<String, Integer> map = list.stream().collect(Collectors.toMap(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.split("-")[0];
            }
        }, new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s.split("-")[1]);
            }
        }));
        
        // with lambda
        Map<String, Integer> map = list.stream().collect(Collectors.toMap(
                s -> s.split("-")[0],
                s -> Integer.parseInt(s.split("-")[1])
        ));
    }
}
```