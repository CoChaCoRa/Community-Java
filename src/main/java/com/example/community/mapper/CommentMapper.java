package com.example.community.mapper;

import com.example.community.model.Comment;
import com.example.community.model.CommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CommentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMMENTS
     *
     * @mbg.generated Thu Oct 13 15:08:01 CST 2022
     */
    long countByExample(CommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMMENTS
     *
     * @mbg.generated Thu Oct 13 15:08:01 CST 2022
     */
    int deleteByExample(CommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMMENTS
     *
     * @mbg.generated Thu Oct 13 15:08:01 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMMENTS
     *
     * @mbg.generated Thu Oct 13 15:08:01 CST 2022
     */
    int insert(Comment row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMMENTS
     *
     * @mbg.generated Thu Oct 13 15:08:01 CST 2022
     */
    int insertSelective(Comment row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMMENTS
     *
     * @mbg.generated Thu Oct 13 15:08:01 CST 2022
     */
    List<Comment> selectByExampleWithRowbounds(CommentExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMMENTS
     *
     * @mbg.generated Thu Oct 13 15:08:01 CST 2022
     */
    List<Comment> selectByExample(CommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMMENTS
     *
     * @mbg.generated Thu Oct 13 15:08:01 CST 2022
     */
    Comment selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMMENTS
     *
     * @mbg.generated Thu Oct 13 15:08:01 CST 2022
     */
    int updateByExampleSelective(@Param("row") Comment row, @Param("example") CommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMMENTS
     *
     * @mbg.generated Thu Oct 13 15:08:01 CST 2022
     */
    int updateByExample(@Param("row") Comment row, @Param("example") CommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMMENTS
     *
     * @mbg.generated Thu Oct 13 15:08:01 CST 2022
     */
    int updateByPrimaryKeySelective(Comment row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMMENTS
     *
     * @mbg.generated Thu Oct 13 15:08:01 CST 2022
     */
    int updateByPrimaryKey(Comment row);
}