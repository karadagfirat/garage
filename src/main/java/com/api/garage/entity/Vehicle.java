package com.api.garage.entity;

import com.api.garage.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "VEHICLE")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique=true)
    @NotNull
    private Long id;

    @Column(name = "PLATE", unique=true, nullable=false)
    @NotNull
    private String plate;

    @Column(name = "COLOR")
    @NotNull
    private String color;

    @Column(name = "VEHICLE_TYPE")
    @NotNull
    private VehicleType vehicleType;

    @Column(name = "STATUS")
    @NotNull
    private String actionType;

    @Column(name = "SLOT")
    @NotNull
    @ElementCollection
    private List<Long> slot;
}
