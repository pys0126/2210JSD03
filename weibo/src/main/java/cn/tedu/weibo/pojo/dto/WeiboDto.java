package cn.tedu.weibo.pojo.dto;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/10
 **/
public class WeiboDto {
    private String content;
    private String urls;

    @Override
    public String toString() {
        return "WeiboDto{" +
                "content='" + content + '\'' +
                ", urls='" + urls + '\'' +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }
}
