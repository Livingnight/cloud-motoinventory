package com.nadine.and.jay.cloudmotoinventory.repository;

import com.nadine.and.jay.cloudmotoinventory.dto.Motorcycle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MotorcycleRepositoryTest {

    @Autowired
    private MotorcycleRepository motoRepo;

    @Before
    public void setUp() throws Exception {
        motoRepo.deleteAll();
    }

    @Test
    public void createMotocycleShouldReturnMotorCycle(){
        Motorcycle moto = new Motorcycle(new BigDecimal("10000.00"), "123abc", "Toyoya", "Vroomy", "2019", "blue");
        moto = motoRepo.save(moto);

        assertEquals(moto, motoRepo.findById(moto.getId()).get());
    }

    @Test
    public void findMotorcycleByIdShouldReturnMotorCycle(){
        Motorcycle moto = new Motorcycle(new BigDecimal("10000.00"), "123abc", "Toyoya", "Vroomy", "2019", "blue");
        moto = motoRepo.save(moto);

        assertEquals(moto, motoRepo.findById(moto.getId()).get());
    }

    @Test
    public void findAllMotorcyclesShouldReturnListOfMotorcycles(){
        Motorcycle moto = new Motorcycle(new BigDecimal("10000.00"), "123abc", "Toyoya", "Vroomy", "2019", "blue");
        moto = motoRepo.save(moto);

        Motorcycle moto1 = new Motorcycle(new BigDecimal("11000.00"), "123cdc", "Honda", "Zoomy", "2019", "blue");
        moto1 = motoRepo.save(moto1);

        assertEquals(2, motoRepo.findAll().size());
    }

    @Test
    public void updateMotorcyclesShouldReturnVoidAndUpdateMotorcycle(){
        Motorcycle moto = new Motorcycle(new BigDecimal("10000.00"), "123abc", "Toyoya", "Vroomy", "2019", "blue");
        moto = motoRepo.save(moto);

        moto.setColor("red");
        motoRepo.save(moto);

        assertEquals(moto, motoRepo.findById(moto.getId()).get());
        assertEquals("red", motoRepo.findById(moto.getId()).get().getColor());
    }

    @Test
    public void deleteMotorcycleByIdShouldReturnVoidAndDeleteMotorcycle(){
        Motorcycle moto = new Motorcycle(new BigDecimal("10000.00"), "123abc", "Toyoya", "Vroomy", "2019", "blue");
        moto = motoRepo.save(moto);
        assertEquals(moto, motoRepo.findById(moto.getId()).get());

        motoRepo.deleteById(moto.getId());
        assertTrue(!motoRepo.findById(moto.getId()).isPresent());
    }
}