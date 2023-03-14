# Java Web

---
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

#### 2. JDBC
- DriverManager; Connection; Statement; ResultSet; PreparedStatement(useServerPreStmts=true);  
- Sample Code
```
import java.sql.*;

public class JDBCPreparedStatementDemo {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase"; // replace mydatabase with the name of your database
        String user = "myuser"; // replace myuser with your MySQL username
        String password = "mypassword"; // replace mypassword with your MySQL password

        try {
            // Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection to the database
            Connection conn = DriverManager.getConnection(url, user, password);

            // Prepare a statement with parameters
            String sql = "INSERT INTO mytable (name, age) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Set the parameter values
            pstmt.setString(1, "John Doe");
            pstmt.setInt(2, 25);

            // Execute the statement
            int rows = pstmt.executeUpdate();

            // Process the results
            if (rows > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Data not inserted.");
            }

            // Close the statement and connection
            pstmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
```
#### 3. MyBatis
### 2. Front End
#### 1. HTML + CSS
#### 2. JavaScript
#### 3. Ajax + VUE + ElementUI
### 3. Web Core
#### 1. Tomcat + HTTP + Servlet
#### 2. Request + Response
#### 3. JSP
#### 4. Cookie + Session
#### 5. Filter + Listener