//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package base;

public class BaseBean {
    private String id;
    private String creator;
    private String createId;
    private String createtime;
    private String name;
    private String status;
    private String statusName;
    private String headImageName;
    private String headImageUrl;
    private String title;
    private String type;
    private String typecode;
    private String typename;
    private String content;
    private int pagecount;
    private int level=0;

    private String head_url;

    public BaseBean() {
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getHeadImageUrl() {
        return this.headImageUrl;
    }

    public void setHeadImageUrl(String headImageUrl) {
        this.headImageUrl = headImageUrl;
    }

    public String getHeadImageName() {
        return this.headImageName;
    }

    public void setHeadImageName(String headImageName) {
        this.headImageName = headImageName;
    }

    public String getTypecode() {
        return this.typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreator() {
        return this.creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreateId() {
        return this.createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public String getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypename() {
        return this.typename;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getHead_url() {
        return this.head_url;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setHead_url(String head_url) {
        this.head_url = head_url;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusName() {
        return this.statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public int getPagecount() {
        return this.pagecount;
    }

    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }
}
