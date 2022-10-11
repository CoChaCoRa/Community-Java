package com.example.community.model;

public class Comment {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COMMENTS.ID
     *
     * @mbg.generated Tue Oct 11 14:58:54 CST 2022
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COMMENTS.PARENT_ID
     *
     * @mbg.generated Tue Oct 11 14:58:54 CST 2022
     */
    private Integer parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COMMENTS.PARENT_TYPE
     *
     * @mbg.generated Tue Oct 11 14:58:54 CST 2022
     */
    private Integer parentType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COMMENTS.CREATOR
     *
     * @mbg.generated Tue Oct 11 14:58:54 CST 2022
     */
    private Integer creator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COMMENTS.GMT_CREATE
     *
     * @mbg.generated Tue Oct 11 14:58:54 CST 2022
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COMMENTS.GMT_MODIFIED
     *
     * @mbg.generated Tue Oct 11 14:58:54 CST 2022
     */
    private Long gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COMMENTS.LIKE_COUNT
     *
     * @mbg.generated Tue Oct 11 14:58:54 CST 2022
     */
    private Integer likeCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COMMENTS.CONTENT
     *
     * @mbg.generated Tue Oct 11 14:58:54 CST 2022
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COMMENTS.COMMENT_COUNT
     *
     * @mbg.generated Tue Oct 11 14:58:54 CST 2022
     */
    private Integer commentCount;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COMMENTS.ID
     *
     * @return the value of PUBLIC.COMMENTS.ID
     *
     * @mbg.generated Tue Oct 11 14:58:54 CST 2022
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COMMENTS.ID
     *
     * @param id the value for PUBLIC.COMMENTS.ID
     *
     * @mbg.generated Tue Oct 11 14:58:54 CST 2022
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COMMENTS.PARENT_ID
     *
     * @return the value of PUBLIC.COMMENTS.PARENT_ID
     *
     * @mbg.generated Tue Oct 11 14:58:54 CST 2022
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COMMENTS.PARENT_ID
     *
     * @param parentId the value for PUBLIC.COMMENTS.PARENT_ID
     *
     * @mbg.generated Tue Oct 11 14:58:54 CST 2022
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COMMENTS.PARENT_TYPE
     *
     * @return the value of PUBLIC.COMMENTS.PARENT_TYPE
     *
     * @mbg.generated Tue Oct 11 14:58:54 CST 2022
     */
    public Integer getParentType() {
        return parentType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COMMENTS.PARENT_TYPE
     *
     * @param parentType the value for PUBLIC.COMMENTS.PARENT_TYPE
     *
     * @mbg.generated Tue Oct 11 14:58:54 CST 2022
     */
    public void setParentType(Integer parentType) {
        this.parentType = parentType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COMMENTS.CREATOR
     *
     * @return the value of PUBLIC.COMMENTS.CREATOR
     *
     * @mbg.generated Tue Oct 11 14:58:54 CST 2022
     */
    public Integer getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COMMENTS.CREATOR
     *
     * @param creator the value for PUBLIC.COMMENTS.CREATOR
     *
     * @mbg.generated Tue Oct 11 14:58:54 CST 2022
     */
    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COMMENTS.GMT_CREATE
     *
     * @return the value of PUBLIC.COMMENTS.GMT_CREATE
     *
     * @mbg.generated Tue Oct 11 14:58:54 CST 2022
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COMMENTS.GMT_CREATE
     *
     * @param gmtCreate the value for PUBLIC.COMMENTS.GMT_CREATE
     *
     * @mbg.generated Tue Oct 11 14:58:54 CST 2022
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COMMENTS.GMT_MODIFIED
     *
     * @return the value of PUBLIC.COMMENTS.GMT_MODIFIED
     *
     * @mbg.generated Tue Oct 11 14:58:54 CST 2022
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COMMENTS.GMT_MODIFIED
     *
     * @param gmtModified the value for PUBLIC.COMMENTS.GMT_MODIFIED
     *
     * @mbg.generated Tue Oct 11 14:58:54 CST 2022
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COMMENTS.LIKE_COUNT
     *
     * @return the value of PUBLIC.COMMENTS.LIKE_COUNT
     *
     * @mbg.generated Tue Oct 11 14:58:54 CST 2022
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COMMENTS.LIKE_COUNT
     *
     * @param likeCount the value for PUBLIC.COMMENTS.LIKE_COUNT
     *
     * @mbg.generated Tue Oct 11 14:58:54 CST 2022
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COMMENTS.CONTENT
     *
     * @return the value of PUBLIC.COMMENTS.CONTENT
     *
     * @mbg.generated Tue Oct 11 14:58:54 CST 2022
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COMMENTS.CONTENT
     *
     * @param content the value for PUBLIC.COMMENTS.CONTENT
     *
     * @mbg.generated Tue Oct 11 14:58:54 CST 2022
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COMMENTS.COMMENT_COUNT
     *
     * @return the value of PUBLIC.COMMENTS.COMMENT_COUNT
     *
     * @mbg.generated Tue Oct 11 14:58:54 CST 2022
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COMMENTS.COMMENT_COUNT
     *
     * @param commentCount the value for PUBLIC.COMMENTS.COMMENT_COUNT
     *
     * @mbg.generated Tue Oct 11 14:58:54 CST 2022
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }
}