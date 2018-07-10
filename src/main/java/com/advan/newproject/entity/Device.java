package com.advan.newproject.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceName;
    private String deviceNumber;
    private String deviceDetail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToMany(mappedBy = "devices")
    private Set<UserInfo> UserInfos;

    public Set<UserInfo> getUserInfos() {
        return UserInfos;
    }

    public void setUserInfos(Set<UserInfo> userInfos) {
        UserInfos = userInfos;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getDeviceDetail() {
        return deviceDetail;
    }

    public void setDeviceDetail(String deviceDetail) {
        this.deviceDetail = deviceDetail;
    }

}
