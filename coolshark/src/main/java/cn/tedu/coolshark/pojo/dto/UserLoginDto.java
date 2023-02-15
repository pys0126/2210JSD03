package cn.tedu.coolshark.pojo.dto;

/**
 * 说明：
 *
 * @author: PYS
 * @date: 2023/2/13
 **/
public class UserLoginDto {
    private String username;
    private String password;

    @Override
    public String toString() {
        return "UserLoginDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
