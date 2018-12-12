package spring.response;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;

/**
 * 描述:
 */
/**
 * @apiDefine MbyError
 * @apiSuccess (失败输出) {String} msg 失败描述
 * @apiSuccess (失败输出) {String} code 失败代码
 * @apiSuccess (失败输出) {JSON} data 数据为空
 */

/**
 * @apiDefine MbySuccess
 * @apiSuccess (成功输出) {String} msg 操作成功
 * @apiSuccess (成功输出) {String} code 操作码为'0000'
 */
public class MBYResponseViewModel extends HashMap implements MBYViewModel {

    public MBYResponseViewModel(String code, String msg){
        setCode(code);
        setMsg(msg);
    }


    public  void setData(Object data){
        put("data", data);
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public  Object getData(){
       return get("data");
    }

    public String getMsg() {
        return (String) get("msg");
    }

    public void setMsg(String msg) {
        put("msg", msg);
    }

    public String getCode() {
       return (String) get("code");
    }

    public void setCode(String code) {
        put("code", code);
    }


    public void setVersion(String version){
        put("version", version);
    }

    public String getVersion(){
        return (String) get("version");
    }

}
