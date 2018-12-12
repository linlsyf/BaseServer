package human.dao.bean;

import java.io.Serializable;

public class RoleUser implements Serializable {
    //属性名和数据库表的字段对应
    private String id;
    private String name;// 权限名字
    private String userId;// 权限用户id

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
