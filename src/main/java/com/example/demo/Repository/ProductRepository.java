package com.example.demo.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.Model.Product;
import com.example.demo.Model.Request.ProductRequest;

@Mapper
public interface ProductRepository {

    @Select("""
        select * from product;
    """)
    @Results(id = "ProductMapper",value = {
        @Result(property = "productId",column = "product_id"),
        @Result(property = "productName",column = "product_name"),
        @Result(property = "pricePerUnit",column = "price_per_unit"),
        @Result(property = "activeForSell",column = "active_for_sell"),
    })
    List<Product> findAllProducts();

    @Select("""
        select * from product where product_id = #{productId};
    """)
    @ResultMap("ProductMapper")
    Product findByProductId(Integer productId);

    @Insert("""
        insert into product(product_name,price_per_unit,active_for_sell) values(#{pro.productName},#{pro.pricePerUnit},#{pro.activeForSell});
    """)
    void addNewProduct(@Param("pro") ProductRequest productRequest);

    @Update("""
        update product set product_name = #{pro.productName},price_per_unit = #{pro.pricePerUnit},active_for_sell = #{pro.activeForSell} where product_id = #{productId};
    """)
    void updateProductByProductId(Integer productId,@Param("pro") ProductRequest productRequest);
}
