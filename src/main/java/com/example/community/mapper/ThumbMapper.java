package com.example.community.mapper;

import com.example.community.model.Thumb;
import com.example.community.model.ThumbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ThumbMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.THUMB
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    long countByExample(ThumbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.THUMB
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    int deleteByExample(ThumbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.THUMB
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.THUMB
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    int insert(Thumb row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.THUMB
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    int insertSelective(Thumb row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.THUMB
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    List<Thumb> selectByExampleWithRowbounds(ThumbExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.THUMB
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    List<Thumb> selectByExample(ThumbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.THUMB
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    Thumb selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.THUMB
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    int updateByExampleSelective(@Param("row") Thumb row, @Param("example") ThumbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.THUMB
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    int updateByExample(@Param("row") Thumb row, @Param("example") ThumbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.THUMB
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    int updateByPrimaryKeySelective(Thumb row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.THUMB
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    int updateByPrimaryKey(Thumb row);
}