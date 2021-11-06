package human.service;

import com.alibaba.fastjson.JSON;

import human.dao.RoleDao;
import human.dao.UserDao;
import human.dao.bean.Role;
import org.springframework.stereotype.Service;
import service.Ztoken;
import spring.response.ResponseMsg;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class RoleService {
    static RoleDao mDao;

    public static RoleDao getDao() {
        if (mDao==null){
            mDao=new RoleDao();
            mDao.instance=mDao;
        }
        return mDao;
    }
    public ResponseMsg add(Map params) throws Exception  {

        return  getDao().insertByName(params,"Create.sql");

    }
    public List<Object> search(Map params, Ztoken ztoken)throws Exception  {

//        if (!TokenCache.containToken(ztoken.getTicket())&&!ztoken.getTicket().equals(LoginConfig.loginTemp)){
//            ResponseMsg data=new ResponseMsg();
//            data.setSuccess(false);
//            data.setCode(300+"");
//            data.setMsg("请先登录");
//            return data;
//        }

      return getDao().searchByName(params,Role.class,"SearchRole.sql");
    }

//    public  String list()throws Exception  {
//       String data= RoleDao.list();
//        return data;
//    }
//    public Role get(String id) throws IOException {
//        RoleDao  dao=new RoleDao();
//
//        return  dao.get(id);
//    }


}
