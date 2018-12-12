package shop.controller;

import com.alibaba.fastjson.JSON;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.MediaTypes;
import shop.dao.ShopCartDao;
import shop.dao.bean.ShopCart;
import shop.service.ShopCartService;
import spring.response.MBYResponseViewModel;
import spring.response.MBYViewModel;

import java.util.Map;

@Controller(value = "shopCartController")
@RequestMapping(value = "/api/v1/shopCart")
public class ShopCartController {
//    ShopCartDao  dao=new ShopCartDao();

//    @Autowired
    ShopCartService orderService=new ShopCartService();

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
    @RequestMapping(value = "/get")
    @ResponseBody
    public MBYViewModel get(@RequestParam Map params) throws Exception  {
        String msg=(String) params.get("msg");
        ShopCart order=  JSON.parseObject(msg, ShopCart.class);
        String result  = orderService.get(order.getId());
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
        return mbyViewModel;
    }
    @RequestMapping(value = "/add")
    @ResponseBody
    public MBYViewModel add(@RequestParam Map params) throws Exception  {
        String msg=(String) params.get("msg");

        String reuslt=orderService.add(msg);
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",reuslt);

        return mbyViewModel;
    }
    @RequestMapping(value = "/update")
    @ResponseBody
    public String update(@RequestParam Map params) throws Exception  {
        String msg=(String) params.get("msg");
        ShopCart order=  JSON.parseObject(msg, ShopCart.class);
        String result= ShopCartDao.update(order);

        return result;
    }
    @RequestMapping(value = "/remove")
    @ResponseBody
    public MBYViewModel remove(@RequestParam Map params) throws Exception  {
        String msg=(String) params.get("msg");
        ShopCart order=  JSON.parseObject(msg, ShopCart.class);
        String result= ShopCartDao.remove(order);
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);

        return mbyViewModel;
    }
    @RequestMapping(value = "/pay")
    @ResponseBody
    public MBYViewModel pay(@RequestParam Map params) throws Exception  {
        String msg=(String) params.get("msg");
        ShopCart order=  JSON.parseObject(msg, ShopCart.class);
        String result= ShopCartDao.remove(order);
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);

        return mbyViewModel;
    }

}