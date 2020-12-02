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


          Map  blogMap=new HashMap();
          blogMap.put("typecode","type_index_newest");
          blogMap.putAll(params);
        ResponseMsg data= getOrderDao().searchPage(blogMap, BaseBean.class);
          Object    blogListObject= data.getData();
          Map returnOBject=new HashMap();
        returnOBject.put("blogs",blogListObject);
//        returnOBject.put("study",blogListObject);


        Map  eduMap=new HashMap();
        eduMap.put("typecode","type_index_study_rule");
        eduMap.putAll(params);
        ResponseMsg dataeduMap= getOrderDao().searchPage(eduMap, BaseBean.class);
        Object    eduListObject= dataeduMap.getData();

        returnOBject.put("edus",eduListObject);


        Map  eduTopMap=new HashMap();
        eduTopMap.put("typecode","type_index_study_top");
        eduTopMap.putAll(params);
        ResponseMsg dataeduTopMap= getOrderDao().searchPage(eduTopMap, BaseBean.class);
        Object    eduTopListObject= dataeduTopMap.getData();
        returnOBject.put("studys",eduTopListObject);

        Map  eduNoticeMap=new HashMap();
        eduNoticeMap.put("typecode","type_index_study_notice");
        eduNoticeMap.putAll(params);
        ResponseMsg dataeduNoticeMap= getOrderDao().searchPage(eduNoticeMap, BaseBean.class);
        Object    eduNoticeListObject= dataeduNoticeMap.getData();


        returnOBject.put("notices",eduNoticeListObject);

       // returnOBject.put("notice",blogListObject);

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
