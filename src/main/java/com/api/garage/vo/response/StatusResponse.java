package com.api.garage.vo.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatusResponse {

    private String plate;
    private String color;
    private List<String> slots;
}
