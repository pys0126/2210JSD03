package cn.tedu.coolshark.pojo.entity;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/13
 **/
public class Category {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
