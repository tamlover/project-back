package com.advan.newproject.entity.DTO;

import com.advan.newproject.entity.UserInfo;

public class UserInfoDTO {

    private Long userId;
    private String userName;
    private String account;
    private String role;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserInfoDTO () {

    }

    public UserInfoDTO (UserInfo u) {
        this.account = u.getAccount();
        this.userId = u.getId();
        this.role = u.getRole();
        this.userName = u.getUserName();
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
