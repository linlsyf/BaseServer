package dao;

import com.alibaba.fastjson.JSON;
import ds.JdbcTemplateEng;
import org.junit.Test;
import service.OrderCon;
import spring.response.ResponseMsg;

import java.util.*;

public class TestDs {

    @Test
    public void test01() {
        boolean flag=false;
        String courseFile =this.getClass().getResource("").getPath() ;
        courseFile=courseFile+"sql/"+ OrderCon.ORDER_BASE+"/Create.sql";
        Map<String, Object> map = new HashMap<String, Object>();
        String id= UUID.randomUUID().toString();
//        List<Map>  dataList=new ArrayList<>();
//        Map  itemMap=new HashMap();
//        itemMap.put("goodsId","test1012");
//        itemMap.put("id",id);
//        dataList.add(itemMap);
//        map.put("data",dataList);

        map.put("id",id);
        map.put("goodsId","test1012");
        int count=  JdbcTemplateEng.create(courseFile, map);
        String msg="添加成功";
        if (count>0){
            flag=true;
        }else{
            msg="添加失败";
        }
        ResponseMsg responseMsg=new ResponseMsg();
        responseMsg.setSuccess(flag);
        responseMsg.setMsg(msg);
        String result= JSON.toJSONString(responseMsg);
    }
}
