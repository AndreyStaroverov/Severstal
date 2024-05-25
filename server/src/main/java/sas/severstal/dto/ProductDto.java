package sas.severstal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String type;
    @Positive
    private Double price;
    @Positive
    private Long supplierId;
}
