/**
 * This file write some test methods to help learning JDBC
 *
 * Create table as below and insert some data first
 * DESC tb_brand;
 * +--------------+--------------+------+-----+---------+----------------+
 * | Field        | Type         | Null | Key | Default | Extra          |
 * +--------------+--------------+------+-----+---------+----------------+
 * | id           | int          | NO   | PRI | NULL    | auto_increment |
 * | brand_name   | varchar(20)  | YES  |     | NULL    |                |
 * | company_name | varchar(20)  | YES  |     | NULL    |                |
 * | ordered      | int          | YES  |     | NULL    |                |
 * | description  | varchar(100) | YES  |     | NULL    |                |
 * | status       | int          | YES  |     | NULL    |                |
 * +--------------+--------------+------+-----+---------+----------------+
 */
package myjava.web.jdbc;

import org.junit.Test;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCTest {
    //Setting
    private final String url = "jdbc:mysql://localhost:3306/db1";
    private final String user = "root";
    private final String password = "root@1234";


    /**
     * Test for show all
     * 1. How to write SQL statement
     * 2. Ensure settings
     * 3. Ensure form of output
     */
    @Test
    public void testSelectAll() throws Exception {

        /*
         * Loading class `com.mysql.jdbc.Driver'.
         * This is deprecated.
         * The new driver class is `com.mysql.cj.jdbc.Driver'.
         * The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
         */
        // Register the JDBC driver
        // Class.forName("com.mysql.jdbc.Driver");

        // Open a connection to the database
        Connection conn = DriverManager.getConnection(url, user, password);

        // SQL
        String sql = "SELECT * FROM tb_brand;";

        // Get pstmt
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // Execute sql
        ResultSet rs = pstmt.executeQuery();

        List<Brand> brands = new ArrayList<>();
        // Process result
        while (rs.next()){
            // get data
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");

            // encapsulation
            Brand brand = new Brand(id, brandName, companyName, ordered, description, status);
            brands.add(brand);
        }
        System.out.println(brands);
        // Release resource
        rs.close();
        pstmt.close();
        conn.close();
    }

    /**
     * Test for Insertion
     */
    @Test
    public void testInsert() throws Exception {
        // Open a connection to the database
        Connection conn = DriverManager.getConnection(url, user, password);

        // SQL
        String sql = "INSERT INTO tb_brand(brand_name, company_name, ordered, description, status) VALUES (?,?,?,?,?);";

        // Get pstmt
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // Set variable (Simulate getting input through web)
        String brandName = "XiangPiaopiao";
        String companyName = "XiangPiaopiao";
        int ordered = 1;
        String description = "Good";
        int status = 1;

        // The PreparedStatement.setXXX() methods use a 1-based index to specify the parameter position in the SQL statement.
        pstmt.setString(1, brandName);
        pstmt.setString(2, companyName);
        pstmt.setInt(3, ordered);
        pstmt.setString(4, description);
        pstmt.setInt(5, status);

        // Execute sql
        int count = pstmt.executeUpdate(); //effected line number

        // Process Result
        System.out.println(count>0);


        // Release resources
        pstmt.close();
        conn.close();

    }

    /**
     * Test for Update
     */
    @Test
    public void testUpdate() throws Exception {
        // Open a connection to the database
        Connection conn = DriverManager.getConnection(url, user, password);

        // SQL
        String sql = "UPDATE tb_brand SET brand_name = ?, company_name = ?, ordered = ?, description = ?, status = ? WHERE id = ?;";

        // Get pstmt
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // Set variable (Simulate getting input through web)
        String brandName = "XiangPiaopiao";
        String companyName = "XiangPiaopiao";
        int ordered = 1000;
        String description = "Very Good";
        int status = 1;
        int id = 6;

        // The PreparedStatement.setXXX() methods use a 1-based index to specify the parameter position in the SQL statement.
        pstmt.setString(1, brandName);
        pstmt.setString(2, companyName);
        pstmt.setInt(3, ordered);
        pstmt.setString(4, description);
        pstmt.setInt(5, status);
        pstmt.setInt(6, id);

        // Execute sql
        int count = pstmt.executeUpdate(); //effected line number

        // Process Result
        System.out.println(count>0);


        // Release resources
        pstmt.close();
        conn.close();

    }

    /**
     * Test for Delete
     */
    @Test
    public void testDelete() throws Exception {
        // Open a connection to the database
        Connection conn = DriverManager.getConnection(url, user, password);

        // SQL
        String sql = "DELETE FROM tb_brand WHERE id = ?;";

        // Get pstmt
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // Set variable (Simulate getting input through web)
        int id = 6;

        // The PreparedStatement.setXXX() methods use a 1-based index to specify the parameter position in the SQL statement.
        pstmt.setInt(1, id);

        // Execute sql
        int count = pstmt.executeUpdate(); //effected line number

        // Process Result
        System.out.println(count>0);


        // Release resources
        pstmt.close();
        conn.close();

    }

}
