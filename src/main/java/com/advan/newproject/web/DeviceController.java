package com.advan.newproject.web;

import com.advan.newproject.entity.Device;
import com.advan.newproject.service.DeviceService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping(method = RequestMethod.GET,value = "userId")
    public String getServices (@RequestParam(value = "userId") long userId) {
        JSONObject jsonObject = new JSONObject();
        List<Device> devices;
        try {
            devices = deviceService.getDevices(userId);
            jsonObject.put("devices",devices);
            jsonObject.put("Version","1.0");
            jsonObject.put("ErrorCode","0");
        }catch (Exception e){
            jsonObject.put("Version", "1.0");
            jsonObject.put("ErrorCode", "1");
            jsonObject.put("ErrorMessage", e.getMessage());
            e.printStackTrace();
        }
        return jsonObject.toJSONString();
    }
}
