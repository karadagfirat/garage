package com.api.garage.dto.request;

import com.api.garage.enums.ActionType;
import com.api.garage.enums.VehicleType;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class VehicleRequestDto {

    private Long vehicleId;

    @NotNull
    private ActionType actionType;

    @NotNull
    private String plate;

    @NotNull
    private String color;

    @NotNull
    private VehicleType vehicleType;
}
