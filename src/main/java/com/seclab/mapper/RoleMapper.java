package com.seclab.mapper;

import com.seclab.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/6
 * Time: 16:59
 * Description:
 */
@Mapper
public interface RoleMapper {

    /**
     * 根据用户id查询用户具有的角色集合
     * @param id
     * @return
     */
    @Select("select * from tb_role role left outer join tb_user_role user_role on role.id=user_role.role_id where user_role.user_id=#{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "role_name", property = "roleName")
    })
    Set<Role> findByUserId(@Param("id") Long id);

//    @Select("select * from tb_role role left outer join tb_user_role user_role on role.id=user_role.role_id " +
//            "left outer join tb_user t_user on t_user.id=user_role.user_id where t_user.username=#{username}")
//    @Results({
//            @Result(id = true, column = "id", property = "id"),
//            @Result(column = "role_name", property = "roleName")
//    })
//    Set<Role> findByUsername(@Param("username") String username);

    @Select("select * from tb_role where role_name=#{roleName}")
    Role findByRoleName(@Param("roleName") String roleName);
}
