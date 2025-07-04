package com.example.criteriaqueryfilter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> searchProducts(ProductSearchCriteria criteria) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> query = cb.createQuery(Product.class);
        Root<Product> product = query.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();

        if (criteria.getCustomerReview() != null) {
            predicates.add(cb.greaterThanOrEqualTo(product.get("customerReview"), criteria.getCustomerReview()));
        }
        if (criteria.getHardDiskSize() != null) {
            predicates.add(cb.equal(product.get("hardDiskSize"), criteria.getHardDiskSize()));
        }
        if (criteria.getRamSize() != null) {
            predicates.add(cb.equal(product.get("ramSize"), criteria.getRamSize()));
        }
        if (criteria.getCpuSpeed() != null) {
            predicates.add(cb.greaterThanOrEqualTo(product.get("cpuSpeed"), criteria.getCpuSpeed()));
        }
        if (criteria.getOperatingSystem() != null) {
            predicates.add(cb.equal(product.get("operatingSystem"), criteria.getOperatingSystem()));
        }
        if (criteria.getWeight() != null) {
            predicates.add(cb.lessThanOrEqualTo(product.get("weight"), criteria.getWeight()));
        }
        if (criteria.getCpu() != null) {
            predicates.add(cb.equal(product.get("cpu"), criteria.getCpu()));
        }

        query.select(product).where(cb.and(predicates.toArray(new Predicate[0])));
        return entityManager.createQuery(query).getResultList();
    }
}
