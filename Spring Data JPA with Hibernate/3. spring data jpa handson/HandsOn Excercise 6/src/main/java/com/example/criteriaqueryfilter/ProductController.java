package com.example.criteriaqueryfilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/search")
    public List<Product> searchProducts(@RequestBody ProductSearchCriteria criteria) {
        return productRepository.searchProducts(criteria);
    }
}
