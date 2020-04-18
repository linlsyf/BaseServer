package controller;

import com.alibaba.fastjson.JSON;
import dict.service.DictService;
import human.dao.UserDao;
import auth.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.MediaTypes;
import service.Ztoken;
import spring.response.MBYResponseViewModel;
import spring.response.MBYViewModel;
import spring.response.ResponseMsg;

import java.util.Map;

@Controller(value = "dictController")
@RequestMapping(value = "/api/v1/dict")
public class DictController {
//    ShopCartDao  dao=new ShopCartDao();

    //@Autowired
    DictService dictService =new DictService();

    @RequestMapping(value = "/search", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel search(@RequestParam Map params, Ztoken ztoken ) throws Exception {

        return dictService.search(params,ztoken);

    }
    @RequestMapping(value = "/add" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel add(@RequestParam Map params ,Ztoken ztoken) throws Exception  {
        return  dictService.add(params,ztoken);
    }

    @RequestMapping(value = "/update" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel update(@RequestParam Map params, Ztoken ztoken) throws Exception  {

        ResponseMsg reuslt= dictService.update(params,ztoken);
        return reuslt;
    }

}