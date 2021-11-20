package controller;

import accountbook.service.AccountBookService;
import dict.service.DictService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.MediaTypes;
import service.Ztoken;
import spring.response.MBYViewModel;
import spring.response.ResponseMsg;
import spring.response.ResultRespnseUtils;

import java.util.Map;

@Controller(value = "accountbookController")
@RequestMapping(value = "/api/v1/accountbook")
public class AccountBookController {
//    ShopCartDao  dao=new ShopCartDao();

    //@Autowired
    AccountBookService dictService =new AccountBookService();

    @RequestMapping(value = "/search", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel search(@RequestParam Map params, Ztoken ztoken ) throws Exception {

        Object result= dictService.search(params,ztoken);
        return ResultRespnseUtils.getResponseMsg(null,result);
    }
    @RequestMapping(value = "/get", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel get(@RequestParam Map params, Ztoken ztoken ) throws Exception {

        return dictService.get(params,ztoken);

    }
    @RequestMapping(value = "/searchEnglish", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel searchEnglish(@RequestParam Map params, Ztoken ztoken ) throws Exception {

        Object result= dictService.searchEnglish(params,ztoken);
        return ResultRespnseUtils.getResponseMsg(null,result);
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
    @RequestMapping(value = "/audio" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel audio(@RequestParam Map params, Ztoken ztoken) throws Exception  {

        ResponseMsg reuslt= dictService.audio(params,ztoken);
        return reuslt;
    }
//    @RequestMapping(value = "/getAudio" ,produces = MediaTypes.JSON_UTF_8)
//    @ResponseBody
//    public MBYViewModel getAudio(@RequestParam Map params, Ztoken ztoken,HttpServletRequest request, HttpServletResponse response) throws Exception  {
////        HttpServletRequest request,HttpServletResponse response
//        ResponseMsg reuslt= dictService.getAudio(params,ztoken);
//       String path= (String)reuslt.getData();
//
//        return reuslt;
//    }

}