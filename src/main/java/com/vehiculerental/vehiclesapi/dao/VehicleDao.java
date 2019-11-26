package com.vehiculerental.vehiclesapi.dao;

import com.vehiculerental.vehiclesapi.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleDao extends JpaRepository<Vehicle, String> {
    List<Vehicle> findByHorsePowerLessThan(Integer horsePower);

}
