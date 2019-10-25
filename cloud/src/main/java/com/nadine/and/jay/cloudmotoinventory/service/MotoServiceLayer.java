package com.nadine.and.jay.cloudmotoinventory.service;

import com.nadine.and.jay.cloudmotoinventory.dto.Motorcycle;
import com.nadine.and.jay.cloudmotoinventory.repository.MotorcycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MotoServiceLayer {

    @Autowired
    MotorcycleRepository motoRepo;

    public MotoServiceLayer(MotorcycleRepository motoRepo) {
        this.motoRepo = motoRepo;
    }

    public Motorcycle saveMotorcycle(Motorcycle moto){
        return motoRepo.save(moto);
    }

    public Motorcycle findMotorcycleById(int id){
        Motorcycle moto = motoRepo.findById(id).get();

        //check if optional is present and throw error if not present
        if (!motoRepo.findById(id).isPresent()){
            throw new IllegalArgumentException("No motorcycle found with this id");
        }
        //return motorcycle if present
        return moto;
    }

    public List<Motorcycle> findAllMotorcycles(){
        return motoRepo.findAll();
    }

    public void updateMotorcycle(Motorcycle motorcycle){
        motoRepo.save(motorcycle);
    }

    public void deleteMotorcycleById(int id){
        motoRepo.deleteById(id);
    }
}
