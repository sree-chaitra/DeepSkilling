package com.example.criteriaqueryfilter;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> searchProducts(ProductSearchCriteria criteria);
}
