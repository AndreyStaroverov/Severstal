package sas.severstal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sas.severstal.dto.ProductDto;
import sas.severstal.dto.SupplyDto;
import sas.severstal.service.ProductService;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(path = "/products")
@Validated
public class ProductsController {

    private final ProductService productService;

    public ProductsController(@Autowired ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDto> getAll() {
        return productService.getAll();
    }
}
