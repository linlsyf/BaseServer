package controller;

import applist.service.AppListService;
import auth.User;
import com.alibaba.fastjson.JSON;
import human.dao.UserDao;
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

@Controller(value = "applistController")
@RequestMapping(value = "/api/v1/applist")
public class AppListController {
//    ShopCartDao  dao=new ShopCartDao();
    AppListService  service=new AppListService();
    @RequestMapping(value = "/search", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel search(@RequestParam Map params, Ztoken ztoken ) throws Exception {

        return service.Search(params,ztoken);

    }
//    @RequestMapping(value = "/searchRole", produces = MediaTypes.JSON_UTF_8)
//    @ResponseBody
//    public MBYViewModel searchRole(@RequestParam Map params, Ztoken ztoken ) throws Exception {
//
//        return userService.SearchRole(params,ztoken);
//
//    }

}