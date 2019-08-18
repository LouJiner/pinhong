package com.zryx.company.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "page")
public class PageConfig<T> {
    //每页的大小，从配置文件当中获取
    public  int pageSize;
    //当前页码，也是从配置文件当中获取
    public  int pageNum;
    //当前页的数据
    private List<T> pageData;
    //总页数
    private int pageCount;
    //总记录数（总行数）
    private int dataCount;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    /**
     * 计算总页数：如果能除尽则直接得到相除的结果，否则在相除的结果上加一
     * @return
     */
    public int getPageCount() {
        if(dataCount%pageSize==0) {
            return dataCount/pageSize;
        }else {
            return dataCount / pageSize + 1;
        }
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }
}
