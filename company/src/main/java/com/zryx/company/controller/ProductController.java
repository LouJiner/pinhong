package com.zryx.company.controller;

import com.zryx.company.common.config.PageConfig;
import com.zryx.company.common.web.BaseController;
import com.zryx.company.model.Product;
import com.zryx.company.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController extends BaseController {

    @Autowired
    ProductService productService;

    @PostMapping("/initProduct1")
    public String initProduct(){
        List<Product> product=productService.getAllProduct();
        String json = dealQueryResult(product,product);
        logger.debug("json===>" + json);
        return json;
    }

    @PostMapping("/selTop4Product")
    public String selTop4Product(int start) {
        List<Product> top4Product = productService.selTop4Product(start);
        String result = dealQueryResult(top4Product,top4Product);
        return result;
    }

    @PostMapping("/initProduct")
    public String initProduct(@RequestParam(value="page",required = false,defaultValue = "1") Integer page) {
        PageConfig pageConfig = productService.getProductByPage(page);
        String json = dealQueryResult(pageConfig,pageConfig);
        logger.debug("json===>" + json);
        return json;
    }

    @PostMapping("/addProduct")
    public String addProduct(Product product){
        productService.addProduct(product);
        return dealSuccessResutl("增添成功",null);
    }

    @PostMapping("/delProduct")
    public String delProduct(int id){
        productService.delProduct(id);
        return dealSuccessResutl("删除成功",null);
    }

    @PostMapping("/updProduct")
    public String updProduct(Product product){
        productService.updProduct(product);
        return dealSuccessResutl("修改成功",null);
    }

    @PostMapping("/getAllProductById")
    public String getAllProductById(int id){
        Product product=productService.getAllProductById(id);
        String json = dealQueryResult(product,product);
        logger.debug("json===>" + json);
        return json;
    }
}
