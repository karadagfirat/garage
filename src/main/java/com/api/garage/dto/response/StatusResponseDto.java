package com.api.garage.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatusResponseDto {

    private String plate;
    private String color;
    private List<String> slots;
}
