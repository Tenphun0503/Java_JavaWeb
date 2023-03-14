package myjava.practices.mybatis.mapper;

import myjava.practices.jdbc.JDBCBrand;

import java.util.List;

/**
 * This file shows the Mapper instead of using hard code like session.selectList("test.selectAll");
 */
public interface brandMapper {

    List<JDBCBrand> selectAll();
}
