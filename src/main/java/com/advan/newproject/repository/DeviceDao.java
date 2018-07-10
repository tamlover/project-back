package com.advan.newproject.repository;

import com.advan.newproject.entity.Device;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface DeviceDao extends CrudRepository<Device,Long> {


    Device getDeviceByDeviceNumber(String number);

    Device getDeviceByIdIs(Long id);

    @Query(value = "from Device ")
    List<Device> getAll();

}
