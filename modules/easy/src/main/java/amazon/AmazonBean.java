package amazon;

import base.BaseBean;

public class AmazonBean extends BaseBean {
    private String totalview;
    private String createtime;
    private String todaynum;

    private  String content2;
    private  String head_url2;
    private  String name2;

    public String getTotalview() {
        return totalview;
    }

    public void setTotalview(String totalview) {
        this.totalview = totalview;
    }

    @Override
    public String getCreatetime() {
        return createtime;
    }

    @Override
    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getTodaynum() {
        return todaynum;
    }

    public void setTodaynum(String todaynum) {
        this.todaynum = todaynum;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public String getHead_url2() {
        return head_url2;
    }

    public void setHead_url2(String head_url2) {
        this.head_url2 = head_url2;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }
}
