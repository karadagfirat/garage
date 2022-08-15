package com.api.garage.service.ipml;

import com.api.garage.dto.response.StatusResponseDto;
import com.api.garage.entity.Garage;
import com.api.garage.repo.GarageRepo;
import com.api.garage.service.StatusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatusServiceImpl implements StatusService {

    private final GarageRepo garageRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<StatusResponseDto> getGarageStatus() {
        List<StatusResponseDto> responseDtoList = new ArrayList<>();
        List<Garage> garage = garageRepo.findAll();
        for (int i = 0; i<garage.size(); i++) {
            responseDtoList.add(modelMapper.map(garage, StatusResponseDto.class));
        }
        return responseDtoList;
    }
}
