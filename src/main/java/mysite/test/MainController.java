package mysite.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @RequestMapping("/exam")
    @ResponseBody
    public String index(){
        return "index";
    }

    @RequestMapping("/")
    public String root() {
        return "redirect:/question/list";
    }
}