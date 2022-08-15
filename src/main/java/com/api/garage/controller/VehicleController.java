package com.api.garage.controller;

import com.api.garage.dto.request.VehicleRequestDto;
import com.api.garage.enums.ActionType;
import com.api.garage.service.VehicleService;
import com.api.garage.vo.request.VehicleRequest;
import com.api.garage.vo.response.VehicleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicle")
@RequiredArgsConstructor
@Slf4j
public class VehicleController {

    private final ModelMapper modelMapper;
    private final VehicleService vehicleService;

    @PostMapping(value = "/parkVehicle")
    public ResponseEntity<VehicleResponse> parkVehicle(@RequestBody VehicleRequest request) {
        VehicleRequestDto requestDto = modelMapper.map(request, VehicleRequestDto.class);
        if (requestDto != null) {
            vehicleService.saveVehicle(requestDto);
            VehicleResponse response = VehicleResponse.builder()
                    .message("Allocated " + requestDto.getVehicleType().getDesc())
                    .build();
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.ok(new VehicleResponse());
    }

    @PostMapping(value = "/leaveVehicle")
    public void leaveVehicle(@RequestParam Integer vehicleId) {
        if (vehicleId != null) {
            vehicleService.deleteVehicle(vehicleId);
        }
    }

}
