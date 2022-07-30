package com.mingming.service;

import com.mingming.mapper.BrandMapper;
import com.mingming.mapper.UserMapper;
import com.mingming.pojo.User;
import com.mingming.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author h
 */
public class UserService {

    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return {@link User}
     */
    public User login(String username, String password){
        // 2. 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取mapper对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 调用方法，并关闭
        User user = userMapper.select(username, password);

        sqlSession.close();

        return user;
    }
}
