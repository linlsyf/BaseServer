package provider.service;

import applist.service.AppListService;
import base.BaseBean;
import common.GroovyUtils;
import dict.dao.bean.DictBean;
import dict.service.DictService;
import groservice.dao.GroDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import service.Ztoken;
import spring.response.ResponseMsg;
import utils.TimeUtils;

import java.util.*;

/**
 * 文章管理服务
 */
@Service
public class DubboService {

    public  boolean     startProv( Map params, Ztoken ztoken )throws Exception  {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
        context.start();

        return true;
    }
    public  Object     getCustom( Map params, Ztoken ztoken )throws Exception  {

        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        ProviderService providerService = (ProviderService) context.getBean("providerService");
        Object data = providerService.getNewData(params);


//        Map responseData=new HashMap();

        return data;
    }
}