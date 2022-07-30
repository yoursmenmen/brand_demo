package com.mingming.mapper;

import com.mingming.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author h
 */
public interface UserMapper {
    /**
     * 查询0
     *
     * @param username 用户名
     * @param password 密码
     * @return {@link User}
     */
    @Select("select * from test1.tb_user where username = #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password") String password);

    /**
     * 通过用户名查找用户
     *
     * @param username 用户名
     * @return boolean
     */
    @Select("select * from test1.tb_user where username = #{username}")
    User selectByUsername(String username);

    /**
     * 添加用户
     *
     * @param user 用户
     */
    @Insert("insert into test1.tb_user values(null, #{username}, #{password})")
    void add(User user);
}
