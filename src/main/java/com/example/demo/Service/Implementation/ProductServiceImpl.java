package com.example.demo.Service.Implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Product;
import com.example.demo.Model.Request.ProductRequest;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Service.ProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts(){
        return productRepository.findAllProducts();
    }

    @Override
    public Product getProductByProductId(Integer productId){
        Product product  = productRepository.findByProductId(productId);
        if(product == null){
            throw new RuntimeException("Product not found");
        }
        return product;
    }

    @Override
    public void addNewProduct(ProductRequest productRequest){
        productRepository.addNewProduct(productRequest);
    }

    @Override
    public void updateProductByProductId(Integer id, ProductRequest productRequest){
        productRepository.updateProductByProductId(id, productRequest);
    }
    
}
