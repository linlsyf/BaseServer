package controller;

import com.alibaba.fastjson.JSON;
import exam.service.ExamService;
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
    ExamService examService =new ExamService();

    @RequestMapping(value = "/list", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel list( ) throws Exception {
        ResponseMsg reuslt= examService.list();
        return  reuslt;
}
    @RequestMapping(value = "/search", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel search( @RequestParam Map params) throws Exception {

        return  examService.search(params);
     }
    @RequestMapping(value = "/typeList", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel typeList( @RequestParam Map params) throws Exception {

        return  examService.typeList(params);
     }
    @RequestMapping(value = "/radomExam", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel radomExam( @RequestParam Map params) throws Exception {


         String  type=(String) params.get("type");
        if (null!=type&&!ZStringUtils.isNotEmpty(type)){
            MBYViewModel mbyViewModel=new MBYResponseViewModel("300","type 参数缺失");
            return mbyViewModel;
        }


        return  examService.radomExam(params);
     }
    @RequestMapping(value = "/get" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel get(@RequestParam Map params) throws Exception  {
        String id=(String) params.get("id");

             return  examService.get(id);

    }
    @RequestMapping(value = "/add" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel add(@RequestParam Map params, Ztoken ztoken) throws Exception  {
        if (!ZStringUtils.isNotEmpty(ztoken.getTicket())){
            MBYViewModel mbyViewModel=new MBYResponseViewModel("300","参数ticket缺失");
            return mbyViewModel;
        }

        if (!params.containsKey("type")||!params.containsKey("typename")){
            MBYViewModel mbyViewModel=new MBYResponseViewModel("300","参数type   typename 缺失");
            return mbyViewModel;
        }
        ResponseMsg reuslt= examService.add(params,  ztoken);

//        MBYViewModel mbyViewModel= MbyRespnseUtils.get( reuslt,reuslt.isSuccess());

        return reuslt;
    }
    @RequestMapping(value = "/updateUserExam" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel updateUserExam(@RequestParam Map params, Ztoken ztoken) throws Exception  {
        if (!ZStringUtils.isNotEmpty(ztoken.getTicket())){
            MBYViewModel mbyViewModel=new MBYResponseViewModel("300","参数ticket缺失");
            return mbyViewModel;
        }

        if (!params.containsKey("examid")||!params.containsKey("userid")){
            MBYViewModel mbyViewModel=new MBYResponseViewModel("300","参数examid,userid 缺失");
            return mbyViewModel;
        }
        ResponseMsg reuslt= examService.updateUserExam(params,  ztoken);

//        MBYViewModel mbyViewModel= MbyRespnseUtils.get( reuslt,reuslt.isSuccess());

        return reuslt;
    }
//    @RequestMapping(value = "/updateUserExamEnglish" ,produces = MediaTypes.JSON_UTF_8)
//    @ResponseBody
//    public MBYViewModel updateUserExamEnglish(@RequestParam Map params, Ztoken ztoken) throws Exception  {
//        if (!ZStringUtils.isNotEmpty(ztoken.getTicket())){
//            MBYViewModel mbyViewModel=new MBYResponseViewModel("300","参数ticket缺失");
//            return mbyViewModel;
//        }
//
//        if (!params.containsKey("examid")||!params.containsKey("userid")){
//            MBYViewModel mbyViewModel=new MBYResponseViewModel("300","参数examid,userid 缺失");
//            return mbyViewModel;
//        }
//        ResponseMsg reuslt= examService.updateUserExamEnglish(params,  ztoken);
//
////        MBYViewModel mbyViewModel= MbyRespnseUtils.get( reuslt,reuslt.isSuccess());
//
//        return reuslt;
//    }
    @RequestMapping(value = "/searchEnglish", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel searchEnglish(@RequestParam Map params, Ztoken ztoken ) throws Exception {

        return examService.searchEnglish(params,ztoken);

    }
    @RequestMapping(value = "/searchEnglishSecond", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel searchEnglishSecond(@RequestParam Map params, Ztoken ztoken ) throws Exception {

        return examService.searchEnglishSecond(params,ztoken);

    }
    @RequestMapping(value = "/update" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel update(@RequestParam Map params, Ztoken ztoken) throws Exception  {
        if (!ZStringUtils.isNotEmpty(ztoken.getTicket())){
            MBYViewModel mbyViewModel=new MBYResponseViewModel("300","参数ticket缺失");
            return mbyViewModel;
        }
        ResponseMsg reuslt= examService.update(params,  ztoken);

        return reuslt;
    }
    @RequestMapping(value = "/delete" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel remove(@RequestParam  Map params, Ztoken ztoken) throws Exception  {

        if (!ZStringUtils.isNotEmpty(ztoken.getTicket())){
            MBYViewModel mbyViewModel=new MBYResponseViewModel("300","参数ticket缺失");
            return mbyViewModel;
        }
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

        String result= examService.remove(ids);
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);

        return mbyViewModel;
    }

}