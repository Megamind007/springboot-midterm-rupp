package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Product;
import com.example.demo.Model.Request.ProductRequest;
import com.example.demo.Service.ProductService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@AllArgsConstructor
@RequestMapping("api/v1/Products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("AllProducts")
    public List<Product> getAllProduct() {
        List<Product> allProduct = productService.getAllProducts();
        return allProduct;
    }

    @GetMapping("/{id}")
    public Product getMethodName(@PathVariable Integer id) {
        Product product = productService.getProductByProductId(id);
        return product;
    }
    
    @PostMapping
    public String addNewProduct(@RequestBody ProductRequest productRequest) {
        productService.addNewProduct(productRequest);
        return "Successfully added";
    }

    @PutMapping("/{id}")
    public String updateProductByProductId(@PathVariable Integer id, @RequestBody ProductRequest productRequest) {
        productService.updateProductByProductId(id, productRequest);
        return "Update Successfully";
    }
    
}
