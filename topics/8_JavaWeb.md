# Java Web

---
**Plugins**: `Maven Helper;` `Database Navigator;`
### 1. DataBase

#### 1. MySQL

- Data Type:

| Numeric Data Type | Description                                                                                    |
|-------------------|------------------------------------------------------------------------------------------------|
| TINYINT           | range from -128 to 127 or 0 to 255 (unsigned)                                                  |
| SMALLINT          | range from -32768 to 32767 or 0 to 65535 (unsigned)                                            |
| MEDIUMINT         | range from -8388608 to 8388607 or 0 to 16777215 (unsigned)                                     |
| INT               | range from -2147483648 to 2147483647                                                           |
| BIGINT            | range from -9223372036854775808 to 9223372036854775807 or 0 to 18446744073709551615 (unsigned) |
| FLOAT             | Used to store floating-point numbers with single precision                                     |
| DOUBLE            | Used to store floating-point numbers with double precision                                     |
| DECIMAL           | Used to store decimal numbers, with precision and scale                                        |

| Character Data Type | Description                                                                  |
|---------------------|------------------------------------------------------------------------------|
| CHAR                | Used to store fixed-length character strings                                 |
| VARCHAR             | Used to store variable-length character strings                              |
| TINYTEXT            | variable-length character strings maximum length of 255 characters           |
| TEXT                | variable-length character strings maximum length of 65,535 characters        |
| MEDIUMTEXT          | variable-length character strings maximum length of 16,777,215 characters    |
| LONGTEXT            | variable-length character strings maximum length of 4,294,967,295 characters |

| Date and Time Data Type | Description                                                                                            |
|-------------------------|--------------------------------------------------------------------------------------------------------|
| DATE                    | Used to store dates in the format 'YYYY-MM-DD'                                                         |
| TIME                    | Used to store time in the format 'HH:MM:SS'                                                            |
| YEAR                    | Used to store year values in 2-digit or 4-digit format                                                 |
| DATETIME                | Used to store both date and time in the format 'YYYY-MM-DD HH:MM:SS'                                   |
| TIMESTAMP               | Used to store a datetime value as the number of seconds since the Unix epoch (1970-01-01 00:00:00 UTC) |

- DCL(Grant, Revoke, Deny)
- DDL(Create, Retrieve, Delete, UPDATE)
- DML(Insert, Update, Delete)
- DQL(Select, From, Where, Group By, Having, Order By, Limit)
- Constraint

| Constraint Type | Description                                                                                         |
|-----------------|-----------------------------------------------------------------------------------------------------|
| NOT NULL        | Ensures that a column cannot contain null values.                                                   |
| UNIQUE          | Ensures that each value in a column or set of columns is unique.                                    |
| DEFAULT         | Ensures that a default value for unassigned variable.                                               |
| PRIMARY KEY     | Ensures that a column or set of columns uniquely identifies each row in a table.                    |
| FOREIGN KEY     | Ensures that a column or set of columns in one table corresponds to a primary key in another table. |
| CHECK           | Ensures that a value in a column or set of columns meets a specific condition or set of conditions. |

- Transaction(Start Transaction or Begin, Commit, Rollback)

#### 2. [JDBC](https://github.com/Tenphun0503/Java_JavaWeb/blob/main/src/test/java/myjava/practices/jdbc/JDBCTest.java)

DriverManager; Connection; Statement; ResultSet; PreparedStatement (useServerPreStmts=true);

###### Steps:

1. Register Driver;
2. Get Connection;
3. Define SQL;
4. Define PreparedStatement;
5. Set SQL Params;
6. Execute SQL;
7. Process Result;
8. Clean Resources;

#### 3. [MyBatis](https://github.com/Tenphun0503/Java_JavaWeb/blob/main/src/test/java/myjava/practices/mybatis/MyBatisTest.java)

MyBatis is a Java-based persistence framework that allows developers to easily map SQL queries and stored procedures to
Java objects.
- [Configuration](https://github.com/Tenphun0503/Java_JavaWeb/blob/main/src/main/resources/mybatis-config.xml): 
configuration files have settings and properties such as dataSource, mappers, etc.
`<typeAliases>:` Can Set Alias of a package, so that you can just write `resultType=Brand` in brandMapper.xml  
- [Mapper XML Files](https://github.com/Tenphun0503/Java_JavaWeb/tree/main/src/main/resources/myjava/practices/mybatis/mapper):  
  `#{} or ${}` are [placeholder](https://github.com/Tenphun0503/Java_JavaWeb/blob/main/src/main/resources/myjava/practices/mybatis/mapper/brandMapper.xml): `#{}` like preparedStatement, prevent sql injection.  
  For `<`, since it is part of a label, it can't be written directly but use escape character or CDATA  
  **\&lt;** or  `<![CDATA[ < ]]>`
- [Multiple parameters](https://github.com/Tenphun0503/Java_JavaWeb/blob/main/src/main/java/myjava/practices/mybatis/mapper/brandMapper.java): 1. Annotation; 2 Object; 3 Map
- [Dynamically Conditional Querying](https://github.com/Tenphun0503/Java_JavaWeb/blob/main/src/main/resources/myjava/practices/mybatis/mapper/brandMapper.xml) (`if, choose(when, otherwise), trim(where, set), foreach`)
- Insert: if return id is needed, set `useGeneratedKeys="true" keyProperty="id"` in <insert>
- Annotation: We used mapper.xml+mapper.java before, but we can also use annotation and use .java only
```
@Select("select * from tb where id=#{id}")
public Line selectyById(int id);
```

### 2. Web Core
#### 1. HTTP + Tomcat + Servlet
1. [HTTP](https://github.com/Tenphun0503/Java_JavaWeb/blob/main/src/main/java/myjava/practices/http/Server.java) is the protocol that is used to transfer data over the web.  
2. Tomcat is an open-source web server and servlet container developed by the Apache Software Foundation. 
It is used to run Java web applications that are written in servlet and JSP (JavaServer Pages) technologies.  
3. A servlet is a Java programming language class that is used to process HTTP requests and generate HTTP responses.

#### 2. [Request + Response](https://github.com/Tenphun0503/Java_JavaWeb/blob/main/src/main/java/myjava/practices/tomcat/ServletDemo.java)
1. Request:Get request data.
   1. Get/Post
   2. Three parts
      1. Request Line  
        `String getMethod(), String getQueryString(), etc.`
      2. Request Header
      3. Request Body
   3. Request Forward: `req.getRequestDispatcher('src B').forward(req,resp);`
      1. Set Attribute
      2. Get Attribute
      3. Remove Attribute
2. Response: Set Response data.
   1. Three parts:
      1. Response Line: `setSatus(int sc)`
      2. Response Header
      3. Response Body
   2. Response Redirect:
      1. `setStatus(302)`
      2. `setHeader("location", "src B")`

#### 3. MVC (Model-View-Controller) and  three-level architecture
1. MVC:
   1. The Model represents the application's data and logic.
   2. The View represents the user interface.
   3. the Controller acts as an intermediary between the two, handling user input and updating the Model and View as needed.
2. Three-level architecture
   1. The Presentation layer handles the user interface and user interaction. (`com.xxx.web`)
   2. The Business layer contains the application's logic and rules. (`com.xxx.service`)
   3. The Data Access layer manages data storage and retrieval.  (`com.xxx.dao`)

#### 4. Cookie + Session

#### 5. Filter + Listener

