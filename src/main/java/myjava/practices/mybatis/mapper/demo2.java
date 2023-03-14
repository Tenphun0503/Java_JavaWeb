package myjava.practices.mybatis.mapper;


import myjava.practices.jdbc.JDBCBrand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;


/**
 * This file shows the Mapper instead of using hard code like session.selectList("test.selectAll");
 */
public class demo2 {
    public static void main(String[] args) throws Exception {
        // Load core setting
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // Get SqlSessionFactory object
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // Get SqlSession object
        SqlSession session = sqlSessionFactory.openSession();

        // Get UserMapper interface object
        brandMapper brandMapper = session.getMapper(brandMapper.class);
        // Execute
        List<JDBCBrand> brands = brandMapper.selectAll();


        System.out.println(brands);

        session.close();
    }
}
