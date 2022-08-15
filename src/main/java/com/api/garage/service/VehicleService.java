package com.api.garage.service;

import com.api.garage.dto.request.VehicleRequestDto;

public interface VehicleService {
    void saveVehicle(VehicleRequestDto requestDto);
    void deleteVehicle(Integer requestDto);
}
