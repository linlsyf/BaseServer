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

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        String str = providerService.SayHello("test");

//        Map responseData=new HashMap();

        params.put("result",str);
        return params;
    }
}