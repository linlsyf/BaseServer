package controller;

import amazon.AmazonService;
import base.LogHelper;
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
@RequestMapping(value="/screenclub")
public String screenclub() {


    return "redirect:/amazon/screenclub.html";
}
}