package dao;

import base.BaseDao;
import com.alibaba.fastjson.JSON;

import ds.JdbcTemplateEng;
import dao.Mapper.OrderMapper;
import dao.bean.ShopOrder;
import dao.bean.ShopRecorder;
import human.dao.bean.User;
//import org.apache.ibatis.session.SqlSession;
import service.OrderCon;
import spring.response.ResponseMsg;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *
 * Title: ShopCartDao
 *
 * @author chenxiaochan
 */
public class OrderDao extends BaseDao {


    public static  String  add() throws IOException {
//    public static  String  add(ShopOrder order) throws IOException {
        boolean flag=false;



        String courseFile =instance.getClass().getResource("").getPath() ;
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

        return  result;
    }
    public static  String  update(ShopOrder order) throws IOException {
//        boolean flag=false;
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//        OrderMapper studentMapper = sqlSession.getMapper(OrderMapper.class);
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

        String result="";
        return  result;
    }
    public static  String  remove(ShopOrder order) throws IOException {
//        boolean flag=false;
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//        OrderMapper studentMapper = sqlSession.getMapper(OrderMapper.class);
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
        String result="";
        return  result;
    }
    public static  List<ShopOrder>  list() throws IOException {
        boolean flag=false;


       String courseFile =instance.getClass().getResource("").getPath() ;
        courseFile=courseFile+"sql/"+ OrderCon.ORDER_BASE+"/list.sql";
        Map<String, Object> map = new HashMap<String, Object>();
        List<ShopOrder>  list=  JdbcTemplateEng.query(courseFile, ShopOrder.class,map);
         return  list;
    }
    public static  List<ShopRecorder>  listByStatus(int  status) throws IOException {
        boolean flag=false;

//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//
//        OrderMapper studentMapper = sqlSession.getMapper(OrderMapper.class);
//        List<ShopRecorder> userList = studentMapper.listByStatus(status);
//
//        // 释放资源
//        sqlSession.close();

         return  null;
    }

    public static  List<ShopRecorder>  getMyOrder( User user) throws IOException {
        boolean flag=false;
//       // String courseFile =OrderDao.instance.getClass().getResource("").getPath() ;
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//
//        OrderMapper studentMapper = sqlSession.getMapper(OrderMapper.class);
//        String id=user.getId();
//        List<ShopRecorder> orderList = studentMapper.getPayList(id);
////        List<ShopRecorder> userList =new ArrayList<ShopRecorder>();
//
//        // 释放资源
//        sqlSession.close();

         return  null;
    }
    public static  ShopOrder  get(String id) throws IOException {
        boolean flag=false;
//        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
//
//        OrderMapper studentMapper = sqlSession.getMapper(OrderMapper.class);
//        ShopOrder order = studentMapper.findOrderById(id);
//        // 释放资源
//        sqlSession.close();

//        String resultOrde=JSON.toJSONString(easy.order);
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

         return  null;
    }
}