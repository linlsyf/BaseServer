package controller;

import com.alibaba.fastjson.JSON;
import exam.service.ExamService;
import favour.dao.bean.FavourBean;
import favour.service.FavourService;
import human.dao.UserDao;
import human.dao.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.MediaTypes;
import service.Ztoken;
import spring.response.MBYResponseViewModel;
import spring.response.MBYViewModel;
import spring.response.ResponseMsg;
import utils.ZStringUtils;

import java.util.Map;

@Controller(value = "examController")
@RequestMapping(value = "/api/v1/exam")
public class ExamSelfStudyController {
    //@Autowired
    ExamService favourService =new ExamService();


    @RequestMapping(value = "/list", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel list( ) throws Exception {
        ResponseMsg reuslt= favourService.list();
//        List<FavourBean> result= adcarService.list();
//        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
        return  reuslt;
}
    @RequestMapping(value = "/search", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel search( @RequestParam Map params) throws Exception {



        ResponseMsg reuslt= favourService.search(params);
//        List<FavourBean> result= adcarService.list();
//        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
        return  reuslt;
}
    @RequestMapping(value = "/get" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel get(@RequestParam Map params) throws Exception  {
        String id=(String) params.get("id");

             return  favourService.get(id);

    }
    @RequestMapping(value = "/add" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel add(@RequestParam Map params, Ztoken ztoken) throws Exception  {
        if (!ZStringUtils.isNotEmpty(ztoken.getTicket())){
            MBYViewModel mbyViewModel=new MBYResponseViewModel("300","参数ticket缺失");
            return mbyViewModel;
        }
        ResponseMsg reuslt= favourService.add(params,  ztoken);

//        MBYViewModel mbyViewModel= MbyRespnseUtils.get( reuslt,reuslt.isSuccess());

        return reuslt;
    }

    @RequestMapping(value = "/update" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel update(@RequestParam Map params, Ztoken ztoken) throws Exception  {
        if (!ZStringUtils.isNotEmpty(ztoken.getTicket())){
            MBYViewModel mbyViewModel=new MBYResponseViewModel("300","参数ticket缺失");
            return mbyViewModel;
        }
        ResponseMsg reuslt= favourService.update(params,  ztoken);

        return reuslt;
    }
    @RequestMapping(value = "/delete" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel remove(@RequestParam  Map params) throws Exception  {

        String[] ids;
         String  id=(  String)params.get("ids");
            if(null==id){
            Map     dataMap=(Map) JSON.parseObject((String)params.get("msg"),Map.class);
            id=(String)dataMap.get("ids");
            }
           ids=new String[]{id};
          if (null==ids){

            return new MBYResponseViewModel("300","error");
          }

        String result= favourService.remove(ids);
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);

        return mbyViewModel;
    }

}