package controller;

import amazon.AmazonAccountService;
import amazon.AmazonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.MediaTypes;
import spring.response.MBYResponseViewModel;
import spring.response.MBYViewModel;
import spring.response.ResultRespnseUtils;

import java.util.Map;

@Controller(value = "amazonAccountController")
@RequestMapping(value = "/api/v1/amazonAccount")
public class AmazonAccountController {
//    ShopCartDao  dao=new ShopCartDao();

    //@Autowired
    AmazonAccountService amazonService =new AmazonAccountService();

        @RequestMapping(value = "/add" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel add(@RequestParam Map params) throws Exception  {
        String msg=(String) params.get("msg");

        String reuslt= amazonService.add(msg);
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",reuslt);

        return mbyViewModel;
    }



    @RequestMapping(value = "/list", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel list( ) throws Exception {

        Object result= amazonService.list();
        return ResultRespnseUtils.getResponseMsg(null,result);

    }
    @RequestMapping(value = "/search", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel search(@RequestParam Map params ) throws Exception {

        Object result= amazonService.list();
        return ResultRespnseUtils.getResponseMsg(null,result);

    }
    @RequestMapping(value = "/searchViewCount", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel searchViewCount(@RequestParam Map params ) throws Exception {

        Object result= amazonService.searchViewCount(params);
        return ResultRespnseUtils.getResponseMsg(null,result);


    }
    @RequestMapping(value = "/getViewCountMsg", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel getViewCountMsg(@RequestParam Map params ) throws Exception {

        Object result= amazonService.getViewCountMsg(params);
        return ResultRespnseUtils.getResponseMsg(null,result);


    }

}