package com.example.community.model;

public class Thumb {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.THUMB.ID
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.THUMB.USER_ID
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.THUMB.PARENT_ID
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    private Integer parentId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.THUMB.ID
     *
     * @return the value of PUBLIC.THUMB.ID
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.THUMB.ID
     *
     * @param id the value for PUBLIC.THUMB.ID
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.THUMB.USER_ID
     *
     * @return the value of PUBLIC.THUMB.USER_ID
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.THUMB.USER_ID
     *
     * @param userId the value for PUBLIC.THUMB.USER_ID
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.THUMB.PARENT_ID
     *
     * @return the value of PUBLIC.THUMB.PARENT_ID
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.THUMB.PARENT_ID
     *
     * @param parentId the value for PUBLIC.THUMB.PARENT_ID
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}