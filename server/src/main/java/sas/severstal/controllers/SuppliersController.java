package sas.severstal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sas.severstal.dto.SupplierDto;
import sas.severstal.service.SuppliersService;

import java.util.List;

@RestController
@RequestMapping(path = "/suppliers")
@Validated
public class SuppliersController {

    private final SuppliersService suppliersService;

    public SuppliersController(@Autowired SuppliersService suppliersService) {
        this.suppliersService = suppliersService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SupplierDto> getAll() {
        return suppliersService.getAll();
    }
}
