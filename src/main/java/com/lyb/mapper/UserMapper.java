package com.lyb.mapper;

import com.lyb.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/8 16:33
 * @Description:
 */

@Mapper
@Repository
public interface UserMapper {

    @Select("select * from user where 1 = 1 " +
            "and account = #{account} " +
            "abd password = #{password}")
    User login(User user);

    @Select("select * from user where 1 = 1 " +
            "and account = #{account}")
    User select(User user);

    @Update("update user set name = #{name} where 1 = 1 " +
            "and id = #{id}")
    void update(User user);
}
