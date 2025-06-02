package com.example.artisan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.artisan.model.Product;

import com.example.artisan.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService service;

    // Add new Product
    @PostMapping("/addproduct")
    public Object addProduct(@RequestBody Product product) {
        return service.addProduct(product);

    }

    // get all Products
    @GetMapping("/getallproducts")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    // get Product by id
    @GetMapping("getproduct/{id}")
    public Object getProductById(@PathVariable Long id) {
        return service.getProductById(id);

    }

    // update product data
    @PutMapping("/updateproduct/{id}")
    public Object updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return service.updateProduct(id, product);
    }

    // delete product data
    @DeleteMapping("/deleteproduct/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return service.deleteProduct(id);
    }

}
