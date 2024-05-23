package sas.severstal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDto {
    private Long supplyId;
    private String supplierName;
    private String productName;
    private String productType;
    private Double totalAmount;
    private Double totalCost;
}
