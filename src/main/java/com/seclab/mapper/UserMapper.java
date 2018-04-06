package com.seclab.mapper;

import com.seclab.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into tb_user(name) values(#{username})")
    void save(User user);

    @Delete("delete from tb_user where id=#{id}")
    void deleteById(@Param("id") Long id);

    @Select("select * from tb_user where id=#{id}")
    User findById(@Param("id") Long id);

    @Select("select * from tb_user")
    List<User> getAll();

    @Select("select * from tb_user where username=#{username}")
    User findByUsername(@Param("username") String username);
}