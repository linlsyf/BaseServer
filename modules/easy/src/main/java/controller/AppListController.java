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
    @RequestMapping(value = "/searchCustom", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel searchCustom(@RequestParam Map params, Ztoken ztoken ) throws Exception {
        return service.searchCustom(params,ztoken);

    }


    @RequestMapping(value = "/deleteCustom" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel deleteCustom(@RequestParam  Map params) throws Exception  {

        String  id=(  String)params.get("id");
        if (null==id){
            return new MBYResponseViewModel("300","error");
        }

        return  service.deleteCustom(id);

    }

    @RequestMapping(value = "/searchAppInfo", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel searchAppInfo(@RequestParam Map params, Ztoken ztoken ) throws Exception {

        return service.searchAppInfo(params,ztoken);

    }
    @RequestMapping(value = "/searchAppChildInfo", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel searchAppChildInfo(@RequestParam Map params, Ztoken ztoken ) throws Exception {

        return service.searchAppChildInfo(params,ztoken);

    }
    @RequestMapping(value = "/add", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel add(@RequestParam Map params, Ztoken ztoken ) throws Exception {

        return service.add(params,ztoken);

    }
    @RequestMapping(value = "/get", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel get(@RequestParam Map params, Ztoken ztoken ) throws Exception {

        return service.add(params,ztoken);

    }

}