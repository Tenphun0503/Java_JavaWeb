package myjava.web.mybatis.mapper;

import myjava.web.mybatis.Brand;

import java.util.List;
import java.util.Map;

/**
 * This file shows the Mapper instead of using hard code like session.selectList("test.selectAll");
 */
public interface brandMapper {
    List<Brand> selectAll();
    Brand selectById(int id);

    /**
     * Query by conditions, There are 3 ways.
     */

    /* 1. Use Annotation */
    // List<Brand> selectByCondition(@Param("status")int status, @Param("companyName")String companyName, @Param("brandName")String brandName);

    /* 2. Use Object */
    // List<Brand> selectByCondition(Brand brand);

    /* 3. Use Map */
    List<Brand> selectByCondition(Map map);

    /**
     * Single Condition query.
     */
    List<Brand> selectByConditionSingle(Brand brand);

    void insert(Brand brand);

    int update(Brand brand);

    int updateDynamically(Brand brand);

    void deleteById(int id);

    void deleteByIds(int[] ids);
}
