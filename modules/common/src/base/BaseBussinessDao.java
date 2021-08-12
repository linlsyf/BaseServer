package base;

import ds.JdbcEng;

import spring.response.ResponseMsg;
import utils.TimeAreaUtils;
import utils.TimeUtils;

import java.io.IOException;
import java.util.*;

/**
 * 通用链接数据库数据层
 */
public class BaseBussinessDao extends BaseDao {
    public static String KEY_updateFileName="updateFileName";
    /**
     * 通用创建数据方法
     */
    public  ResponseMsg insert( Map mapInput)   {
        return  insertByName(mapInput,"Create.sql");

    }
    /**
     * 根据存储sql文件名插入数据
     */
    public  ResponseMsg insertByName( Map mapInput,String fileName) {
        boolean flag=false;
        String courseFile =instance.getClass().getResource("").getPath() ;
        courseFile=courseFile+"sql"+"/"+fileName;
        Map<String, Object> map = new HashMap<String, Object>();
        String id=(String) mapInput.get("id");
            id= UUID.randomUUID().toString();
            mapInput.put("id",id);
        JdbcEng.getInstance().parserData(mapInput);
        int count=  JdbcEng.getInstance().exec(courseFile, mapInput);
        String msg="添加成功";
        if (count>0){
            flag=true;
        }else{
            msg="添加失败";
        }
        ResponseMsg responseMsg=new ResponseMsg();
        responseMsg.setSuccess(flag);
        responseMsg.setMsg(msg);
        responseMsg.setData(id);
        return  responseMsg;
    }

    /**
     * 获取所有数据
     */
        public   ResponseMsg   listAll(Class  mappedClass) throws IOException {
        boolean flag=false;
        String courseFile= getSqlFilePath(BaseDao.LIST_TYPE);//instance 需要初始化
        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> list=  JdbcEng.query(courseFile,mappedClass,map);
        ResponseMsg  responseMsg=new ResponseMsg();
        if (null!=list){
            flag=true;
            responseMsg.setSuccess(true);
            responseMsg.setData(list);
        }else {
            responseMsg.setSuccess(false);
        }
        return  responseMsg;
    }
    /**
     * 根据条件查询数据
     */
    public   ResponseMsg   searchPage(Map params,Class  mappedClass) throws IOException {
        String  fileName="Search.sql";
        return  searchPageByName(params,mappedClass,fileName);
    }
    /**
     * 获取数据详情
     */
    public   ResponseMsg   get(String id,Class  mappedClass) throws IOException {
        String  fileName="Get.sql";
        String courseFile =instance.getClass().getResource("").getPath() ;
        courseFile=courseFile+"sql"+"/"+fileName;
       Object resultObject=  JdbcEng.get(courseFile,mappedClass,id);
        ResponseMsg  responseMsg=new ResponseMsg();
        if (null!=resultObject){

            responseMsg.setSuccess(true);
            responseMsg.setData(resultObject);
        }else {
            responseMsg.setSuccess(false);
        }
        return  responseMsg;
    }
    /**
     * 更新数据
     */
    public   ResponseMsg  update(Map params) throws IOException {
        boolean flag=false;
        String courseFile =instance.getClass().getResource("").getPath() ;
        String  updateFileName="Update.sql";
           if (params.containsKey("updateFileName")){
               updateFileName=(String) params.get("updateFileName");
           }
        courseFile=courseFile+"sql"+"/"+updateFileName;
        params.put("updatetime", TimeAreaUtils.getTimeNow());
        JdbcEng.getInstance().parserData(params);
        int count=  JdbcEng.getInstance().exec(courseFile, params);
        String msg="更新成功";
        if (count>0){
            flag=true;
        }else{
            msg="更新失败";
        }
        ResponseMsg responseMsg=new ResponseMsg();
        responseMsg.setSuccess(flag);
        responseMsg.setMsg(msg);
        return  responseMsg;
    }
    /**
     * 指定存储sql名词定制查询
     */
    public   ResponseMsg   searchPageByName(Map params,Class  mappedClass,String fileName) throws IOException {
        boolean flag=false;
       Map  paramsSearch=      wrappingParams(params);
//        Map<String, Object> map = new HashMap<String, Object>();
        String courseFile= getSqlFilePath(fileName);//instance 需要初始化
        List<Object>  list=  JdbcEng.query(courseFile,mappedClass,paramsSearch);
        ResponseMsg  responseMsg=new ResponseMsg();
        if (null!=list){
            flag=true;
            responseMsg.setSuccess(true);
            responseMsg.setData(list);
            responseMsg.setData(list);
//            responseMsg.setData(JSONObject.toJSONString(list));
        }else {
            responseMsg.setSuccess(false);
        }
        if (null!=list){
            flag=true;
            responseMsg.setSuccess(true);
            responseMsg.setData(list);
        }else {
            responseMsg.setSuccess(false);
        }
        return  responseMsg;
    }
    /**
     * 处理特殊参数，
     */
    private Map wrappingParams(Map params) {
        int start =0;
        int limit = 0;
            Map newMap=new HashMap();
        if (params.containsKey("start") && params.containsKey("limit")){
           start= Integer.parseInt(params.remove("start").toString());
           limit=Integer.parseInt(params.remove("limit").toString());
            newMap.put("start", start);
            newMap.put("limit", limit);
          }
        if (params.containsKey("page") && params.containsKey("limit")){
           start= Integer.parseInt(params.remove("page").toString());
           limit=Integer.parseInt(params.remove("limit").toString());
            newMap.put("start", start);
            newMap.put("limit", limit);
          }
        for (Object o:params.keySet() ) {
            newMap.put(o,"'"+params.get(o)+"'");
        }
          return  newMap;
}
    /**
     * 删除指定id数据
     */
    public String deleteByIds(String[] ids) {
        boolean flag=false;
        String courseFile =instance.getClass().getResource("").getPath() ;
        courseFile=courseFile+"sql"+"/Remove.sql";
//        courseFile=courseFile+"sql/"+ baseRoot+"/Remove.sql";
        Map<String, Object> map = new HashMap<String, Object>();
        //json对象转Map
        Map<String,Object> mapInput =new HashMap<>();
        String  idsSql="";
        int i=0;
        for (String id:ids ) {
            if (i!=0){
                idsSql=idsSql+",";
            }
            idsSql=idsSql+id;
            i=i+1;
        }
        mapInput.put("ids",idsSql);
        JdbcEng.getInstance().parserData(mapInput);
        int count=  JdbcEng.getInstance().exec(courseFile, mapInput);
        String msg="删除成功";
        if (count>0){
            flag=true;
        }else{
            msg="删除失败";
        }
        ResponseMsg responseMsg=new ResponseMsg();
        responseMsg.setSuccess(flag);
        responseMsg.setMsg(msg);
        return   msg;
    }
}
