package com.zly.mapper;


import com.zly.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    /**
     * 查询所有用户
     * return 用户列表
     */
    @Select("SELECT * FROM orm_user")
    List<User> selectAll();

    /**
     * 根据用户编号查询用户
     * return 用户id匹配的用户
     */
    @Select("SELECT * FROM orm_user WHERE id = #{id}")
    User selectById(Long id);

    /**
     * 保存用户
     * return 保存成功的记录数
     */
    int saveUser(@Param("user") User user);

    int batchSaveUser(List<User> userList);

    /**
     * 根据用户id删除用户
     * return 成功-{@code 1} 失败-{@code 0}}
     */
    int deleteById(Long id);
}
