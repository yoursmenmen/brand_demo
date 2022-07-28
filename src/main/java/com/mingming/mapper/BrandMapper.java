package com.mingming.mapper;

import com.mingming.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author h
 */
public interface BrandMapper {

    /**
     * 查询所有
     *
     * @return {@link List}<{@link Brand}>
     */

    @Select("select * from test1.tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    /**
     * 添加
     *
     * @param brand 品牌
     */
    @Insert("INSERT INTO test1.tb_brand values (null, #{brandName}, #{companyName}, #{ordered}, #{description}, #{status})")
    void add(Brand brand);


    /**
     * 根据id查询
     *
     * @param id id
     * @return {@link Brand}
     */
    @Select("select * from test1.tb_brand where id = #{id}")
    @ResultMap("brandResultMap")
    Brand selectById(int id);


    /**
     *  修改数据
     *
     * @param brand 品牌
     */
    @Update("update test1.tb_brand set brand_name = #{brandName}, company_name = #{companyName}, ordered = #{ordered}, description = #{description}, status = #{status} where id = #{id}")
    @ResultMap("brandResultMap")
    void update(Brand brand);


    /**
     * 通过id删除
     *
     * @param id id
     */
    @Delete("delete from test1.tb_brand where id = #{id}")
    void deleteById(int id);
}
