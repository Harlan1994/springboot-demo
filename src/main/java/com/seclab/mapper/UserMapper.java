package com.seclab.mapper;

import com.seclab.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * User类对应的mapper，方法命名规则以相应的操作开头（select，insert，update，delete）
 */
@Mapper
public interface UserMapper {

    /**
     * 保存一个用户
     *
     * @param user
     */
    Integer insertUser(User user);

    /**
     * 保存多个用户
     * @param users
     * @return
     */
    Integer insertUsers(List<User> users);

    /**
     * 根据id删除一个用户
     *
     * @param id
     */
    void deleteUserById(@Param("id") Long id);

    /**
     * 根据id(唯一)查找一个用户的详细信息
     *
     * @param id
     * @return
     */
    User selectUserById(@Param("id") Long id);

    /**
     * 根据用户名（唯一）获取用户信息
     *
     * @return
     */
    User selectUserByUsername(@Param("username") String username);

    /**
     * 根据id更新用户密码，密码需要是已经加密过的
     *
     * @param id
     * @param encryptedPassword
     * @return
     */
    int updateUserPasswdById(@Param("id") Long id, @Param("password") String encryptedPassword);

    /**
     * 根据username更新用户密码，密码需要是已经加密过的
     *
     * @param username
     * @param encryptedPassword
     * @return
     */
    int updateUserPasswdByUsername(@Param("username") String username, @Param("password") String encryptedPassword);

    /**
     * 更新用户信息（支持UI界面显示的字段修改），不支持password,avatar,locked三个字段
     * @param user
     * @return
     */
    Integer updateUser(@Param("user") User user);
}