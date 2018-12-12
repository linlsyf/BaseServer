package human.service;

import com.alibaba.fastjson.JSON;

import human.dao.RoleUserDao;
import human.dao.bean.RoleUser;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RoleUserService {

    public String add( String  msg) throws Exception  {
        RoleUser order=  JSON.parseObject(msg, RoleUser.class);


        return order.getId();
    }

    public  String list()throws Exception  {
       String data= RoleUserDao.list();
        return data;
    }
    public RoleUser get(String id) throws IOException {
        RoleUserDao  dao=new RoleUserDao();

        return  dao.get(id);
    }


}
