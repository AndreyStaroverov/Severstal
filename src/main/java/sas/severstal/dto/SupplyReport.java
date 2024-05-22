package sas.severstal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplyReport {
    private String supplierName;
    private String productName;
    private String productType;
    private Double totalQuantity;
    private Double totalCost;
}
