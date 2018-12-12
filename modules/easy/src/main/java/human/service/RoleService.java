package human.service;

import com.alibaba.fastjson.JSON;

import human.dao.RoleDao;
import human.dao.bean.Role;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RoleService {

    public String add( String  msg) throws Exception  {
        Role order=  JSON.parseObject(msg, Role.class);


        return order.getId();
    }

    public  String list()throws Exception  {
       String data= RoleDao.list();
        return data;
    }
    public Role get(String id) throws IOException {
        RoleDao  dao=new RoleDao();

        return  dao.get(id);
    }


}
