/**
 * This file write some test methods to help learning MyBatis
 * <p>
 * Table same as tb_brand used in JDBC
 */
package myjava.web.mybatis;


import myjava.web.mybatis.mapper.brandMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;


public class MyBatisTest {
    @Test
    public void testSelectAll() throws Exception {
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

    @Test
    public void testSelectById() throws Exception {
        // simulate id
        int id = 2;

        // SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // Mapper Interface
        brandMapper brandMapper = sqlSession.getMapper(brandMapper.class);
        // Execute
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);
        // Release
        sqlSession.close();
    }

    @Test
    public void testSelectByCondition() throws Exception {
        // simulate param
        int status = 1;
        String companyName = "Tech";
        String brandName = "Huawei";
        // preprocess param
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        /* 2. Use Object */
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);

        /* 3. Use Map */
        Map map = new HashMap();
        map.put("status", status);
        map.put("companyName", companyName);
        map.put("brandName", brandName);


        // SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // Mapper Interface
        brandMapper brandMapper = sqlSession.getMapper(brandMapper.class);
        // Execute
        /* 1. Annotation */
        // List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        /* 2. Use Object */
        // List<Brand> brands = brandMapper.selectByCondition(brand);
        /* 3. Use Map */
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);
        // Release
        sqlSession.close();
    }

    @Test
    public void selectByConditionSingle() throws Exception {
        // simulate param
        int status = 1;
        String companyName = "Tech";
        String brandName = "Huawei";
        // preprocess param
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        /* Use Object */
        Brand brand = new Brand();
        brand.setStatus(status);
        //brand.setCompanyName(companyName);
        //brand.setBrandName(brandName);

        // SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // Mapper Interface
        brandMapper brandMapper = sqlSession.getMapper(brandMapper.class);
        // Execute
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);
        System.out.println(brands);
        // Release
        sqlSession.close();
    }
    @Test
    public void insert() throws Exception {
        // simulate param
        String brandName = "XiangPiaoPiao";
        String companyName = "XiangPiaoPiao TM";
        int ordered = 10;
        String desription = "San Quan";
        int status = 1;

        /* Use Object */
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(ordered);
        brand.setDescription(desription);
        brand.setStatus(status);

        // SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // SqlSession: can pass 'true' to set auto commit
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // Mapper Interface
        brandMapper brandMapper = sqlSession.getMapper(brandMapper.class);
        // Execute
        brandMapper.insert(brand);
        // useGeneratedKeys="true" keyProperty="id"
        System.out.println(brand.getId());
        // Commit
        sqlSession.commit();
        // Release
        sqlSession.close();
    }
    @Test
    public void update() throws Exception {
        // simulate param
        String brandName = "Bodao";
        String companyName = "Bodao TM";
        int ordered = 30;
        String desription = "yyds";
        int status = 1;
        int id = 8;

        /* Use Object */
        Brand brand = new Brand();
        brand.setId(id);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(ordered);
        brand.setDescription(desription);
        brand.setStatus(status);

        // SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // SqlSession: can pass 'true' to set auto commit
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // Mapper Interface
        brandMapper brandMapper = sqlSession.getMapper(brandMapper.class);
        // Execute
        int count = brandMapper.update(brand);
        System.out.println(count);
        // Commit
        sqlSession.commit();
        // Release
        sqlSession.close();
    }
    @Test
    public void updateDynamically() throws Exception {
        // simulate param
        String brandName = "Bodao";
        String companyName = "Bodao TM";
        int ordered = 300;
        String desription = "yyds";
        int status = 1;
        int id = 8;

        /* Use Object */
        Brand brand = new Brand();
        brand.setId(id);
        //brand.setBrandName(brandName);
        //brand.setCompanyName(companyName);
        brand.setOrdered(ordered);
        //brand.setDescription(desription);
        brand.setStatus(status);

        // SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // SqlSession: can pass 'true' to set auto commit
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // Mapper Interface
        brandMapper brandMapper = sqlSession.getMapper(brandMapper.class);
        // Execute
        int count = brandMapper.updateDynamically(brand);
        System.out.println(count);
        // Commit
        sqlSession.commit();
        // Release
        sqlSession.close();
    }
    @Test
    public void deleteById() throws Exception {
        // simulate param
        int id = 8;
        // SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // SqlSession: can pass 'true' to set auto commit
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // Mapper Interface
        brandMapper brandMapper = sqlSession.getMapper(brandMapper.class);
        // Execute
        brandMapper.deleteById(id);
        // Commit
        sqlSession.commit();
        // Release
        sqlSession.close();
    }
    @Test
    public void deleteByIds() throws Exception {
        // simulate param
        int[] ids = {10, 11};
        // SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // SqlSession: can pass 'true' to set auto commit
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // Mapper Interface
        brandMapper brandMapper = sqlSession.getMapper(brandMapper.class);
        // Execute
        brandMapper.deleteByIds(ids);
        // Commit
        sqlSession.commit();
        // Release
        sqlSession.close();
    }
}

