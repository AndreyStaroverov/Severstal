package sas.severstal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sas.severstal.dto.MapperProduct;
import sas.severstal.dto.ProductDto;
import sas.severstal.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(@Autowired ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getAll() {
        return MapperProduct.fromSupplyProductsDto(productRepository.findAll());
    }
}
