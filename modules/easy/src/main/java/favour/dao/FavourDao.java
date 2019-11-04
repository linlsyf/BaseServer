package favour.dao;

import base.BaseDao;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mw.utils.StringUtils;
import ds.JdbcTemplateEng;
import ds.SqlSessionFactoryUtil;
import favour.dao.bean.FavourBean;
import favour.dao.mapper.FavourBeanMapper;
import org.apache.ibatis.session.SqlSession;
import spring.response.ResponseMsg;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class FavourDao extends BaseDao {


    public static  ResponseMsg  add(String inputString) throws IOException {
//    public static  String  add(FavourBean user) throws IOException {
        boolean flag=false;

        String courseFile =instance.getClass().getResource("").getPath() ;
        courseFile=courseFile+"sql/"+ FavourCon.FAVOUR_BASE+"/Create.sql";
        Map<String, Object> map = new HashMap<String, Object>();
        String id= UUID.randomUUID().toString();




        JSONObject  jsonObject = JSONObject.parseObject(inputString);
        //json对象转Map
        Map<String,Object> mapInput = (Map<String,Object>)jsonObject;

                JdbcTemplateEng.getInstance().parserData(mapInput);


//        mapInput.remove("content");

        int count=  JdbcTemplateEng.getInstance().create(courseFile, mapInput);
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
    public static  String  update(FavourBean user) throws IOException {
//        boolean flag=false;
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//        FavourBeanMapper studentMapper = sqlSession.getMapper(FavourBeanMapper.class);
//
//        int count=studentMapper.update(user);
//        sqlSession.commit();
//
//        // 释放资源
//        sqlSession.close();
//        if (count>0){
//            flag=true;
//        }
//
//        ResponseMsg responseMsg=new ResponseMsg();
//        responseMsg.setSuccess(flag);
//        String result=JSON.toJSONString(responseMsg);
        String result="";
        return  result;
    }
    public static  String  remove(FavourBean user) throws IOException {
//        boolean flag=false;
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//        FavourBeanMapper studentMapper = sqlSession.getMapper(FavourBeanMapper.class);
//
//        int count=studentMapper.delete(user.getId());
//        sqlSession.commit();
//
//        // 释放资源
//        sqlSession.close();
//        if (count>0){
//            flag=true;
//        }
//
//        ResponseMsg responseMsg=new ResponseMsg();
//        responseMsg.setSuccess(flag);
//        String result=JSON.toJSONString(responseMsg);
//        return  result;
        String result="";
        return  result;
    }
    public static   List<FavourBean>   list() throws IOException {
        boolean flag=false;

        String courseFile= BaseDao.getSqlFilePath(FavourCon.FAVOUR_BASE,BaseDao.LIST_TYPE);//instance 需要初始化
        Map<String, Object> map = new HashMap<String, Object>();
        List<FavourBean>  list=  JdbcTemplateEng.query(courseFile, FavourBean.class,map);
        return  list;

    }
    public static FavourBean get(String id) throws IOException {
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//
//        FavourBeanMapper studentMapper = sqlSession.getMapper(FavourBeanMapper.class);
//        FavourBean user = studentMapper.get(id);
//        // 释放资源
//        sqlSession.close();

//        String resultOrde=JSON.toJSONString(easy.FavourBean);

         return  null;
    }


}