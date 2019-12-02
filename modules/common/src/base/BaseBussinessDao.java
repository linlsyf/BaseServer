package base;

import com.alibaba.fastjson.JSONObject;
import ds.JdbcTemplateEng;

import org.apache.poi.ss.formula.functions.T;
import spring.response.ResponseMsg;

import java.io.IOException;
import java.util.*;

public class BaseBussinessDao extends BaseDao {
    public  ResponseMsg insert( String inputString) throws IOException {
        JSONObject jsonObject = JSONObject.parseObject(inputString);
        //json对象转Map
        Map<String,Object> mapInput = (Map<String,Object>)jsonObject;
         return  insert(mapInput);
    }
    public  ResponseMsg insertByName( Map mapInput,String fileName) {
        boolean flag=false;

        String courseFile =instance.getClass().getResource("").getPath() ;
        courseFile=courseFile+"sql"+"/"+fileName;
//        courseFile=courseFile+"sql/"+baseRoot+"/Create.sql";
        Map<String, Object> map = new HashMap<String, Object>();
        String id= UUID.randomUUID().toString();
           mapInput.put("id",id);
        JdbcTemplateEng.getInstance().parserData(mapInput);

        int count=  JdbcTemplateEng.getInstance().exec(courseFile, mapInput);
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
    public  ResponseMsg insert( Map mapInput)   {
        boolean flag=false;

        return  insertByName(mapInput,"Create.sql");
//
//        String courseFile =instance.getClass().getResource("").getPath() ;
//        courseFile=courseFile+"sql"+"/Create.sql";
////        courseFile=courseFile+"sql/"+baseRoot+"/Create.sql";
//        Map<String, Object> map = new HashMap<String, Object>();
//        String id= UUID.randomUUID().toString();
//
//        JdbcTemplateEng.getInstance().parserData(mapInput);
//
//        int count=  JdbcTemplateEng.getInstance().exec(courseFile, mapInput);
//        String msg="添加成功";
//
//        if (count>0){
//            flag=true;
//        }else{
//            msg="添加失败";
//        }
//        ResponseMsg responseMsg=new ResponseMsg();
//        responseMsg.setSuccess(flag);
//        responseMsg.setMsg(msg);
//
//        return  responseMsg;
    }


    public   ResponseMsg   listAll(Class  mappedClass) throws IOException {
        boolean flag=false;

        String courseFile= getSqlFilePath(BaseDao.LIST_TYPE);//instance 需要初始化
//        String courseFile= getSqlFilePath(baseRoot,BaseDao.LIST_TYPE);//instance 需要初始化
        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> list=  JdbcTemplateEng.query(courseFile,mappedClass,map);
        ResponseMsg  responseMsg=new ResponseMsg();
        if (null!=list){
            flag=true;
            responseMsg.setSuccess(true);
            responseMsg.setData(JSONObject.toJSONString(list));
        }else {
            responseMsg.setSuccess(false);
        }
        return  responseMsg;

    }
    public   ResponseMsg   searchPage(Map params,Class  mappedClass) throws IOException {
        String  fileName="Search.sql";
        return  searchPageByName(params,mappedClass,fileName);
    }

    public   ResponseMsg   searchPageByName(Map params,Class  mappedClass,String fileName) throws IOException {
        boolean flag=false;
       Map  paramsSearch=      wrappingParams(params);

//        Map<String, Object> map = new HashMap<String, Object>();
        String courseFile= getSqlFilePath(fileName);//instance 需要初始化
        List<Object>  list=  JdbcTemplateEng.query(courseFile,mappedClass,paramsSearch);
        ResponseMsg  responseMsg=new ResponseMsg();
        if (null!=list){
            flag=true;
            responseMsg.setSuccess(true);
            responseMsg.setData(JSONObject.toJSONString(list));
            responseMsg.setData(list);
//            responseMsg.setData(JSONObject.toJSONString(list));
        }else {
            responseMsg.setSuccess(false);
        }
        if (null!=list){
            flag=true;
            responseMsg.setSuccess(true);
            responseMsg.setData(JSONObject.toJSONString(list));
        }else {
            responseMsg.setSuccess(false);
        }
        return  responseMsg;

    }

    private Map wrappingParams(Map params) {

        int start =0;
        int limit = 0;
            boolean containLimit=false;

            Map newMap=new HashMap();
        if (params.containsKey(start) && params.containsKey("limit")){
           start= (int)params.remove("start");
           limit= (int) params.remove("limit");
             containLimit=true;
          }
        for (Object o:params.keySet() ) {
            newMap.put(o,"'"+params.get(o)+"'");
        }
        if( containLimit )
    {
        newMap.put("start", start);
        newMap.put("limit", limit);
    }
    return newMap;
}

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

        JdbcTemplateEng.getInstance().parserData(mapInput);

        int count=  JdbcTemplateEng.getInstance().exec(courseFile, mapInput);
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
