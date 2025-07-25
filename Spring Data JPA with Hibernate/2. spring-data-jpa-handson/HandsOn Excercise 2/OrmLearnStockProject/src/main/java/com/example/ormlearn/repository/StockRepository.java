
package com.example.ormlearn.repository;

import com.example.ormlearn.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import java.sql.Date;
import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Integer> {

    List<Stock> findByCodeAndDateBetween(String code, Date startDate, Date endDate);

    List<Stock> findByCodeAndCloseGreaterThan(String code, double price);

    List<Stock> findTop3ByOrderByVolumeDesc();

    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
