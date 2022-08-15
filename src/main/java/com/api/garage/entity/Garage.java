package com.api.garage.entity;

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
@Entity(name = "GARAGE")
@Table(name = "GARAGE")
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique=true)
    @NotNull
    private Long id;

    @Column(name = "STATUS")
    @NotNull
    private Boolean status;

    @Column(name = "PLATE")
    @NotNull
    private String plate;

    @Column(name = "PLATE")
    @NotNull
    private String color;

    @Column(name = "SLOT")
    @NotNull
    @ElementCollection
    private List<Long> slot;

    @Column(name = "vehicle")
    @NotNull
    private Long vehicleId;
}
