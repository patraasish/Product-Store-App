package com.store.repository;

import com.store.entity.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "productRepository")
@Scope(value = "singleton")
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByName(String name);
    List<Product> findByBrand(String brand);

}
