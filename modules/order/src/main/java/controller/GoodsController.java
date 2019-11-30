package controller;

import com.alibaba.fastjson.JSON;

import dao.GoodsDao;
import dao.OrderDao;
import dao.bean.Goods;
import dao.bean.ShopOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.MediaTypes;
import service.GoodsService;
import spring.response.MBYResponseViewModel;
import spring.response.MBYViewModel;
import spring.response.MbyRespnseUtils;

import java.util.*;

@Controller(value = "goodsController")
@RequestMapping(value = "/api/v1/goods")
public class GoodsController {
//    ShopCartDao  dao=new ShopCartDao();

//    @Autowired
 GoodsService orderService=new GoodsService();

    @RequestMapping(value = "/list", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel list( ) throws Exception {

        String result=orderService.list();
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
        return mbyViewModel;
}
    @RequestMapping(value = "/getOrderedList", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel getOrderedList( ) throws Exception {

        String result=orderService.getOrderedList();
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
        return mbyViewModel;
}
    @RequestMapping(value = "/get" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel get(@RequestParam("msg") String  msg ) throws Exception {

        Goods order=  JSON.parseObject(msg, Goods.class);
        Goods goods  = orderService.get(order.getId());

        return  MbyRespnseUtils.get(goods);
    }
    @RequestMapping(value = "/add" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel add(@RequestParam("msg") String  msg) throws Exception  {

        String reuslt=orderService.add(msg);
//        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",reuslt);

        return MbyRespnseUtils.get(reuslt);
    }
    @RequestMapping(value = "/update" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public String update(@RequestParam("msg") String  msg) throws Exception  {
        ShopOrder order=  JSON.parseObject(msg, ShopOrder.class);
        String result=OrderDao.update(order);

        return result;
    }
    @RequestMapping(value = "/remove" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel remove(@RequestParam Map params) throws Exception  {
        String msg=(String) params.get("msg");

        ShopOrder order=  JSON.parseObject(msg, ShopOrder.class);
        String result= OrderDao.remove(order);
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);

        return mbyViewModel;
    }
    @RequestMapping(value = "/search" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel search (@RequestParam Map params) throws Exception  {
          String msg=(String) params.get("msg");
        List<Goods> goodsList= GoodsDao.search(msg);
//        List<Goods> goodsList= GoodsDao.search(order.getName());

        return MbyRespnseUtils.get(goodsList);
    }
}