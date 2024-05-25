package sas.severstal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDto {
    private Timestamp date;
    private Long supplyId;
    private String supplierName;
    private String productName;
    private String productType;
    private Double totalAmount;
    private Double totalCost;
}
