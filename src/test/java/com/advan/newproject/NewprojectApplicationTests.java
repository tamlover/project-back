package com.advan.newproject;

import com.advan.newproject.entity.DTO.UserInfoDTO;
import com.advan.newproject.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.soap.Addressing;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewprojectApplicationTests {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void tesLogin () throws Exception {
        UserInfoDTO userInfoDTO;
        userInfoDTO = userInfoService.login("test","123");
        System.out.println(userInfoDTO.getAccount());
    }

}
