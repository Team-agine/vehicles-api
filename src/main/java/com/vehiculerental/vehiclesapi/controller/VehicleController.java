package com.vehiculerental.vehiclesapi.controller;

import com.vehiculerental.vehiclesapi.dao.VehicleDao;
import com.vehiculerental.vehiclesapi.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;


@RestController
public class VehicleController {

    @Autowired
    private VehicleDao vehicleDao;

    //Vehicles
    @GetMapping(value = "/vehicles")
    public List<Vehicle> listAllVehicles(){
        return vehicleDao.findAll();

    }
    @GetMapping(value = "/vehicles/{id}")
    public Vehicle getVehicleById(@PathVariable String id, HttpServletResponse response){
        Vehicle vehicle = null;
        try {
            vehicle = vehicleDao.findById(id).orElseThrow(()-> new Exception());
        } catch (Exception e) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
        }
        return vehicle;

    }
    @PostMapping(value = "/vehicles")
    public Vehicle createVehicle(@RequestBody Vehicle vehicle){
        vehicle.setId(vehicle.getId().toLowerCase());
        vehicle.setCreatedAt(new Date());
        vehicle.setUpdatedAt(new Date());
        return vehicleDao.save(vehicle);

    }

}
