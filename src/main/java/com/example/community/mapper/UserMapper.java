package com.example.community.mapper;

import com.example.community.Model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Insert({"insert into users (account_id,name,token,gmt_create,gmt_modified,avatar_url,email) values (#{accountId},#{name},#{token},#{gmtCreated},#{gmtModified},#{avatarUrl},#{email})"})
    void insert(User user);

    @Select("select * from users where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from users where id = #{id}")
    User findById(@Param("id") Integer creator);

    @Select("select * from users where account_id = #{accountId}")
    User findByAccountId(@Param("accountId") String accountId);

    @Update("update users set (name,token,avatar_url,email) = (#{name},#{token},#{avatarUrl},#{email}) where account_id = #{accountId}")
    void update(User user);
}
