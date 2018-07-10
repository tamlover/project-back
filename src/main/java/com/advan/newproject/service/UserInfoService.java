package com.advan.newproject.service;

import com.advan.newproject.entity.DTO.UserInfoDTO;
import com.advan.newproject.entity.Device;
import com.advan.newproject.entity.UserInfo;
import com.advan.newproject.repository.DeviceDao;
import com.advan.newproject.repository.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    private DeviceDao deviceDao;

    public UserInfoDTO login(String account, String password) throws Exception {
        UserInfoDTO userInfoDTO;
        UserInfo u = userInfoDao.getUserInfoByAccount(account);
            if (u == null){
                throw new Exception("This account is not exist");
            }else {
                if (!u.getPassword().equals(password)) {
                    throw new Exception("The account or password is wrong");
                }else {
                    userInfoDTO = new UserInfoDTO(u);
                }
            }
        return userInfoDTO;
    }

    public void addUser(UserInfo userInfo) throws Exception {
        UserInfo u=userInfoDao.getUserInfoByAccount(userInfo.getAccount());
        if (u ==null){
            userInfoDao.save(userInfo);
        }else {
            throw new Exception("This user exist");
        }
    }

    public void deleteUser(Long userId){
        userInfoDao.deleteById(userId);
    }

    public void updateUser(UserInfo userInfo){
        userInfoDao.save(userInfo);
    }

    public List<UserInfoDTO> getAllUserInfo(){
        List<UserInfo> userInfoList = userInfoDao.getAll();
        List<UserInfoDTO> userInfoDTOList = new ArrayList<>();
        for(UserInfo u:userInfoList){
            UserInfoDTO userInfoDTO = new UserInfoDTO(u);
            userInfoDTOList.add(userInfoDTO);
        }
        return  userInfoDTOList;
    }

//    public void addDeviceToUser(Long[] deviceIds, Long userId){
//        Device device;
//        UserInfo userInfo = userInfoDao.getUserInfoById(userId);
//        List<Device> deviceList = userInfo.getDeviceList();
//        for (int i = 0;i < deviceIds.length;i++){
//            device = deviceDao.getDeviceByIdIs(deviceIds[i]);
//            if (device != null) {
//                deviceList.add(device);
//            }
//        }
//        userInfoDao.save(userInfo);
//    }
//
//    public void deteleDeviceFromUser(Long deviceId, Long userId){
//        UserInfo userInfo = userInfoDao.getUserInfoById(userId);
//        List<Device> deviceList = userInfo.getDeviceList();
//        Device device = deviceDao.getDeviceByIdIs(deviceId);
//
//        deviceList.remove(device);
//        userInfoDao.save(userInfo);
//    }
}
