package com.nadine.and.jay.cloudmotoinventory.controller;

import com.nadine.and.jay.cloudmotoinventory.dto.Motorcycle;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
@RequestMapping(value = "/motos")
public class MotoController {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Motorcycle saveMotorCyle(@RequestBody @Valid Motorcycle moto){
        return null;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Motorcycle findMotorcycleById(@PathVariable int id){
        return null;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Motorcycle> findAllMotorcycles(){
        return null;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateMotorcycle(@RequestBody @Valid Motorcycle moto){

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMapping(@PathVariable int id){

    }
}
