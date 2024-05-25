package sas.severstal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "supply_products", schema = "public")
public class ProductSupply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "supply_id")
    private Supply supply;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "amount")
    private Double amount;
}
