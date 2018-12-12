package human.dao.bean;

import java.io.Serializable;

public class Role implements Serializable {
    //属性名和数据库表的字段对应
    private String id;
    private String name;// 权限名字
    private String userId;// 权限用户id
    private String code;// 权限用户id

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
