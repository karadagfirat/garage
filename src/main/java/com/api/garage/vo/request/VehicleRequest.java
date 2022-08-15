package com.api.garage.vo.request;

import com.api.garage.enums.ActionType;
import com.api.garage.enums.VehicleType;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class VehicleRequest {

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
