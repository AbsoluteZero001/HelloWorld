package com.springboot.springboot.pojo.user;

public class User {

    // ===== 字段 =====
    private Integer id;
    private String username;
    private String password;
    private String account;
    private String idcard;
    private Integer gender;
    private Integer age;
    private Integer userType;
    private Integer userStatus;
    private Integer userRoomid;
    private String userAvatar;

    // ===== Getter & Setter =====
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

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public Integer getUserType() { return userType; }
    public void setUserType(Integer userType) { this.userType = userType; }

    public Integer getUserStatus() { return userStatus; }
    public void setUserStatus(Integer userStatus) { this.userStatus = userStatus; }

    public Integer getUserRoomid() { return userRoomid; }
    public void setUserRoomid(Integer userRoomid) { this.userRoomid = userRoomid; }

    public String getUserAvatar() { return userAvatar; }
    public void setUserAvatar(String userAvatar) { this.userAvatar = userAvatar; }

    // ===== toString =====
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", account='" + account + '\'' +
                ", idcard='" + idcard + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", userType=" + userType +
                ", userStatus=" + userStatus +
                ", userRoomid=" + userRoomid +
                ", userAvatar='" + userAvatar + '\'' +
                '}';
    }

    // ===== 转换方法 =====
    public static User toUser(LoginUser loginUser) {
        User u = new User();
        u.setAccount(loginUser.getAccount());
        u.setPassword(loginUser.getPassword());
        u.setUsername(loginUser.getUsername());
        u.setUserType(loginUser.getUserType() != null ? loginUser.getUserType().intValue() : null);
        return u;
    }

    public ResUser toResUser() {
        return ResUser.fromUser(this);
    }
}
