# Exceptions And Files

---
### _[1. Exceptions](#Exceptions)_
### _[2. File](#File)_
### _[3. IO](#IO)_

---
## Exceptions
### Structure
- java.lang.Throwable
  - Error
  - Exception
    - RuntimeException
      - NullPointerException
      - ArithmeticException
      - ...
    - Others
### Error
- Problem occurs on system level
### Exception
- Problem occurs in program
### RuntimeException
- exceptions that can occur at runtime, rather than being detected by the compiler.
### CheckedException
- exceptions that detected by the compiler
- checked exception must be explicitly caught or `throws`
### Handel
- JVM: output relevant information on the console, and end running
- Catch Exception: `try..catch` 
  - no exception in try -> execute all in try, pass catch
  - multiple exceptions in try -> multiple catch, put parent class at last
  - exception didn't be captured -> JVM handel
  - if exception occurs in try -> pass remain codes in try, execute catch
- Throws/Throw
  - Throws: add after method name
  - Throw: write in method
- Self-defined Exception
  1. define a exception class
  2. extends from parent class
  3. default constructor
  4. params constructor 
### Throwable member methods
- `public String getMessage()`: return exception message
- `public String toString()`: return all exception info
- `public void printStackTrace()`: print exception info on console

---
## File
### Constructor
- `public File(String path)`
- `public File(String parent, String child)`
- `public File(File parent, String child)`
### Common methods
- if and getting
  - `public boolean isDirectory()`
  - `public boolean isFile()`
  - `public boolean exists()`
  - `public long length()`: return the size of the file (byte)
  - `public String getAbsolutePath()`
  - `public String getPath()`
  - `public String getName()`
  - `public long lastModified()`
- Create and delete
  - `public boolean createNewFile()`: if file exists, return false; if dir doesn't exist, throw exception
  - `public boolean mkdir()`
  - `public boolean mkdirs()`: multiple level directions
  - `public boolean delete`
- traversal
  - `public static File[] listRoots()`
  - `public String[] list()`
  - `public String[] list(FilenameFilter filter)`
  - `public File[] listFiles()`: list files
  - `public File[] listFiles(FileFilter filter)`
  - `public File[] listFiles(FilenameFilter filter)`

---
## IO
- By direction
  - input
  - output
- By streams
  - Byte streams
    - InputStream(I)
      - FileInputStream
        - `int read()`
      - BufferedInputStream
    - OutputStream(I)
      - FileOutputStream
        - `void write(int b)`
        - `void write(byte[] b)`
        - `void write(byte[] b, int off, int len)`
      - BufferedOutputSteam
  - Character streams
    - Reader(I)
      - FileReader
      - have a buffer size as 8192, first read as much as into buffer
    - Writer(I)
      - FileWriter  
        - have a buffer size as 8192, first write into buffer, and when
          - buffer is full, write into file
          - use `flush()`, write into file
          - use `close()`, write into file and cut the connection
```java
class Example {
    public static void main(String[] args) {
        FileInputStream fis = new FileInputStream("path\\file.txt");
        FileOutputStream fos = new FileOutputStream("path\\copy.txt");

        byte[] bytes = new byte[1024]; // read 1k each time, or we can read one by one
        while ((b = fis.read(bytes)) != -1) {
            fos.write(b);
        }
        fis.close();
        fos.close();
    }
}
```
```java
class Example{
  public static void main(String[] args) {
    FileInputStream fis = new FileInputStrea(file);
    bytes[] bytes = new byte[2];            // fis.read(bytes) return the length of read bytes
    while (fis.read(bytes) != -1){          // if we have abcde in file
      System.out.println(new Stirng(bytes));// 1st, we have ab in bytes
                                            // 2ed, we have cd in bytes
                                            // 3rd, we have ed in bytes
                                            // since we have only e left, so we replace only c of the cd.
      // so we can use new String(bytes, 0, len) to print the right content
    }
  }
}
```
```java
class Example {
    public static void main(String[] args) {
        /*
         * we have to close even there is exception,
         * so we put close() in the finally
         * we need fis declared outside of try block,
         * but we need to catch its exception inside try,
         * and also we have to catch close()
         * */
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);        // if file doesn't exist, return null
            int b;
            while ((b = fis.read()) != -1) {
                System.out.println(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis!=null){      
              try {
                fis.close();
              } catch (IOEXception e) {
                e.printStackTrace();
              }
            }
        }
    }
}
```
- Above is too complex, jdk7 introduced `autoCloseable` in some specific condition 
  - create fis in try();
  - remove all about close();
- In JDK9, this is improved
  - create fis above try() and throws exception
  - pass fis as para of try();
  - remove all about close();