package com.zryx.company.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 123
 * @create 2019/7/16
 */
public class News {
    private int newsId;
    private String title;
    private String content;
    private Date writeDate;

    public News() {
    }

    public News(int newsId, String title, String content, Date writeDate) {
        this.newsId = newsId;
        this.title = title;
        this.content = content;
        this.writeDate = writeDate;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {

            return content;

    }

    public void setContent(String content) {
        this.content = content;
    }

    /*public String getWriteDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(writeDate);
    }*/

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

    /**
     * 重写toString方法
     * @return
     */
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "新闻编号：" + newsId + "新闻标题：" + title + "内容：" +
                content + "发表日期" + sdf.format(writeDate);
    }
}
