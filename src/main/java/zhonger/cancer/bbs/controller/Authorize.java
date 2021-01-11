package zhonger.cancer.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Authorize {
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,@RequestParam(name = "state")String state){
        return "index";
    }
}
