package com.api.garage.service.ipml;

import com.api.garage.entity.Garage;
import com.api.garage.entity.Vehicle;
import com.api.garage.repo.GarageRepo;
import com.api.garage.service.GarageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GarageServiceImpl implements GarageService {

    private final GarageRepo garageRepo;

    @Override
    public Boolean checkIfCarExist(Long vehicleId) {
        if (garageRepo.existsById(vehicleId)) {
            log.info("Araç zaten var!");
            return false;
        }
        return true;
    }

    @Override
    public void saveVehicleToGarage(Vehicle vehicle) {
        //for içinde yapılacak
        for (int i = 0; i<vehicle.getSlot().size(); i++) {
            Garage garage = Garage.builder()
                    .status(false)
                    .slot(vehicle.getSlot())
                    .vehicleId(vehicle.getId())
                    .plate(vehicle.getPlate())
                    .color(vehicle.getColor())
                    .build();
            log.info("Araç kaydedildi!");
            garageRepo.save(garage);
        }
    }
}
