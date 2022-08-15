package com.api.garage.controller;

import com.api.garage.dto.response.StatusResponseDto;
import com.api.garage.entity.Garage;
import com.api.garage.service.StatusService;
import com.api.garage.vo.response.StatusResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/status")
@RequiredArgsConstructor
@Slf4j
public class StatusController {

    private final String COMMAND = "status";

    private final StatusService statusService;
    private final ModelMapper modelMapper;

    @GetMapping(value = "/getStatus")
    public ResponseEntity<List<StatusResponse>> getGarageStatus(@RequestParam String command) {
        if (COMMAND.equals(command)) {
            List<StatusResponseDto> responseDtoList = statusService.getGarageStatus();
            List<StatusResponse> responseList = (List<StatusResponse>) modelMapper.map(responseDtoList, StatusResponse.class);
            return ResponseEntity.ok(responseList);
        }
        log.info("Girilen komut eksik veya hatalıdır!");
        return ResponseEntity.badRequest().body(null);
    }
}
