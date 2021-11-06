package video.service;

import applist.AppMsg;
import applist.service.AppListService;
import auth.User;
import base.BaseBean;
import base.BaseBussinessDao;
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
import org.springframework.stereotype.Service;
import service.TokenCache;
import service.Ztoken;
import spring.response.ResponseMsg;
import sun.security.krb5.internal.PAData;
import utils.TimeUtils;
import video.dao.VideoDao;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 视频管理服务类
 */
@Service
public class VideoService {
    VideoDao orderDao;
    DictService dictService=new DictService();
    AppListService appListService=new AppListService();
    /**
     * 获取数据库管理服务
     */
    public VideoDao getOrderDao() {
        if (orderDao==null){
            orderDao=new VideoDao();
            orderDao.instance=orderDao;
        }
        return orderDao;
    }
    /**
     * 更新
     */
    public ResponseMsg update( Map params, Ztoken ztoken) throws Exception  {
        ResponseMsg  responseMsg= LoginConfig.loginCheck(params,ztoken);
        if (null!=responseMsg){
            return responseMsg;
        }
        return  getOrderDao().update(params);
    }
    /**
     * 视频添加
     */
    public ResponseMsg add( Map params, Ztoken ztoken) throws Exception  {
//        ResponseMsg  responseMsg= LoginConfig.loginCheck(params,ztoken);
//        if (null!=responseMsg){
//            return responseMsg;
//        }

       return   getOrderDao() .insert(params);
    }
    /**
     * 视频搜索
     */
    public   List<Object>   search( Map params, Ztoken ztoken )throws Exception  {
       return getOrderDao().searchPage(params, BaseBean.class);
    }
    /**
     * 视频信息获取
     */
    public  ResponseMsg  get( Map params, Ztoken ztoken )throws Exception  {
        ResponseMsg data= getOrderDao().get((String) params.get("id"), BaseBean.class);
        return data;
    }

}
