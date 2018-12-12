package shop.dao;

import com.alibaba.fastjson.JSON;

//import org.apache.ibatis.session.SqlSession;
import shop.dao.Mapper.ShopCartMapper;
import shop.dao.bean.ShopCart;
import spring.response.ResponseMsg;

import java.io.IOException;
import java.util.List;

/**
 *
 * Title: ShopCartDao
 *
 * @author chenxiaochan
 */
public class ShopCartDao {

//
    public static  String  add(ShopCart order) throws IOException {
        boolean flag=false;
//
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//        ShopCartMapper studentMapper = sqlSession.getMapper(ShopCartMapper.class);
//
////       String id= UUID.randomUUID().toString();
////       order.setId(id);
//        int count=studentMapper.add(order);
//        sqlSession.commit();
//        // 释放资源
//        sqlSession.close();
//        String msg="添加成功";
//          if (count>0){
//            flag=true;
//        }else{
//              msg="添加失败";
//          }
//        ResponseMsg responseMsg=new ResponseMsg();
//        responseMsg.setSuccess(flag);
//        responseMsg.setMsg(msg);
//        String result= JSON.toJSONString(responseMsg);
//
//        return  result;
        String result="";
        return  result;
    }
    public static  String  update(ShopCart order) throws IOException {
//        boolean flag=false;
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//        ShopCartMapper studentMapper = sqlSession.getMapper(ShopCartMapper.class);
//
//        int count=studentMapper.update(order);
//        sqlSession.commit();
//
//        // 释放资源
//        sqlSession.close();
//        if (count>0){
//            flag=true;
//        }
//
//        ResponseMsg responseMsg=new ResponseMsg();
//        responseMsg.setSuccess(flag);
//        String result=JSON.toJSONString(responseMsg);
//
//        return  result;
        String result="";
        return  result;
    }
    public static  String  remove(ShopCart order) throws IOException {
        boolean flag=false;
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//        ShopCartMapper studentMapper = sqlSession.getMapper(ShopCartMapper.class);
//
//        int count=studentMapper.delete(order.getId());
//        sqlSession.commit();
//
//        // 释放资源
//        sqlSession.close();
//        if (count>0){
//            flag=true;
//        }
//
//        ResponseMsg responseMsg=new ResponseMsg();
//        responseMsg.setSuccess(flag);
//        String result=JSON.toJSONString(responseMsg);
//        return  result;
        String result="";
        return  result;
    }
    public static  String  list() throws IOException {
        boolean flag=false;

//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//
//        ShopCartMapper studentMapper = sqlSession.getMapper(ShopCartMapper.class);
//        List<ShopCart> userList = studentMapper.findAllOrders();
//
//        // 释放资源
//        sqlSession.close();
//        flag=true;
//
//        ResponseMsg responseMsg=new ResponseMsg();
//        responseMsg.setSuccess(flag);
//        responseMsg.setData(userList);
//        String result=JSON.toJSONString(responseMsg);
//         return  result;
        String result="";
        return  result;
    }
    public static  String  listByStatus(int  status) throws IOException {
        boolean flag=false;
//
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//
//        ShopCartMapper studentMapper = sqlSession.getMapper(ShopCartMapper.class);
//        List<ShopCart> userList = studentMapper.listByStatus(status);
//
//        // 释放资源
//        sqlSession.close();
//        flag=true;
//
//        ResponseMsg responseMsg=new ResponseMsg();
//        responseMsg.setSuccess(flag);
//        responseMsg.setData(userList);
//        String result=JSON.toJSONString(responseMsg);
//         return  result;
        String result="";
        return  result;
    }
    public static  String  get(String id) throws IOException {
//        boolean flag=false;
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//
//        ShopCartMapper studentMapper = sqlSession.getMapper(ShopCartMapper.class);
//        ShopCart order = studentMapper.get(id);
//        // 释放资源
//        sqlSession.close();
//
////        String resultOrde=JSON.toJSONString(easy.order);
//        if (order!=null){
//            flag=true;
//
//        }
//
//        ResponseMsg responseMsg=new ResponseMsg();
//        responseMsg.setSuccess(flag);
//        if (order!=null){
//            responseMsg.setData(order);
//
//        }
//        String result=JSON.toJSONString(responseMsg);
        String result="";
        return  result;
    }
}