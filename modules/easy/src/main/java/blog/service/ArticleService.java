package blog.service;

import applist.service.AppListService;
import base.BaseBean;
import blog.dao.BlogDao;
import config.LoginConfig;
import dict.dao.bean.DictBean;
import dict.service.DictService;
import org.springframework.stereotype.Service;
import service.Ztoken;
import spring.response.ResponseMsg;
import utils.TimeUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文章管理服务
 */
@Service
public class ArticleService {
    BlogDao orderDao;
    DictService dictService=new DictService();
    AppListService appListService=new AppListService();

    public BlogDao getOrderDao() {
        if (orderDao==null){
            orderDao=new BlogDao();
            orderDao.instance=orderDao;
        }
        return orderDao;
    }


    /**
     * 更新文章
     */
    public ResponseMsg update( Map params, Ztoken ztoken) throws Exception  {
        ResponseMsg  responseMsg= LoginConfig.loginCheck(params,ztoken);
        if (null!=responseMsg){
            return responseMsg;
        }
        return  getOrderDao().update(params);
    }
    /**
     * 添加文章
     */
    public ResponseMsg add( Map params, Ztoken ztoken) throws Exception  {
        ResponseMsg  responseMsg= LoginConfig.loginCheck(params,ztoken);
        if (null!=responseMsg){
            return responseMsg;
        }
       return   getOrderDao() .insert(params);
    }

    public ResponseMsg getIndexInfo( Map params, Ztoken ztoken) throws Exception {

          Map  blogMap=new HashMap();
          blogMap.put("typecode","type_index_newest");
          blogMap.put("responseType","list");
          blogMap.putAll(params);
        ResponseMsg data= getOrderDao().searchPageByName(blogMap, BaseBean.class,"SearchIndex.sql");
          Object    blogListObject= data.getData();
          Map returnOBject=new HashMap();
        returnOBject.put("newest",blogListObject);
//        returnOBject.put("study",blogListObject);
        Map  eduMap=new HashMap();
        eduMap.put("typecode","type_index_defend_rule");
        eduMap.put("responseType","list");

        eduMap.putAll(params);
        ResponseMsg dataeduMap= getOrderDao().searchPageByName(eduMap, BaseBean.class,"SearchIndex.sql");
        Object    eduListObject= dataeduMap.getData();

        returnOBject.put("rule",eduListObject);

        Map  eduTopMap=new HashMap();
        eduTopMap.put("typecode","type_index_defend_experience");
        eduTopMap.put("responseType","list");

        eduTopMap.putAll(params);
        ResponseMsg dataeduTopMap= getOrderDao().searchPageByName(eduTopMap, BaseBean.class,"SearchIndex.sql");
        Object    eduTopListObject= dataeduTopMap.getData();
        returnOBject.put("experience",eduTopListObject);

        Map  eduNoticeMap=new HashMap();
        eduNoticeMap.put("typecode","type_index_defend_method");
        eduNoticeMap.put("responseType","list");

        eduNoticeMap.putAll(params);
        ResponseMsg dataeduNoticeMap= getOrderDao().searchPageByName(eduNoticeMap, BaseBean.class,"SearchIndex.sql");
        Object    eduNoticeListObject= dataeduNoticeMap.getData();


        returnOBject.put("method",eduNoticeListObject);

        Map urlMap=new HashMap();
        urlMap.put("type","study");
        urlMap.put("parent_id","selfstudy");

        ResponseMsg dataURLMap =appListService.Search(urlMap,ztoken);
        Object    urlList=dataURLMap.getData();
        returnOBject.put("urlList",urlList);

        ResponseMsg  indexMsg=new ResponseMsg();
        indexMsg.setSuccess(true);
        indexMsg.setData(returnOBject);
         //indexMsg.set

        return indexMsg;
    }
    public ResponseMsg getIndexInfoBAK( Map params, Ztoken ztoken) throws Exception {

          Map  blogMap=new HashMap();
          blogMap.put("typecode","type_index_newest");
          blogMap.put("responseType","list");
          blogMap.putAll(params);
        ResponseMsg data= getOrderDao().searchPageByName(blogMap, BaseBean.class,"SearchIndex.sql");
          Object    blogListObject= data.getData();
          Map returnOBject=new HashMap();
        returnOBject.put("blogs",blogListObject);
//        returnOBject.put("study",blogListObject);

        Map  eduMap=new HashMap();
        eduMap.put("typecode","type_index_study_rule");
        eduMap.put("responseType","list");

        eduMap.putAll(params);
        ResponseMsg dataeduMap= getOrderDao().searchPageByName(eduMap, BaseBean.class,"SearchIndex.sql");
        Object    eduListObject= dataeduMap.getData();

        returnOBject.put("edus",eduListObject);

        Map  eduTopMap=new HashMap();
        eduTopMap.put("typecode","type_index_study_top");
        eduTopMap.put("responseType","list");

        eduTopMap.putAll(params);
        ResponseMsg dataeduTopMap= getOrderDao().searchPageByName(eduTopMap, BaseBean.class,"SearchIndex.sql");
        Object    eduTopListObject= dataeduTopMap.getData();
        returnOBject.put("studys",eduTopListObject);

        Map  eduNoticeMap=new HashMap();
        eduNoticeMap.put("typecode","type_index_study_notice");
        eduNoticeMap.put("responseType","list");

        eduNoticeMap.putAll(params);
        ResponseMsg dataeduNoticeMap= getOrderDao().searchPageByName(eduNoticeMap, BaseBean.class,"SearchIndex.sql");
        Object    eduNoticeListObject= dataeduNoticeMap.getData();


        returnOBject.put("notices",eduNoticeListObject);

        Map urlMap=new HashMap();
        urlMap.put("type","study");
        urlMap.put("parent_id","selfstudy");

        ResponseMsg dataURLMap =appListService.Search(urlMap,ztoken);
        Object    urlList=dataURLMap.getData();
        returnOBject.put("urlList",urlList);

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
    /**
     * 搜索文章
     */
    public  ResponseMsg  search( Map params, Ztoken ztoken )throws Exception  {
        ResponseMsg  responseMsg= LoginConfig.loginCheck(params,ztoken);
        if (null!=responseMsg){
            return responseMsg;
        }
        ResponseMsg data= getOrderDao().searchPage(params, BaseBean.class);
        return data;
    }
    /**
     * 获取文章详情
     */
    public  ResponseMsg  get( Map params, Ztoken ztoken )throws Exception  {
        ResponseMsg  responseMsg= LoginConfig.loginCheck(params,ztoken);
        if (null!=responseMsg){
            return responseMsg;
        }
        ResponseMsg data= getOrderDao().get((String) params.get("id"), BaseBean.class);
        return data;
    }




}
