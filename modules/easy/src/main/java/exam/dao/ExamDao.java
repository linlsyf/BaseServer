package exam.dao;

import base.BaseBussinessDao;
import base.BaseDao;
import com.alibaba.fastjson.JSONObject;
import ds.JdbcTemplateEng;
import exam.dao.bean.ExamBean;
import spring.response.ResponseMsg;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class ExamDao extends BaseBussinessDao {


    public   ResponseMsg  add(String inputString) throws IOException {



       return insert(inputString);
//       return insert(ExamCon.FAVOUR_BASE,inputString);
//    public static  String  add(FavourBean user) throws IOException {
//        boolean flag=false;
//
//        String courseFile =instance.getClass().getResource("").getPath() ;
//        courseFile=courseFile+"sql/"+ DaoCon.USER_BASE+"/Create.sql";
//        Map<String, Object> map = new HashMap<String, Object>();
//        String id= UUID.randomUUID().toString();
//
//
//
//
//        JSONObject  jsonObject = JSONObject.parseObject(inputString);
//        //json对象转Map
//        Map<String,Object> mapInput = (Map<String,Object>)jsonObject;
//
//                JdbcTemplateEng.getInstance().parserData(mapInput);
//
//
////        mapInput.remove("content");
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
////        String result= JSON.toJSONString(responseMsg);

//        return  responseMsg;
    }
    public   ResponseMsg  update(Map params) throws IOException {
        boolean flag=false;
        return  super.update(params);
    }
    public static  String  remove(ExamBean user) throws IOException {
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
    public   ResponseMsg   list() throws IOException {

          return listAll(ExamBean.class);
//          return listAll(ExamCon.FAVOUR_BASE,FavourBean.class);
//        boolean flag=false;
//
//        String courseFile= BaseDao.getSqlFilePath(DaoCon.USER_BASE,BaseDao.LIST_TYPE);//instance 需要初始化
//        Map<String, Object> map = new HashMap<String, Object>();
//        List<FavourBean>  list=  JdbcTemplateEng.query(courseFile, FavourBean.class,map);
//        ResponseMsg  responseMsg=new ResponseMsg();
//               if (null!=list){
//                   flag=true;
//                   responseMsg.setSuccess(true);
//                   responseMsg.setData(JSONObject.toJSONString(list));
//               }else {
//                   responseMsg.setSuccess(false);
//               }
//        return  responseMsg;

    }

    public   ResponseMsg   search(Map params) throws IOException {

        return   searchPage(params,ExamBean.class);

    }
    public   ResponseMsg   searchRecord(Map params) throws IOException {
        String  fileName="SearchRecord.sql";
        return  searchPageByName(params,ExamBean.class,fileName);



    }
    public   ResponseMsg   typeList(Map params) throws IOException {
        String  fileName="TypeList.sql";
        return  searchPageByName(params,ExamBean.class,fileName);



    }
    public   ResponseMsg   radomExam(Map params) throws IOException {
        String  fileName="RadomSearch.sql";
        return  searchPageByName(params,ExamBean.class,fileName);



    }
    public   ResponseMsg   updateUserExam(Map params) throws IOException {
        String  fileName="UpdateUserExam.sql";
        return  searchPageByName(params,ExamBean.class,fileName);



    }
    public   ResponseMsg   createUserExamRecord(Map params) throws IOException {
        String  fileName="CreateUserExam.sql";

       return    insertByName(params,fileName);

    }
    public  ResponseMsg get(String id) throws IOException {



         return  super.get(id,ExamBean.class);
    }


    public String delete(String[] ids) {
          return  deleteByIds(ids);
    }
}