
package com.example.ormlearn;

import com.example.ormlearn.model.Stock;
import com.example.ormlearn.repository.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.Date;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static StockRepository stockRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        stockRepository = context.getBean(StockRepository.class);

        // Uncomment one at a time to test
        testGetFacebookStockInSeptember2019();
        //testGetGoogleStocksAbove1250();
        //testGetTop3ByVolume();
        //testGetLowestNetflixStocks();
    }

    private static void testGetFacebookStockInSeptember2019() {
        LOGGER.info("Start: testGetFacebookStockInSeptember2019");
        List<Stock> stocks = stockRepository.findByCodeAndDateBetween("FB", Date.valueOf("2019-09-01"), Date.valueOf("2019-09-30"));
        stocks.forEach(stock -> LOGGER.info("Stock: {}", stock));
        LOGGER.info("End: testGetFacebookStockInSeptember2019");
    }

    private static void testGetGoogleStocksAbove1250() {
        LOGGER.info("Start: testGetGoogleStocksAbove1250");
        List<Stock> stocks = stockRepository.findByCodeAndCloseGreaterThan("GOOGL", 1250.0);
        stocks.forEach(stock -> LOGGER.info("Stock: {}", stock));
        LOGGER.info("End: testGetGoogleStocksAbove1250");
    }

    private static void testGetTop3ByVolume() {
        LOGGER.info("Start: testGetTop3ByVolume");
        List<Stock> stocks = stockRepository.findTop3ByOrderByVolumeDesc();
        stocks.forEach(stock -> LOGGER.info("Stock: {}", stock));
        LOGGER.info("End: testGetTop3ByVolume");
    }

    private static void testGetLowestNetflixStocks() {
        LOGGER.info("Start: testGetLowestNetflixStocks");
        List<Stock> stocks = stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
        stocks.forEach(stock -> LOGGER.info("Stock: {}", stock));
        LOGGER.info("End: testGetLowestNetflixStocks");
    }
}
