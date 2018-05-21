package com.advan.newproject.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Device extends IdEntity {

    private String deviceName;

    @JoinTable(name="USER_DEVICE",//中间表的名称
            joinColumns={@JoinColumn(name="USER_ID",referencedColumnName="id")},//中间表PRODUCT_ID字段关联PRODUCT的ID
            inverseJoinColumns={@JoinColumn(name="DEVICE_ID",referencedColumnName="id")})//中间表CATEGORY_ID字段关联CATEGORY的ID
    @ManyToMany
    private List<WebAPPUser> users=new ArrayList<WebAPPUser>();


    private String deviceNumber;
    private String deviceDetail;

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

    public List<WebAPPUser> getUsers() {
        return users;
    }

    public void setUsers(List<WebAPPUser> users) {
        this.users = users;
    }
}
