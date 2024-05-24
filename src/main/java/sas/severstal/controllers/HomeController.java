package sas.severstal.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String home() {
        return "index.html"; // Возвращает index.html из папки src/main/resources/static
    }
}