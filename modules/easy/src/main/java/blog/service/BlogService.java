package blog.service;

import applist.AppMsg;
import auth.User;
import base.BaseBean;
import blog.dao.BlogDao;
import com.alibaba.fastjson.JSON;
import com.mw.utils.DateUtils;
import com.sun.org.apache.bcel.internal.generic.I2F;
import config.LoginConfig;
import dict.dao.DictDao;
import dict.dao.bean.DictBean;
import dict.service.DictService;
import exam.dao.ExamCon;
import exam.dao.ExamDao;
import favour.dao.bean.FavourBean;
import org.hibernate.metamodel.source.binder.ManyToAnyPluralAttributeElementSource;
import org.springframework.stereotype.Service;
import service.TokenCache;
import service.Ztoken;
import spring.response.ResponseMsg;
import sun.security.krb5.internal.PAData;
import utils.TimeUtils;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BlogService {
    BlogDao orderDao;
    DictService dictService=new DictService();

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

    public ResponseMsg getIndexInfo( Map params, Ztoken ztoken) throws Exception {


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
        ResponseMsg dataeduMap= getOrderDao().searchPageByName(eduMap, BaseBean.class,"SearchIndex.sql");
        Object    eduListObject= dataeduMap.getData();

        returnOBject.put("edus",eduListObject);


        Map  eduTopMap=new HashMap();
        eduTopMap.put("typecode","type_index_study_top");
        eduTopMap.putAll(params);
        ResponseMsg dataeduTopMap= getOrderDao().searchPageByName(eduTopMap, BaseBean.class,"SearchIndex.sql");
        Object    eduTopListObject= dataeduTopMap.getData();
        returnOBject.put("studys",eduTopListObject);

        Map  eduNoticeMap=new HashMap();
        eduNoticeMap.put("typecode","type_index_study_notice");
        eduNoticeMap.putAll(params);
        ResponseMsg dataeduNoticeMap= getOrderDao().searchPageByName(eduNoticeMap, BaseBean.class,"SearchIndex.sql");
        Object    eduNoticeListObject= dataeduNoticeMap.getData();


        returnOBject.put("notices",eduNoticeListObject);

       // returnOBject.put("notice",blogListObject);
        int leaveal4time=0;
        int leaveal10time=0;
        String exam4time="";
        String exam10time="";
        Map searchDayMap=new HashMap();
        searchDayMap.put("type","zikaotime");
        ResponseMsg  dictMsg=  dictService.search(searchDayMap,ztoken);
        List<Object>  listDict=  (List<Object>) dictMsg.getData();
              if (null!=listDict&&listDict.size()>0) {
                  Date currentDate = new Date();

                  DictBean exam4 = new DictBean();
                  DictBean exam10 = new DictBean();
                  for (Object o : listDict) {
                      DictBean dictItem = (DictBean) o;
                      if (dictItem.getId().equals("selefexamtime10")) {
                          exam10 = dictItem;

                      }
                      if (dictItem.getId().equals("selefexamtime4")) {
                          exam4 = dictItem;

                      }
                  }
                //先判断是否已经超过10月份
                  String  time=TimeUtils.getCurrentYear()+"-"+ exam10.getContent()+" 00:00:00";
                  Date examTime= TimeUtils.parseTime(time);
                  if (null!=examTime&&currentDate.getTime()<examTime.getTime()){
                     // leaveal10time= TimeUtils. differentDaysByMillisecond(examTime,  currentDate);
                      time=TimeUtils.getCurrentYear()+"-"+ exam4.getContent()+" 00:00:00";
                      exam4time=TimeUtils.getCurrentYear()+"-"+ exam4.getContent();

                      examTime= TimeUtils.parseTime(time);
                      if (null!=examTime&&currentDate.getTime()<examTime.getTime()){
                          leaveal4time= TimeUtils. differentDaysByMillisecond( currentDate,examTime);
                      }

                      time=TimeUtils.getCurrentYear()+"-"+ exam10.getContent()+" 00:00:00";
                      exam10time=TimeUtils.getCurrentYear()+"-"+ exam10.getContent();

                      examTime= TimeUtils.parseTime(time);
                      if (null!=examTime&&currentDate.getTime()<examTime.getTime()){
                          leaveal10time= TimeUtils. differentDaysByMillisecond( currentDate,examTime);
                      }

                  }else  {
                      //超过10月份年度要加一
                      time=TimeUtils.getCurrentYear()+1+"-"+ exam4.getContent()+" 00:00:00";
                      exam4time=TimeUtils.getCurrentYear()+1+"-"+ exam4.getContent();

                      examTime= TimeUtils.parseTime(time);
                      if (null!=examTime){
                          leaveal4time= TimeUtils. differentDaysByMillisecond(  currentDate,examTime);
                      }

                        time=TimeUtils.getCurrentYear()+1+"-"+ exam10.getContent()+" 00:00:00";
                      exam10time=TimeUtils.getCurrentYear()+1+"-"+ exam10.getContent();

                      examTime= TimeUtils.parseTime(time);
                      if (null!=examTime){
                          leaveal10time= TimeUtils. differentDaysByMillisecond(  currentDate,examTime);
                      }
                  }

              }
        returnOBject.put("leaveal10time",leaveal10time);
        returnOBject.put("leaveal4time",leaveal4time);
        returnOBject.put("exam4time",exam4time);
        returnOBject.put("exam10time",exam10time);



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
