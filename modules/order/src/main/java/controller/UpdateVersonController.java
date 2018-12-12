package controller;


import org.h2.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URLEncoder;

/**
 * 创建:林党宏
 * 日期: 2017/11/15 13:45
 * 注释：检测更新安装包
 *
 * **/

@Controller(value = "updateVersonController")
@RequestMapping(value = "/api/v1/updateVerson")
public class UpdateVersonController {

    @RequestMapping(value = "/down")
//    @ResponseBody
    public String download(@RequestParam("name") String value, HttpServletRequest  request) throws UnsupportedEncodingException {
        String  baseOutputFilePath=value;
        if (!StringUtils.isNullOrEmpty(value)){
            String[]   URLs =  value.split("/");
            String docName=URLs[URLs.length-1];

            docName= URLEncoder.encode(docName,"UTF-8");
            String newDocURL="";
            for (int i=1;i<URLs.length-1;i++){
                newDocURL=newDocURL+"/"+URLs[i];

            }
            newDocURL=newDocURL+"/"+docName;

            value= newDocURL;


            return "redirect:" + value;
//            return "redirect:" +"http://localhost:8090/MyServer"+ value;
        }

        return "error";
    }
}