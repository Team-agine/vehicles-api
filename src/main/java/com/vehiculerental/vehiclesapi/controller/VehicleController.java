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
    @PutMapping(value = "/vehicles/{id}")
    public Vehicle updateVehicle(@PathVariable String id,  @RequestBody Vehicle vehicle, HttpServletResponse response){

        Vehicle vehicleToEdit = null;
        try {
            vehicleToEdit = vehicleDao.findById(id).orElseThrow(()-> new Exception());
        } catch (Exception e) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
        }

        if (vehicleToEdit != null) {

            if (vehicle.getBrand() != null) {
                vehicleToEdit.setBrand(vehicle.getBrand());
            }
            if (vehicle.getType() != null) {
                vehicleToEdit.setType(vehicle.getType());
            }
            if (vehicle.getColor() != null) {
                vehicleToEdit.setColor(vehicle.getColor());
            }
            if (vehicle.getBasePrice() != null) {
                vehicleToEdit.setBasePrice(vehicle.getBasePrice());
            }
            if (vehicle.getKmPrice() != null) {
                vehicleToEdit.setKmPrice(vehicle.getKmPrice());
            }
            if (vehicle.getHorsePower() != null) {
                vehicleToEdit.setHorsePower(vehicle.getHorsePower());
            }

                vehicleToEdit.setUpdatedAt(new Date());

        }
        return vehicleDao.saveAndFlush(vehicleToEdit);
    }

    @DeleteMapping (value = "/vehicles/{id}")
    public void deleteVehicle(@PathVariable String id, HttpServletResponse response) {

        Vehicle vehicleToDelete =  null;
        try {
            vehicleToDelete = vehicleDao.findById(id).orElseThrow(()-> new Exception());
        } catch (Exception e) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
        }

        vehicleDao.delete(vehicleToDelete);
    }

}
