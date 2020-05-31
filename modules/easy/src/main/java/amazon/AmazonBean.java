package amazon;

import base.BaseBean;

public class AmazonBean extends BaseBean {
    private String totalview;
    private String createtime;
    private String todaynum;

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
}
