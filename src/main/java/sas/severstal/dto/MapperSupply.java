package sas.severstal.dto;

import sas.severstal.model.Product;
import sas.severstal.model.ProductSupply;
import sas.severstal.model.Supplier;
import sas.severstal.model.Supply;

import java.util.ArrayList;
import java.util.List;

public class MapperSupply {

    public MapperSupply() {}

    public static Supply DtoToSupply(SupplyDto supply, Supplier supplier, List<ProductSupply> productSupplies) {
        return new Supply(
                1L,
                supplier,
                supply.getSupplyDate(),
                productSupplies
        );
    }

    public static SupplyDto SupplyToDto(Supply supply) {
        List<ProductSupplyDto> productSupplyDtos = new ArrayList<>();

        for (ProductSupply pr: supply.getProducts()) {
            productSupplyDtos.add(new ProductSupplyDto(
                    pr.getId(),
                    pr.getSupply().getId(),
                    pr.getProduct().getId(),
                    pr.getAmount()
            ));
        }
        return new SupplyDto(
                supply.getId(),
                supply.getSupplier().getId(),
                supply.getSupplyDate(),
                productSupplyDtos
        );
    }

    public static ArrayList<SupplyDto> fromSupplyProductsDto(List<Supply> supplies) {
        ArrayList<SupplyDto> supplyDtos = new ArrayList<>();
        for (Supply supply : supplies) {
            supplyDtos.add(SupplyToDto(supply));
        }
        return supplyDtos;
    }
}
