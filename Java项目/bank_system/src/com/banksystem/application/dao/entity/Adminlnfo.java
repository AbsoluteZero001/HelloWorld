package com.banksystem.application.dao.entity;
import java.time.Instant;

/**
 * @Author: tangjinjie
 * @CreatedTime: 2021/5/18
 * @Description: 管理员信息实体类
 */

public class Adminlnfo {
    private Long id; //数据库 id
    private String password; //密码
    private String nickname; //别名
    private String name; //姓名
    private String mobile; //手机号
    private String state; //状态
    private String deleted; //是否删除
    private Instant createBy; //创建时间
    private Instant updateBy; //更新时间
    private String createTime; //创建人id
    private String updateTime; //更新人id
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public String getDeleted() { return deleted; }
    public void setDeleted(String deleted) { this.deleted = deleted; }
    public Instant getCreateBy() { return createBy; }
    public void setCreateBy(Instant createBy) { this.createBy = createBy; }
    public Instant getUpdateBy() { return updateBy; }
    public void setUpdateBy(Instant updateBy) { this.updateBy = updateBy; }
    public String getCreateTime() { return createTime; }
    public void setCreateTime(String createTime) { this.createTime = createTime; }
    public String getUpdateTime() { return updateTime; }
    public void setUpdateTime(String updateTime) { this.updateTime = updateTime; }
}
