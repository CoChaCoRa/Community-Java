package com.example.community.mapper;

import com.example.community.Model.Post;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper {
    @Insert("insert into posts (title,description,creator,gmt_create,gmt_modified,tag) values (#{title},#{description},#{creator},#{gmtCreate},#{gmtModified},#{tag})")
    public void create(Post post);

    @Select("select * from posts")
    List<Post> getList();

    @Select("select count(*) from posts")
    Integer getCount();

    @Select("select * from posts where creator=#{id}")
    List<Post> getListByCreator(@Param("id") Integer id);

    @Select("select count(*) from posts where creator=#{id}")
    Integer getCountByCreator(@Param("id") Integer id);

    @Select("select * from posts where id=#{id}")
    Post getPostById(@Param("id") Integer id);
}
