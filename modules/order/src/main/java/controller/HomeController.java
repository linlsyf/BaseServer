package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.OrderService;

@Controller(value = "homeController")

public class HomeController {
    @RequestMapping("home")
    public String home() throws Exception {
        return "home";
    }

}