package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Product;
import com.example.demo.Model.Request.ProductRequest;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductByProductId(Integer productId);

    void addNewProduct(ProductRequest productRequest);

    void updateProductByProductId(Integer id, ProductRequest productRequest);
    
}
