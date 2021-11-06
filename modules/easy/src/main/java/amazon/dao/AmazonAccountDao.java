package amazon.dao;

import base.BaseBean;
import base.BaseBussinessDao;
import spring.response.ResponseMsg;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AmazonAccountDao extends BaseBussinessDao {


    //    public   ResponseMsg  add(String inputString) throws IOException {
//
//       return insert(inputString);
//    }
    public ResponseMsg update(Map params) throws IOException {
        boolean flag = false;
        return super.update(params);
    }

    public static String remove(BaseBean user) throws IOException {
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
        String result = "";
        return result;
    }

    public ResponseMsg list() throws IOException {

        return listAll(BaseBean.class);
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

    public List<Object> search(Map params) throws IOException {

        return searchPage(params, BaseBean.class);

    }

    public  List<Object>  searchRecord(Map params) throws IOException {
        String fileName = "SearchRecord.sql";
        return searchByName(params, BaseBean.class, fileName);


    }

    public  List<Object>  typeList(Map params) throws IOException {
        String fileName = "TypeList.sql";
        return searchByName(params, BaseBean.class, fileName);


    }

    public  List<Object>  radomExam(Map params) throws IOException {
        String fileName = "RadomSearch.sql";
        return searchByName(params, BaseBean.class, fileName);


    }

    public  List<Object> updateUserExam(Map params) throws IOException {
        String fileName = "UpdateUserExam.sql";
        return searchByName(params, BaseBean.class, fileName);


    }
    public ResponseMsg updateViewCount(Map params) throws IOException {
        String fileName = "updateViewCount.sql";

        params.put(BaseBussinessDao.KEY_updateFileName,fileName);
        return update(params);


    }

    public ResponseMsg createUserExamRecord(Map params) throws IOException {
        String fileName = "CreateUserExam.sql";

        return insertByName(params, fileName);

    }

    public ResponseMsg get(String id) throws IOException {


        return super.get(id, BaseBean.class);
    }


    public String delete(String[] ids) {
        return deleteByIds(ids);
    }

}