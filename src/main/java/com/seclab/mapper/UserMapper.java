package com.seclab.mapper;

import com.seclab.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/4
 * Time: 16:40
 * Description:
 */
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
}
