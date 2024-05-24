package sas.severstal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sas.severstal.dto.MapperSupply;
import sas.severstal.dto.ProductSupplyDto;
import sas.severstal.dto.ReportDto;
import sas.severstal.dto.SupplyDto;
import sas.severstal.handlers.NotFoundException;
import sas.severstal.model.ProductSupply;
import sas.severstal.model.Supply;
import sas.severstal.repository.ProductRepository;
import sas.severstal.repository.SupplierRepository;
import sas.severstal.repository.SupplyRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        Supply supply = MapperSupply.DtoToSupply(supplyDto, supplierRepository.getById(supplyDto.getSupplierId()), null);
        supply = supplyRepository.save(supply);

        List<ProductSupply> productSupplies = new ArrayList<>();
        for (ProductSupplyDto pr : supplyDto.getProducts()) {
            productSupplies.add(new ProductSupply(
                    null,
                    supply,
                    productRepository.getById(pr.getProductId()),
                    pr.getAmount()
            ));
        }
        supply.setProducts(productSupplies);
        supply = supplyRepository.save(supply);

        return MapperSupply.SupplyToDto(supply);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<ReportDto> getSuppliesBetweenDates(Timestamp startDate, Timestamp endDate) {
        List<Supply> supplies = supplyRepository.findBySupplyDateBetween(startDate, endDate);

        Map<String, ReportDto> reportMap = new HashMap<>();

        for (Supply supply : supplies) {
            for (ProductSupply productSupply : supply.getProducts()) {
                String key = supply.getSupplier().getName() + "_" + productSupply.getProduct().getName();

                if (reportMap.containsKey(key)) {
                    ReportDto reportDto = reportMap.get(key);
                    reportDto.setTotalAmount(reportDto.getTotalAmount() + productSupply.getAmount());
                    reportDto.setTotalCost(reportDto.getTotalCost() + (productSupply.getProduct().getPrice() * productSupply.getAmount()));
                } else {
                    ReportDto reportDto = new ReportDto(
                            supply.getId(),
                            supply.getSupplier().getName(),
                            productSupply.getProduct().getName(),
                            productSupply.getProduct().getType(),
                            productSupply.getAmount(),
                            (productSupply.getProduct().getPrice() * productSupply.getAmount())
                    );
                    reportMap.put(key, reportDto);
                }
            }
        }
        return new ArrayList<>(reportMap.values());
    }
    }

