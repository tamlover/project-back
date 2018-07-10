package com.advan.newproject.service;

import com.advan.newproject.entity.Device;
import com.advan.newproject.repository.DeviceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    @Autowired
    private DeviceDao deviceDao;

    public void addDevice(Device device) throws Exception {

        Device dev = deviceDao.getDeviceByDeviceNumber(device.getDeviceNumber());
        if (dev == null){
            deviceDao.save(device);
        }else {
            throw new Exception("The device exist");
        }
    }

    public void deleteDevice(Long deviceId){
        Device dev = deviceDao.getDeviceByIdIs(deviceId);
        if (dev!= null){
            deviceDao.deleteById(dev.getId());
        }
    }

    public Device getDevice(Long id){
        return deviceDao.getDeviceByIdIs(id);
    }

    public List<Device> getDevices (Long userId) {
        List<Device> devices;
        if (userId == (long)1){
            devices = deviceDao.getAll();
            return  devices;
        }
        return null;
    }

    public void updateDevice(Device device){
        deviceDao.save(device);
    }
}
