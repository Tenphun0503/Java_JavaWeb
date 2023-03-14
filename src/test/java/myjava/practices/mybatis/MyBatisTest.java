/**
 * This file write some test methods to help learning MyBatis
 * <p>
 * Table same as tb_brand used in JDBC
 *
 */
package myjava.practices.mybatis;


import myjava.practices.jdbc.Brand;
import myjava.practices.mybatis.mapper.brandMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;


public class MyBatisTest {
    @Test
    public void testSelectAll() throws Exception{
        // SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // Mapper Interface
        brandMapper brandMapper = sqlSession.getMapper(brandMapper.class);
        // Execute
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);
        // Release
        sqlSession.close();
    }
}

