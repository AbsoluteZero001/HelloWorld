package com.banksystem.application.entity;

/**
 * @Author: tangjinjie
 * @CreatedTime: 2021/5/18
 * @Description: 管理员信息实体类
 */

public class AdminInfo {
    private Long id; //数据库 id
    private String password; //密码
    private String nickname; //别名
    private String name; //姓名
    private String mobile; //手机号
    private String state; //状态
    private String deleted; //是否删除
    private Long createBy; //创建时间
    private Long updateBy; //更新时间
    private Integer createTime; //创建人id
    private Integer updateTime; //更新人id

    public AdminInfo() {
    }

    @Override
    public String toString() {
        // 返回AdminInfo对象的字符串表示形式
        return "AdminInfo{" +
                // 添加id属性
                "id=" + id +
                // 添加password属性，使用单引号包裹字符串
                ", password='" + password + '\'' +
                // 添加nickname属性，使用单引号包裹字符串
                ", nickname='" + nickname + '\'' +
                // 添加name属性，使用单引号包裹字符串
                ", name='" + name + '\'' +
                // 添加mobile属性，使用单引号包裹字符串
                ", mobile='" + mobile + '\'' +
                // 添加state属性，使用单引号包裹字符串
                ", state='" + state + '\'' +
                // 添加deleted属性，使用单引号包裹字符串
                ", deleted='" + deleted + '\'' +
                // 添加createBy属性
                ", createBy=" + createBy +
                // 添加updateBy属性
                ", updateBy=" + updateBy +
                // 添加createTime属性
                ", createTime=" + createTime +
                // 添加updateTime属性
                ", updateTime=" + updateTime +
                // 结束字符串
                '}';
    }

    public AdminInfo(Long id, String password, String nickname, String name, String mobile, String state, String deleted, Long createBy, Long updateBy, Integer createTime, Integer updateTime) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.name = name;
        this.mobile = mobile;
        this.state = state;
        this.deleted = deleted;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }
}



