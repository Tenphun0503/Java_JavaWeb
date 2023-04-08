# Input and Output

---
### *Reading and writing files, working with streams*

---

`File` class from the `java.io` allows us to work with files.

- Declare
`File myFile = new File("filename")`
- [Methods](https://www.w3schools.com/java/java_files.asp)
- Usually use `try...catch` block with `java.io.IOException`
```
try{
    File myFile = new File("filename");
} catch (IOException e) {
    // error info
}
```

#### Write to a file
- use `FileWriter` with its `write()` and then `close()`

#### Read a file
- use `Scanner` and its methods like `nextLine()` and then `close()`
