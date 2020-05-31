package controller;

import amazon.AmazonAccountService;
import amazon.AmazonService;
import amazon.AmazonViewCountUtils;
import amazon.RunJob;
import base.LogHelper;
import com.miracle.sys.app.utils.SysUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.MediaTypes;
import spring.response.MBYResponseViewModel;
import spring.response.MBYViewModel;

import java.util.Map;

@Controller(value = "amazonViewController")
@RequestMapping(value = "/amazon")
public class AmazonViewController {
//    ShopCartDao  dao=new ShopCartDao();

    AmazonService  service=new AmazonService();
    AmazonAccountService serviceAccount=new AmazonAccountService();
@RequestMapping(value="/screenclub")
public String screenclub() {
//    RunJob.getInStance();
//    AmazonViewCountUtils.todayNum=AmazonViewCountUtils.todayNum+1;

           service.saveCustonInfo();
    return "redirect:/amazon/screenclub.html";
}
    @RequestMapping(value="/accountclub")
    public String acountclub() {
//    RunJob.getInStance();
//    AmazonViewCountUtils.todayNum=AmazonViewCountUtils.todayNum+1;

        serviceAccount.saveCustonInfo();
        return "redirect:/amazon/accountclub.html";
    }



}