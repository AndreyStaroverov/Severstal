package sas.severstal.repository;

import sas.severstal.model.Supply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface SupplyRepository extends JpaRepository<Supply, Long> {
    List<Supply> findBySupplyDateBetween(Timestamp startDate, Timestamp endDate);
}
