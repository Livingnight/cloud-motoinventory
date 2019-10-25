package com.nadine.and.jay.cloudmotoinventory.service;

import com.nadine.and.jay.cloudmotoinventory.dto.Motorcycle;
import com.nadine.and.jay.cloudmotoinventory.repository.MotorcycleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class MotoServiceLayerTest {

    private MotorcycleRepository motoRepo;
    private MotoServiceLayer serviceLayer;

    private void setUpMotoRepoMock(){
        //mocking the behavior of the Motorcycle Repository
        motoRepo = mock(MotorcycleRepository.class);
        Motorcycle motorcycle = new Motorcycle(1, new BigDecimal("10000.00"), "123abc", "Toyoya", "Vroomy", "2019", "blue");
        Motorcycle motorcycle1 = new Motorcycle(new BigDecimal("10000.00"), "123abc", "Toyoya", "Vroomy", "2019", "blue");
        List<Motorcycle> motoList = new ArrayList<>();
        motoList.add(motorcycle);

        doReturn(motorcycle).when(motoRepo).save(motorcycle1);
        doReturn(Optional.of(motorcycle)).when(motoRepo).findById(1);
        doReturn(motoList).when(motoRepo).findAll();
    }
    @Before
    public void setUp() throws Exception {
        setUpMotoRepoMock();
        serviceLayer = new MotoServiceLayer(motoRepo);
    }

    @Test
    public void saveMotorcycle() {
        Motorcycle motorcycle1 = new Motorcycle(new BigDecimal("10000.00"), "123abc", "Toyoya", "Vroomy", "2019", "blue");
        motorcycle1 = serviceLayer.saveMotorcycle(motorcycle1);

        assertEquals(motorcycle1, serviceLayer.findMotorcycleById(motorcycle1.getId()));
    }

    @Test
    public void findMotorcycleById() {
        Motorcycle motorcycle1 = new Motorcycle(new BigDecimal("10000.00"), "123abc", "Toyoya", "Vroomy", "2019", "blue");
        motorcycle1 = serviceLayer.saveMotorcycle(motorcycle1);

        assertEquals(motorcycle1, serviceLayer.findMotorcycleById(motorcycle1.getId()));
    }

    @Test
    public void findAllMotorcycles() {
        Motorcycle motorcycle1 = new Motorcycle(new BigDecimal("10000.00"), "123abc", "Toyoya", "Vroomy", "2019", "blue");
        serviceLayer.saveMotorcycle(motorcycle1);

        assertEquals(1, serviceLayer.findAllMotorcycles().size());
    }

    @Test
    public void updateMotorcycle() {
        Motorcycle motorcycle1 = new Motorcycle(new BigDecimal("10000.00"), "123abc", "Toyoya", "Vroomy", "2019", "blue");
        motorcycle1 = serviceLayer.saveMotorcycle(motorcycle1);

        ArgumentCaptor<Motorcycle> motoCaptor = ArgumentCaptor.forClass(Motorcycle.class);
        serviceLayer.updateMotorcycle(motorcycle1);

        verify(motoRepo, times(2)).save(motoCaptor.capture());
    }

    @Test
    public void deleteMotorcycleById() {
        Motorcycle motorcycle1 = new Motorcycle(new BigDecimal("10000.00"), "123abc", "Toyoya", "Vroomy", "2019", "blue");
        motorcycle1 = serviceLayer.saveMotorcycle(motorcycle1);

        ArgumentCaptor<Integer> intCaptor = ArgumentCaptor.forClass(Integer.class);
        serviceLayer.deleteMotorcycleById(motorcycle1.getId());

        verify(motoRepo, times(1)).deleteById(intCaptor.capture());
    }
}