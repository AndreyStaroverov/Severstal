package sas.severstal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sas.severstal.dto.MapperProduct;
import sas.severstal.dto.SupplierDto;
import sas.severstal.model.Supplier;
import sas.severstal.repository.SupplierRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuppliersService {

    private final SupplierRepository supplierRepository;

    public SuppliersService(@Autowired SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<SupplierDto> getAll() {
        List<SupplierDto> supplierDtos = new ArrayList<>();
        List<Supplier> suppliers = supplierRepository.findAll();
        for (Supplier supplier: suppliers) {
            supplierDtos.add(new SupplierDto(
                    supplier.getId(),
                    supplier.getName(),
                    MapperProduct.fromSupplyProductsDto(supplier.getProducts())
            ));
        }
        return supplierDtos;
    }
}
