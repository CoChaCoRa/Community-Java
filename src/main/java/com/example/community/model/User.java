package com.example.community.model;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.USERS.ID
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.USERS.ACCOUNT_ID
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    private String accountId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.USERS.TOKEN
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    private String token;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.USERS.NAME
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.USERS.EMAIL
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.USERS.GMT_CREATE
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.USERS.GMT_MODIFIED
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    private Long gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.USERS.AVATAR_URL
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    private String avatarUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.USERS.PASSWORD
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    private String password;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.USERS.ID
     *
     * @return the value of PUBLIC.USERS.ID
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.USERS.ID
     *
     * @param id the value for PUBLIC.USERS.ID
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.USERS.ACCOUNT_ID
     *
     * @return the value of PUBLIC.USERS.ACCOUNT_ID
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.USERS.ACCOUNT_ID
     *
     * @param accountId the value for PUBLIC.USERS.ACCOUNT_ID
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.USERS.TOKEN
     *
     * @return the value of PUBLIC.USERS.TOKEN
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    public String getToken() {
        return token;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.USERS.TOKEN
     *
     * @param token the value for PUBLIC.USERS.TOKEN
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.USERS.NAME
     *
     * @return the value of PUBLIC.USERS.NAME
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.USERS.NAME
     *
     * @param name the value for PUBLIC.USERS.NAME
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.USERS.EMAIL
     *
     * @return the value of PUBLIC.USERS.EMAIL
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.USERS.EMAIL
     *
     * @param email the value for PUBLIC.USERS.EMAIL
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.USERS.GMT_CREATE
     *
     * @return the value of PUBLIC.USERS.GMT_CREATE
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.USERS.GMT_CREATE
     *
     * @param gmtCreate the value for PUBLIC.USERS.GMT_CREATE
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.USERS.GMT_MODIFIED
     *
     * @return the value of PUBLIC.USERS.GMT_MODIFIED
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.USERS.GMT_MODIFIED
     *
     * @param gmtModified the value for PUBLIC.USERS.GMT_MODIFIED
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.USERS.AVATAR_URL
     *
     * @return the value of PUBLIC.USERS.AVATAR_URL
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.USERS.AVATAR_URL
     *
     * @param avatarUrl the value for PUBLIC.USERS.AVATAR_URL
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.USERS.PASSWORD
     *
     * @return the value of PUBLIC.USERS.PASSWORD
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.USERS.PASSWORD
     *
     * @param password the value for PUBLIC.USERS.PASSWORD
     *
     * @mbg.generated Fri Jun 16 09:57:35 CST 2023
     */
    public void setPassword(String password) {
        this.password = password;
    }
}