package com.example.community.mapper;

import com.example.community.model.Notification;
import com.example.community.model.NotificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface NotificationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.NOTIFICATION
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    long countByExample(NotificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.NOTIFICATION
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    int deleteByExample(NotificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.NOTIFICATION
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.NOTIFICATION
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    int insert(Notification row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.NOTIFICATION
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    int insertSelective(Notification row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.NOTIFICATION
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    List<Notification> selectByExampleWithRowbounds(NotificationExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.NOTIFICATION
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    List<Notification> selectByExample(NotificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.NOTIFICATION
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    Notification selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.NOTIFICATION
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    int updateByExampleSelective(@Param("row") Notification row, @Param("example") NotificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.NOTIFICATION
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    int updateByExample(@Param("row") Notification row, @Param("example") NotificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.NOTIFICATION
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    int updateByPrimaryKeySelective(Notification row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.NOTIFICATION
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    int updateByPrimaryKey(Notification row);
}