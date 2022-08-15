package com.api.garage.service.ipml;

import com.api.garage.dto.request.VehicleRequestDto;
import com.api.garage.entity.Vehicle;
import com.api.garage.repo.VehicleRepo;
import com.api.garage.service.GarageService;
import com.api.garage.service.TicketService;
import com.api.garage.service.VehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class VehicleServiceImpl implements VehicleService {

    public static Integer SLOT = 10;

    private final VehicleRepo vehicleRepo;
    private final ModelMapper modelMapper;
    private final GarageService garageService;
    private final TicketService ticketService;


    /**
     * buraya geldiğinde garage'a gidip slot ataması yapılacak. ondan sonra kayıt atılacak
     * slot kontrolü Garage servisinde yapılacak. uygun slot yok ise hata verecek
     * var ise sonrasında garage service'e gidecek 1,2,3... sıralamasına göre en yakın ve boş olana yerleşecek
     * garage tablosunda da araç ve slot bilgisi bulunacak
     * save ederken slot bilgisi de vehicle tablosuna yazılacak
     * aracın bilgisi ise ticket servise gidecek ve plaka bilgisi kayıt edilecek
     */

    @Override
    public void saveVehicle(VehicleRequestDto requestDto) {
        Vehicle vehicle = modelMapper.map(requestDto, Vehicle.class);
        vehicleRepo.save(vehicle);
        Boolean check = garageService.checkIfCarExist(vehicle.getId());
        if (!check) {
            checkVehicleSlotSize(vehicle);
            ticketService.saveTicket(vehicle);
        } else {
            vehicleRepo.deleteById(vehicle.getId());
        }
    }

    @Override
    public void deleteVehicle(Integer vehicleId) {
            vehicleRepo.deleteById(Long.valueOf(vehicleId));

    }

    public void checkVehicleSlotSize(Vehicle vehicle) {
            garageService.saveVehicleToGarage(vehicle);
    }

}
