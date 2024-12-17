package com.store.service;

import com.store.entity.Product;
import com.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(value = "productService")
@Scope(value = "singleton")
public class ProductService implements IProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductByID(Long productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public List<Product> getByProductName(String productName) {
        return productRepository.findByName(productName);
    }

    @Override
    public List<Product> getByProductBrand(String brand) {
        return productRepository.findByBrand(brand);
    }

    @Override
    public String updateProductById(Long productId, Product product) {
        Product productResponse= productRepository.findById(productId).get();

        if(productResponse != null){
            productResponse.setName(product.getName());
            productResponse.setBrand(product.getBrand());
            productResponse.setPrice(product.getPrice());
            productRepository.save(productResponse);
            return "Product Updated Successfully";
        }
        return "Product not exists";
    }

    @Override
    public String deleteProductById(Long productId) {
        Optional<Product> product= productRepository.findById(productId);

        if (product != null){
            productRepository.deleteById(productId);
            return "Product Deleted Successfully";
        }
        else {
            return "Product not exist";
        }
    }


}
