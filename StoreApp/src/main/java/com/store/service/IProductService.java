package com.store.service;

import com.store.entity.Product;

import java.util.List;

public interface IProductService {

    public Product addProduct(Product product);
    public List<Product> getAllProducts();
    public Product getProductByID(Long id);
    public List<Product> getByProductName(String productName);
    public List<Product> getByProductBrand(String brand);
    public String updateProductById(Long productId, Product product);
    public String deleteProductById(Long productId);
}
