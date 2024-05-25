package sas.severstal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSupplyDto {

    private Long id;
    @NotNull
    private Long supplyId;
    @NotNull
    private Long productId;
    @NotNull
    private Double amount;
}
