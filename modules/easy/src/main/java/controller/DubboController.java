package controller;

import groservice.service.GroService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.MediaTypes;
import provider.service.DubboService;
import service.Ztoken;
import spring.response.MBYViewModel;
import spring.response.ResponseMsg;
import spring.response.ResultRespnseUtils;

import java.util.List;
import java.util.Map;

@Controller(value = "dubboController")
@RequestMapping(value = "/api/v1/dubbo")
public class DubboController {
//    ShopCartDao  dao=new ShopCartDao();

    //@Autowired
    DubboService dictService =new DubboService();

    @RequestMapping(value = "/startpro", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel exe(@RequestParam Map params, Ztoken ztoken ) throws Exception {

        Object result= dictService.startProv(params,ztoken);
        return ResultRespnseUtils.getResponseMsg(null,result);

    }
    @RequestMapping(value = "/subdata", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel subDaa(@RequestParam Map params, Ztoken ztoken ) throws Exception {

        Object result= dictService.getCustom(params,ztoken);
        return ResultRespnseUtils.getResponseMsg(null,result);

    }

}