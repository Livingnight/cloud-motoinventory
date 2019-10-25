package com.nadine.and.jay.motoedgeservice.service;

import com.nadine.and.jay.motoedgeservice.model.Motorcycle;
import com.nadine.and.jay.motoedgeservice.util.feign.MotoClient;
import com.nadine.and.jay.motoedgeservice.viewmodel.MotoViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class MotoServiceTest {
    @InjectMocks
    private MotoService motoService;
    @Mock
    private MotoClient motoClient;

    @Test
    public void shouldFetchAllMotos() {
        List<Motorcycle> listFromFeign = new ArrayList<>();
        Motorcycle moto1FromFeign = new Motorcycle();
        moto1FromFeign.setId(1);
        moto1FromFeign.setPrice(new BigDecimal("12345"));
        moto1FromFeign.setVin("1432an12");
        moto1FromFeign.setMake("make 1");
        moto1FromFeign.setModel("model 1");
        moto1FromFeign.setYear("2017");
        moto1FromFeign.setColor("black");
        Motorcycle moto2FromFeign = new Motorcycle();
        moto1FromFeign.setId(2);
        moto2FromFeign.setPrice(new BigDecimal("12345"));
        moto2FromFeign.setVin("1432an12");
        moto2FromFeign.setMake("make 1");
        moto2FromFeign.setModel("model 1");
        moto2FromFeign.setYear("2017");
        moto2FromFeign.setColor("black");
        Motorcycle moto3FromFeign = new Motorcycle();
        moto1FromFeign.setId(3);
        moto3FromFeign.setPrice(new BigDecimal("7500"));
        moto3FromFeign.setVin("1432an12");
        moto3FromFeign.setMake("make 1");
        moto3FromFeign.setModel("model 1");
        moto3FromFeign.setYear("2017");
        moto3FromFeign.setColor("black");
        listFromFeign.add(moto1FromFeign);
        listFromFeign.add(moto2FromFeign);
        listFromFeign.add(moto3FromFeign);

        doReturn(listFromFeign).when(motoClient).fetchAllMotos();

        List<MotoViewModel> transformedList = new ArrayList<>();
        for ( Motorcycle moto : listFromFeign ){
            MotoViewModel motoViewModel = new MotoViewModel();
            motoViewModel.setId(moto.getId());
            motoViewModel.setPrice(moto.getPrice());
            motoViewModel.setMake(moto.getMake());
            motoViewModel.setModel(moto.getModel());
            motoViewModel.setYear(moto.getYear());
            motoViewModel.setColor(moto.getColor());
            transformedList.add(motoViewModel);
        }

        List<MotoViewModel> actualList = motoService.fetchAllMotos();

        assertEquals(3, actualList.size());
        assertTrue(actualList.contains(transformedList.get(0)));
        assertTrue(actualList.contains(transformedList.get(1)));
    }
    @Test
    public void shouldReturnEmptyList_WhenNoMotos(){
        List<Motorcycle> emptyListFromFeign = new ArrayList<>();
        doReturn(emptyListFromFeign).when(motoClient).fetchAllMotos();

        List<MotoViewModel> fromFeignClient = motoService.fetchAllMotos();

        assertEquals(0, fromFeignClient.size());


    }

    @Test
    public void purchaseMoto() {
        Motorcycle realMoto = new Motorcycle();
        realMoto.setId(1);
        realMoto.setPrice(new BigDecimal("7500"));
        realMoto.setVin("1432an12");
        realMoto.setMake("make 1");
        realMoto.setModel("model 1");
        realMoto.setYear("2017");
        realMoto.setColor("black");

        doReturn(realMoto).when(motoClient).fethMoto(1);

        MotoViewModel toPurchase = new MotoViewModel();
        toPurchase.setId(realMoto.getId());
        toPurchase.setPrice(realMoto.getPrice());
        toPurchase.setVin(realMoto.getVin());
        toPurchase.setMake(realMoto.getMake());
        toPurchase.setModel(realMoto.getModel());
        toPurchase.setYear(realMoto.getYear());
        toPurchase.setColor(realMoto.getColor());

        MotoViewModel purchasedMoto = new MotoViewModel();
        purchasedMoto.setId(realMoto.getId());
        purchasedMoto.setPrice(realMoto.getPrice());
        purchasedMoto.setVin(realMoto.getVin());
        purchasedMoto.setMake(realMoto.getMake());
        purchasedMoto.setModel(realMoto.getModel());
        purchasedMoto.setYear(realMoto.getYear());
        purchasedMoto.setColor(realMoto.getColor());
        purchasedMoto.setSalesTax(new BigDecimal(".0675"));
        purchasedMoto.setDocFees(new BigDecimal("234"));
        purchasedMoto.setTranspoCost(new BigDecimal("395"));
        purchasedMoto.setTotalCost(new BigDecimal("8635.25"));

        MotoViewModel actualMotoViewModel = motoService.purchaseMoto(toPurchase);

        assertEquals(purchasedMoto, actualMotoViewModel);
    }

}