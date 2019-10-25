package com.nadine.and.jay.motoedgeservice.util.feign;

import com.nadine.and.jay.motoedgeservice.model.Motorcycle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("moto-service")
public interface MotoClient {
    @GetMapping("/motos")
    List<Motorcycle> fetchAllMotos();
    @GetMapping("/motos/{id}")
    Motorcycle fethMoto(@PathVariable int id);
    @PostMapping("/motots")
    Motorcycle purchaseMoto(@RequestBody Motorcycle motorcycle);
}
