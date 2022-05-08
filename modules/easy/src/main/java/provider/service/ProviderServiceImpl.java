package provider.service;

import org.apache.commons.collections4.map.LinkedMap;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//provider 部署到另外一个tomcat
public class ProviderServiceImpl implements ProviderService {
    public String SayHello(String word) {
        return word;
    }

    @Override
    public Object getNewData(Map params) {
        if (params==null){
            params=new HashMap();
        }
        params.put("now",new Date());
        return params;
    }

    @Override
    public Object getLinkData(LinkedMap params) {
        return getNewData(params);
    }


}
