package com.example.community.mapper;

import com.example.community.model.Post;
import com.example.community.model.PostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PostMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.POSTS
     *
     * @mbg.generated Thu Jun 15 09:10:57 CST 2023
     */
    long countByExample(PostExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.POSTS
     *
     * @mbg.generated Thu Jun 15 09:10:57 CST 2023
     */
    int deleteByExample(PostExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.POSTS
     *
     * @mbg.generated Thu Jun 15 09:10:57 CST 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.POSTS
     *
     * @mbg.generated Thu Jun 15 09:10:57 CST 2023
     */
    int insert(Post row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.POSTS
     *
     * @mbg.generated Thu Jun 15 09:10:57 CST 2023
     */
    int insertSelective(Post row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.POSTS
     *
     * @mbg.generated Thu Jun 15 09:10:57 CST 2023
     */
    List<Post> selectByExampleWithRowbounds(PostExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.POSTS
     *
     * @mbg.generated Thu Jun 15 09:10:57 CST 2023
     */
    List<Post> selectByExample(PostExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.POSTS
     *
     * @mbg.generated Thu Jun 15 09:10:57 CST 2023
     */
    Post selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.POSTS
     *
     * @mbg.generated Thu Jun 15 09:10:57 CST 2023
     */
    int updateByExampleSelective(@Param("row") Post row, @Param("example") PostExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.POSTS
     *
     * @mbg.generated Thu Jun 15 09:10:57 CST 2023
     */
    int updateByExample(@Param("row") Post row, @Param("example") PostExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.POSTS
     *
     * @mbg.generated Thu Jun 15 09:10:57 CST 2023
     */
    int updateByPrimaryKeySelective(Post row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.POSTS
     *
     * @mbg.generated Thu Jun 15 09:10:57 CST 2023
     */
    int updateByPrimaryKey(Post row);
}