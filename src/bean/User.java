package bean;

public class User {
    private String userid;
    private String password;
    private String username;
    private String tel;

    public User(String userid, String password, String username, String tel) {
        this.userid = userid;
        this.password = password;
        this.username = username;
        this.tel = tel;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}