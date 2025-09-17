package com.springboot.springboot.entity;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String account;
    private String idcard;
    private Integer gender; // 改为 Integer 类型，匹配数据库整数类型

    // getter & setter
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getAccount() { return account; }
    public void setAccount(String account) { this.account = account; }

    public String getIdcard() { return idcard; }
    public void setIdcard(String idcard) { this.idcard = idcard; }

    public Integer getGender() { return gender; }
    public void setGender(Integer gender) { this.gender = gender; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", account='" + account + '\'' +
                ", idcard='" + idcard + '\'' +
                ", gender=" + gender +
                '}';
    }
}
