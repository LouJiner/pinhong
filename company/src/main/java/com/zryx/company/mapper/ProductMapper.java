package com.zryx.company.mapper;

import com.zryx.company.model.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {

    public List<Product> getAllProduct();

    public int addProduct(Product product);

    public int delProduct(@Param("pId") int productId);

    public int updProduct(Product product);

    public Product getAllProductById(@Param("id") int productId);

    public List<Product> selTop4Product(int start);

    List<Product> getProductByPage(@Param("from") int from, @Param("size") int size);

    int dataCount();

}
