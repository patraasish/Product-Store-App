package com.store.controller;

import com.store.entity.Product;
import com.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@Scope("request")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> addProduct(@RequestBody Product product){

        Product res=productService.addProduct(product);
        return new ResponseEntity<>(res, HttpStatus.CREATED);

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getProducts(){

        List<Product> res=productService.getAllProducts();
        return new ResponseEntity<>(res, HttpStatus.OK);

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProductById(@PathVariable Long id){

        Product res=productService.getProductByID(id);
        return new ResponseEntity<>(res, HttpStatus.OK);

    }

    @PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateProductById(@PathVariable Long id, @RequestBody Product product){

        Product productDTO=new Product();
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setBrand(product.getBrand());
        String res=productService.updateProductById(id, productDTO);
        return new ResponseEntity<>(res, HttpStatus.OK);

    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){

        String res=productService.deleteProductById(id);
        return new ResponseEntity<>(res, HttpStatus.NO_CONTENT);

    }


}
