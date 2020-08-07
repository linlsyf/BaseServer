package controller;

import amazon.AmazonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.MediaTypes;
import spring.response.MBYResponseViewModel;
import spring.response.MBYViewModel;

import java.util.Map;

@Controller(value = "amazonController")
@RequestMapping(value = "/api/v1/amazon")
public class AmazonController {
//    ShopCartDao  dao=new ShopCartDao();

    //@Autowired
    AmazonService amazonService =new AmazonService();

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

        return amazonService.list();

    }
    @RequestMapping(value = "/search", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel search(@RequestParam Map params ) throws Exception {

        return amazonService.search(params);

    }
    @RequestMapping(value = "/searchViewCount", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel searchViewCount(@RequestParam Map params ) throws Exception {

        return amazonService.searchViewCount(params);

    }
    @RequestMapping(value = "/getViewCountMsg", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel getViewCountMsg(@RequestParam Map params ) throws Exception {

        return amazonService.getViewCountMsg(params);

    }

}