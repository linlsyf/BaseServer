package auth;

import java.io.Serializable;

public class User<T> implements Serializable {
    //属性名和数据库表的字段对应
    private String id;
    private String name;// 用户姓名
    private String sex;// 性别
    private String registerId;// 注册登录id
    private String isAdmin="0";// 登录名称

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }



    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }
}
