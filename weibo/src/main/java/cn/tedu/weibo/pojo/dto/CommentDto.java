package cn.tedu.weibo.pojo.dto;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/11
 **/
public class CommentDto {
    private Integer w_id;
    private String content;
    private String nickname;

    @Override
    public String toString() {
        return "CommentDto{" +
                "w_id=" + w_id +
                ", content='" + content + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    public Integer getW_id() {
        return w_id;
    }

    public void setW_id(Integer w_id) {
        this.w_id = w_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
