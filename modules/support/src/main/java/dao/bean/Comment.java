package dao.bean;

import dao.bean.BaseBean;

public class Comment  extends BaseBean {
    private String title;
    private String content;
    private String imgeId;
    private String email;
    private String name;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgeId() {
        return imgeId;
    }

    public void setImgeId(String imgeId) {
        this.imgeId = imgeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
