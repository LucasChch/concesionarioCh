package ar.com.ventasservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentasController {

    @GetMapping("/ping")
    public String testEndpoint(){
        return "pong";
    }
}
