package base;

import com.alibaba.fastjson.JSONObject;
import ds.JdbcTemplateEng;

import org.apache.poi.ss.formula.functions.T;
import spring.response.ResponseMsg;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BaseBussinessDao extends BaseDao {

    public  ResponseMsg insert( String inputString) throws IOException {
//    public static  String  add(FavourBean user) throws IOException {
        boolean flag=false;

        String courseFile =instance.getClass().getResource("").getPath() ;
        courseFile=courseFile+"sql"+"/Create.sql";
//        courseFile=courseFile+"sql/"+baseRoot+"/Create.sql";
        Map<String, Object> map = new HashMap<String, Object>();
        String id= UUID.randomUUID().toString();




        JSONObject jsonObject = JSONObject.parseObject(inputString);
        //json对象转Map
        Map<String,Object> mapInput = (Map<String,Object>)jsonObject;

        JdbcTemplateEng.getInstance().parserData(mapInput);


//        mapInput.remove("content");

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
//        String result= JSON.toJSONString(responseMsg);

        return  responseMsg;
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
//             wrappingParams(params);

        String courseFile= getSqlFilePath(fileName);//instance 需要初始化
        List<Object>  list=  JdbcTemplateEng.query(courseFile,mappedClass,params);
        ResponseMsg  responseMsg=new ResponseMsg();
        if (null!=list){
            responseMsg.setSuccess(true);
            responseMsg.setData(list);
//            responseMsg.setData(JSONObject.toJSONString(list));
        }else {
            responseMsg.setSuccess(false);
        }
        return  responseMsg;

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
