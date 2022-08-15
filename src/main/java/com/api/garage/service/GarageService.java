package com.api.garage.service;

import com.api.garage.dto.response.GarageResponseDto;
import com.api.garage.entity.Vehicle;

public interface GarageService {
    Boolean checkIfCarExist(Long vehicleId);
    void saveVehicleToGarage(Vehicle vehicle);
}
