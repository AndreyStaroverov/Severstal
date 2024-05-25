package sas.severstal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Supply", schema = "public")
public class Supply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
    @Column(name = "supply_date", nullable = false)
    private Timestamp supplyDate;
    @OneToMany(mappedBy = "supply", cascade = CascadeType.ALL)
    private List<ProductSupply> products;
}
