# Exceptions And Files

---
### _[Exceptions](#Exceptions)_
### _[File](#File)_

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
### 