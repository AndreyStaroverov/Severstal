package sas.severstal.dto;

import sas.severstal.model.Product;
import sas.severstal.model.Supplier;
import sas.severstal.model.Supply;

import java.util.ArrayList;
import java.util.List;

public class MapperSupply {

    public MapperSupply() {}

    public static Supply DtoToSupply(SupplyDto supply, Supplier supplier) {
        return new Supply(
                1L,
                supplier,
                supply.getSupplyDate(),
                supply.getProducts()
        );
    }

    public static SupplyDto SupplyToDto(Supply supply) {
        return new SupplyDto(
                supply.getId(),
                supply.getSupplier().getId(),
                supply.getSupplyDate(),
                supply.getProducts()
        );
    }

    public static ArrayList<SupplyDto> fromSupplyProductsDto(List<Supply> supplies) {
        ArrayList<SupplyDto> supplyDtos = new ArrayList<>();
        for (Supply supply : supplies) {
            supplyDtos.add(new SupplyDto(
                    supply.getId(),
                    supply.getSupplier().getId(),
                    supply.getSupplyDate(),
                    supply.getProducts()
            ));
        }
        return supplyDtos;
    }
}
