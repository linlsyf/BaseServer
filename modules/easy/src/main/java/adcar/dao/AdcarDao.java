package adcar.dao;

import base.BaseBussinessDao;
import favour.dao.bean.FavourBean;
import spring.response.ResponseMsg;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class AdcarDao extends BaseBussinessDao {

//    public   ResponseMsg  add(String inputString) throws IOException {
//
//
//        return insert(inputString);
//    }
//       return insert(DaoCon.BASE,inputString);
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
//    }
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
    public   ResponseMsg   list() throws IOException {

          return listAll(FavourBean.class);
//          return listAll(favour.dao.ExamCon.FAVOUR_BASE,FavourBean.class);
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

    public List<Object> search(Map params) throws IOException {

        return   searchPage(params,FavourBean.class);

    }


    public String delete(String[] ids) {
//          return  deleteByIds(ExamCon.FAVOUR_BASE,ids);
          return  deleteByIds(ids);

//        boolean flag=false;
//
//        String courseFile =instance.getClass().getResource("").getPath() ;
//        courseFile=courseFile+"sql/"+ DaoCon.USER_BASE+"/Remove.sql";
//        Map<String, Object> map = new HashMap<String, Object>();
//
//        //json对象转Map
//        Map<String,Object> mapInput =new HashMap<>();
//
//        String  idsSql="";
//        int i=0;
//        for (String id:ids ) {
//             if (i!=0){
//                 idsSql=idsSql+",";
//             }
//             idsSql=idsSql+id;
//
//            i=i+1;
//
//        }
//
//
//          mapInput.put("ids",idsSql);
//
//        JdbcTemplateEng.getInstance().parserData(mapInput);
//
//        int count=  JdbcTemplateEng.getInstance().exec(courseFile, mapInput);
//        String msg="删除成功";
//
//        if (count>0){
//            flag=true;
//        }else{
//            msg="删除失败";
//        }
//        ResponseMsg responseMsg=new ResponseMsg();
//        responseMsg.setSuccess(flag);
//        responseMsg.setMsg(msg);
//
//        return   msg;
    }
}