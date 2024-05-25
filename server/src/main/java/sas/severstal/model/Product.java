package sas.severstal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products", schema = "public")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;
    @NotBlank
    @Column(name = "typeof", nullable = false)
    private String type;
    @Column(name = "price", nullable = false)
    private Double price;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}
