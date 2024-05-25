package sas.severstal.dto;

import sas.severstal.model.Product;
import sas.severstal.model.Supply;

import java.util.ArrayList;
import java.util.List;

public class MapperProduct {

    public MapperProduct() {
    }

    public static ArrayList<ProductDto> fromSupplyProductsDto(List<Product> products) {
        ArrayList<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            productDtos.add(new ProductDto(
                    product.getId(),
                    product.getName(),
                    product.getType(),
                    product.getPrice(),
                    product.getSupplier().getId()
            ));
        }
        return productDtos;
    }
}
