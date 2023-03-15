package myjava.practices.mybatis;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;


/**
 * First taste of MyBatis
 * Use xml to build SqlSessionFactory
 * Use xml to map SQL statements (Define a result class for resultType in mapper e.g. JDBCBrand)
 */
public class demo {
    public static void main(String[] args) throws Exception {
        // Load core setting
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // Get SqlSessionFactory object
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // Get SqlSession object
        SqlSession session = sqlSessionFactory.openSession();

        // Execute SQL
        List<Brand> brands = session.selectList("myjava.practices.mybatis.mapper.brandMapper.selectAll");

        System.out.println(brands);

        session.close();
    }
}
