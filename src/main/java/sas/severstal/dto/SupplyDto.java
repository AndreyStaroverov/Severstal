package sas.severstal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sas.severstal.model.ProductSupply;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplyDto {

    private Long id;
    @NotBlank
    @Positive
    private Long supplierId;
    @NotBlank
    private Timestamp supplyDate;
    @NotEmpty
    private List<ProductSupplyDto> products;
}
