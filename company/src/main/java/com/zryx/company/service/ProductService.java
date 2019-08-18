package com.zryx.company.service;

import com.zryx.company.common.config.PageConfig;
import com.zryx.company.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProduct();

    public void addProduct(Product product);

    public void delProduct(int id);

    public void updProduct(Product product);

    public Product getAllProductById(int id);

    public List<Product> selTop4Product(int start);

    /**
     * 得到当前页的数据
     * @param page 就是第几页
     * @return
     */
    PageConfig<Product> getProductByPage(int page);
}
