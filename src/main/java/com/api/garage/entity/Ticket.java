package com.api.garage.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TICKET")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique=true)
    @NotNull
    private Long id;

    @Column(name = "PLATE")
    @NotNull
    private String plate;

    @Column(name = "VEHICLE_ID", unique=true)
    @NotNull
    private Long vehicleId;
}
