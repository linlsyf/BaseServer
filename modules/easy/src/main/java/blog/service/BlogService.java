package blog.service;

import applist.AppMsg;
import auth.User;
import base.BaseBean;
import blog.dao.BlogDao;
import com.alibaba.fastjson.JSON;
import com.sun.org.apache.bcel.internal.generic.I2F;
import config.LoginConfig;
import dict.dao.DictDao;
import exam.dao.ExamCon;
import exam.dao.ExamDao;
import favour.dao.bean.FavourBean;
import org.hibernate.metamodel.source.binder.ManyToAnyPluralAttributeElementSource;
import org.springframework.stereotype.Service;
import service.TokenCache;
import service.Ztoken;
import spring.response.ResponseMsg;
import sun.security.krb5.internal.PAData;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BlogService {

    BlogDao orderDao;


    public BlogDao getOrderDao() {
        if (orderDao==null){
            orderDao=new BlogDao();
            orderDao.instance=orderDao;
        }
        return orderDao;
    }

    public ResponseMsg update( Map params, Ztoken ztoken) throws Exception  {
//        ResponseMsg  responseMsg= LoginConfig.loginCheck(params,ztoken);
//        if (null!=responseMsg){
//            return responseMsg;
//        }
        return  getOrderDao().update(params);
    }
    public ResponseMsg add( Map params, Ztoken ztoken) throws Exception  {
        ResponseMsg  responseMsg= LoginConfig.loginCheck(params,ztoken);
        if (null!=responseMsg){
            return responseMsg;
        }
//        Map limitMap=new HashMap();
//           limitMap.put("title",params.get("title"));
//        ResponseMsg msg= search(limitMap,ztoken);
//        if (msg.isSuccess()) {
//            if (msg.getData().toString().length() > 2) {
//                msg=new ResponseMsg();
//                msg.setSuccess(false);
//                msg.setMsg("已经存在题名相同的数据");
//                return  msg;
//            }
//        }
//        if (!params.containsKey("type")){
//            params.put("type", ExamCon.TYPE_STUDY_COMMON);
//            params.put("typename", ExamCon.TYPE_STUDY_COMMON_NAME);
//        }
       return   getOrderDao() .insert(params);
    }
    public ResponseMsg getIndexInfo( Map params, Ztoken ztoken) throws IOException {

         params=new HashMap();
        params.put("page",1);
        params.put("limit",10);
        ResponseMsg data= getOrderDao().searchPage(params, BaseBean.class);
          Object    blogListObject= data.getData();
          Map returnOBject=new HashMap();
        returnOBject.put("blog",blogListObject);
//        returnOBject.put("study",blogListObject);
        returnOBject.put("edu",blogListObject);
        returnOBject.put("notice",blogListObject);

        ResponseMsg  indexMsg=new ResponseMsg();
        indexMsg.setSuccess(true);
        indexMsg.setData(returnOBject);
         //indexMsg.set

        return indexMsg;
    }
    public  ResponseMsg  search( Map params, Ztoken ztoken )throws Exception  {

        ResponseMsg data= getOrderDao().searchPage(params, BaseBean.class);
        return data;
    }
    public  ResponseMsg  get( Map params, Ztoken ztoken )throws Exception  {

        ResponseMsg data= getOrderDao().get((String) params.get("id"), BaseBean.class);
        return data;
    }




}
