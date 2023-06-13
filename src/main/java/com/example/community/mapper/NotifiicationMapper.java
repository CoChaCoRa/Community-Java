package com.example.community.mapper;

import com.example.community.model.Notifiication;
import com.example.community.model.NotifiicationExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface NotifiicationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.NOTIFICATION
     *
     * @mbg.generated Tue Jun 13 10:51:05 CST 2023
     */
    long countByExample(NotifiicationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.NOTIFICATION
     *
     * @mbg.generated Tue Jun 13 10:51:05 CST 2023
     */
    int deleteByExample(NotifiicationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.NOTIFICATION
     *
     * @mbg.generated Tue Jun 13 10:51:05 CST 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.NOTIFICATION
     *
     * @mbg.generated Tue Jun 13 10:51:05 CST 2023
     */
    int insert(Notifiication row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.NOTIFICATION
     *
     * @mbg.generated Tue Jun 13 10:51:05 CST 2023
     */
    int insertSelective(Notifiication row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.NOTIFICATION
     *
     * @mbg.generated Tue Jun 13 10:51:05 CST 2023
     */
    List<Notifiication> selectByExampleWithRowbounds(NotifiicationExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.NOTIFICATION
     *
     * @mbg.generated Tue Jun 13 10:51:05 CST 2023
     */
    List<Notifiication> selectByExample(NotifiicationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.NOTIFICATION
     *
     * @mbg.generated Tue Jun 13 10:51:05 CST 2023
     */
    Notifiication selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.NOTIFICATION
     *
     * @mbg.generated Tue Jun 13 10:51:05 CST 2023
     */
    int updateByExampleSelective(@Param("row") Notifiication row, @Param("example") NotifiicationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.NOTIFICATION
     *
     * @mbg.generated Tue Jun 13 10:51:05 CST 2023
     */
    int updateByExample(@Param("row") Notifiication row, @Param("example") NotifiicationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.NOTIFICATION
     *
     * @mbg.generated Tue Jun 13 10:51:05 CST 2023
     */
    int updateByPrimaryKeySelective(Notifiication row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.NOTIFICATION
     *
     * @mbg.generated Tue Jun 13 10:51:05 CST 2023
     */
    int updateByPrimaryKey(Notifiication row);
}