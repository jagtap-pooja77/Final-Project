package com.example.artisan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.artisan.model.Product;

import com.example.artisan.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    // create product
    public Object addProduct(Product product) {
        try {

            repo.save(product);
            return "product add ";

        } catch (Exception e) {
            e.getMessage();
        }
        return "product add ";
    }

    // get all product
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    // get product by id
    public Object getProductById(Long id) {
        return repo.findById(id);
    }

    // update product data

    public Object updateProduct(Long id, Product product) {
        try {
            Product productData = repo.findById(id).orElseThrow();
            productData.setName(product.getName());
            productData.setDescription(product.getDescription());
            productData.setPrice(product.getPrice());
            productData.setCat_id(product.getCat_id());

            repo.save(productData);
            return "product with id " + id + " updated.";
        } catch (Exception e) {
            e.getMessage();
        }
        return product;
    }

    // delete product
    public String deleteProduct(Long id) {
        repo.deleteById(id);
        return "Successfully Product deleted";
    }

}
