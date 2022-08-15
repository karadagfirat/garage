package com.api.garage.service;

import com.api.garage.dto.response.StatusResponseDto;
import com.api.garage.entity.Garage;

import java.util.List;

public interface StatusService {
    List<StatusResponseDto> getGarageStatus();
}
