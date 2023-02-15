package cn.tedu.coolshark.pojo.vo;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/15
 **/
public class ProductTopVo {
     private Integer id;
     private String title;
     private String saleCount;

    @Override
    public String toString() {
        return "ProductTopVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", saleCount='" + saleCount + '\'' +
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

    public String getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(String saleCount) {
        this.saleCount = saleCount;
    }
}
