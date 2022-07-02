package cn.edu.guet.bean;

import java.util.Objects;

public class User {
    private String id;
    private String nickName;
    private String password;
    private String salt;
    private String username;
    private String email;
    private String mobile;
    private String createtime;
    private String rolename;
    private String roleid;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(nickName, user.nickName) && Objects.equals(password, user.password) && Objects.equals(salt, user.salt) && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(mobile, user.mobile) && Objects.equals(createtime, user.createtime) && Objects.equals(rolename, user.rolename) && Objects.equals(roleid, user.roleid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickName, password, salt, username, email, mobile, createtime, rolename, roleid);
    }



    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", createtime='" + createtime + '\'' +
                ", rolename='" + rolename + '\'' +
                ", roleid='" + roleid + '\'' +
                '}';
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
