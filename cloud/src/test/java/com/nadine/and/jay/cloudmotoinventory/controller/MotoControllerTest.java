package com.nadine.and.jay.cloudmotoinventory.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nadine.and.jay.cloudmotoinventory.service.MotoServiceLayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MotoController.class)
public class MotoControllerTest {
    //controller tests and 404 cases

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MotoServiceLayer serviceLayer;


    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void saveMotorCyle() {
    }

    @Test
    public void findMotorcycleById() {
    }

    @Test
    public void findAllMotorcycles() {
    }

    @Test
    public void updateMotorcycle() {
    }

    @Test
    public void deleteMapping() {
    }
}