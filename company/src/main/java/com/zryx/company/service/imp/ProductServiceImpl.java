package com.zryx.company.service.imp;

import com.zryx.company.common.config.PageConfig;
import com.zryx.company.common.exception.CustomException;
import com.zryx.company.mapper.ProductMapper;
import com.zryx.company.model.Product;
import com.zryx.company.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private PageConfig<Product> pageConfig;

    @Override
    public List<Product> getAllProduct() {
        List<Product> product=productMapper.getAllProduct();
        return product;
    }

    @Override
    public void addProduct(Product product) {
        int row=productMapper.addProduct(product);
        if (row==0){
            throw new CustomException(100,"增加产品出现异常");
        }
    }

    @Override
    public void delProduct(int id) {
        int row=productMapper.delProduct(id);
        if (row==0){
            throw new CustomException(100,"删除产品出现异常");
        }
    }

    @Override
    public void updProduct(Product product) {
        int row=productMapper.updProduct(product);
        if (row==0){
            throw new CustomException(100,"修改产品出现异常");
        }
    }

    @Override
    public Product getAllProductById(int id) {
        Product product=productMapper.getAllProductById(id);
        return product;
    }

    @Override
    public List<Product> selTop4Product(int start){
        return productMapper.selTop4Product(start);
    }

    @Override
    public PageConfig<Product> getProductByPage(int page) {
        //设置当前页
        pageConfig.setPageNum(page);
        //得到从哪开始查询
        int from = (page - 1) * pageConfig.pageSize;
        //得到查几条
        int size = pageConfig.pageSize;
        //查出当前页的数据
        List<Product> messages = productMapper.getProductByPage(from,size);
        //设置当前页
        pageConfig.setPageData(messages);
        //得到总数据量
        int count = productMapper.dataCount();
        //设置一共有几条数据
        pageConfig.setDataCount(count);
        //返回包含当前页的数据、当前页、总页数、总记录数的一个对象
        return pageConfig;
    }

}
