package sas.severstal.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sas.severstal.model.Product;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDto {

    private Long id;
    private String name;
    private List<ProductDto> products;
}
