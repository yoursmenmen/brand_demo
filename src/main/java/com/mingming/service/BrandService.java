package com.mingming.service;

import com.mingming.mapper.BrandMapper;
import com.mingming.pojo.Brand;
import com.mingming.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author h
 */
public class BrandService {
    /**
     * 提高作用域，少写代码
     * sql会话工厂
     */
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查询所有
     *
     * @return {@link List}<{@link Brand}>
     */
    public List<Brand> selectAll(){
        // 调用BrandMapper中对应的方法
        // 1. 获取sqlSessionFactory
        // 2. 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取mapper对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 调用方法，并关闭
        List<Brand> brands = brandMapper.selectAll();
        sqlSession.close();
        return brands;
    }

    public void add(Brand brand){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取mapper对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 调用方法，并关闭
        brandMapper.add(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    public Brand selectById(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取mapper对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 调用方法，并关闭
        Brand brand = brandMapper.selectById(id);
        sqlSession.close();
        return brand;
    }

    /**
     * 修改数据
     */
    public void update(Brand brand){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取mapper对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 调用方法，并关闭
        brandMapper.update(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    public void delectById(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取mapper对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 调用方法，并关闭
        brandMapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();

    }
}
