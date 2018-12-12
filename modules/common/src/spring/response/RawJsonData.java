package spring.response;

/**
 * Created by Administrator on 2017/7/31.
 */
public class RawJsonData {

    Object data;

    public RawJsonData(Object data){
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}
