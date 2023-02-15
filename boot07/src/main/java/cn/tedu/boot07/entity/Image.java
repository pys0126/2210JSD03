package cn.tedu.boot07.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/8
 **/
public class Image {
    private Integer id;
    private String title;
    private String urls;
    @JsonFormat(pattern = "yyyy年MM月dd日 HH点mm分ss秒", timezone = "GMT+8")
    private Date created;

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", urls='" + urls + '\'' +
                ", created=" + created +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
