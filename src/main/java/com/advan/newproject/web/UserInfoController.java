package com.advan.newproject.web;

import com.advan.newproject.entity.DTO.UserInfoDTO;
import com.advan.newproject.entity.UserInfo;
import com.advan.newproject.service.UserInfoService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(method = RequestMethod.POST)
    public String addUser(@RequestBody UserInfo userInfo){
        JSONObject jsonObject = new JSONObject();
        try{
            userInfoService.addUser(userInfo);
            jsonObject.put("Version","1.0");
            jsonObject.put("ErrorCode","0");
        }catch (Exception e){
            jsonObject.put("Version", "1.0");
            jsonObject.put("ErrorCode", "1");
            jsonObject.put("ErrorMessage", e.getMessage());
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteUser(Long userId){
        JSONObject jsonObject = new JSONObject();
        try{
            userInfoService.deleteUser(userId);
            jsonObject.put("Version","1.0");
            jsonObject.put("ErrorCode","0");
        }catch (Exception e){
            jsonObject.put("Version", "1.0");
            jsonObject.put("ErrorCode", "1");
            jsonObject.put("ErrorMessage", e.getMessage());
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getAllUser(){
        JSONObject jsonObject = new JSONObject();
        List<UserInfoDTO> userInfoDTOList;
        try{
            userInfoDTOList = userInfoService.getAllUserInfo();
            jsonObject.put("users",userInfoDTOList);
            jsonObject.put("Version","1.0");
            jsonObject.put("ErrorCode","0");
        }catch (Exception e){
            jsonObject.put("Version", "1.0");
            jsonObject.put("ErrorCode", "1");
            jsonObject.put("ErrorMessage", e.getMessage());
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
