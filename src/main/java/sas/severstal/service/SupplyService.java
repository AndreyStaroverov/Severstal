package sas.severstal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sas.severstal.dto.MapperSupply;
import sas.severstal.dto.SupplyDto;
import sas.severstal.handlers.NotFoundException;
import sas.severstal.model.Product;
import sas.severstal.model.ProductSupply;
import sas.severstal.model.Supply;
import sas.severstal.repository.ProductRepository;
import sas.severstal.repository.SupplierRepository;
import sas.severstal.repository.SupplyRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class SupplyService {

    private final SupplyRepository supplyRepository;
    private final SupplierRepository supplierRepository;
    private final ProductRepository productRepository;

    public SupplyService(@Autowired SupplyRepository supplyRepository, SupplierRepository supplierRepository, ProductRepository productRepository) {
        this.supplyRepository = supplyRepository;
        this.supplierRepository = supplierRepository;
        this.productRepository = productRepository;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public SupplyDto saveSupply(SupplyDto supplyDto) {
        if (!supplierRepository.existsById(supplyDto.getSupplierId())) {
            throw new NotFoundException(String.format("Supplier with id=%s does not exist", supplyDto.getSupplierId()));
        }
        return MapperSupply.SupplyToDto(
                supplyRepository.save(MapperSupply.DtoToSupply(
                supplyDto,
                supplierRepository.getById(supplyDto.getSupplierId())
                )));
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<SupplyDto> getSuppliesBetweenDates(Timestamp startDate, Timestamp endDate) {
        return MapperSupply.fromSupplyProductsDto(supplyRepository.findBySupplyDateBetween(startDate, endDate));
    }
}
