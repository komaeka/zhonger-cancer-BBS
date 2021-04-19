package zhonger.cancer.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import zhonger.cancer.bbs.dto.PaginationDTO;
import zhonger.cancer.bbs.model.User;
import zhonger.cancer.bbs.service.QuestionService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "page",defaultValue = "1")Integer page,
                        @RequestParam(name = "size",defaultValue = "5")Integer size,
                        @RequestParam(name = "search",required = false)String search,
                        HttpServletRequest request) {
        PaginationDTO pagination = questionService.list(search,page,size);
        model.addAttribute("pagination",pagination);
        model.addAttribute("search",search);

//        个性化推荐模块
        User user = (User) request.getSession().getAttribute("user");
        if (user!=null){
            System.out.println("有人");
        }else {
            System.out.println("无人");
        }
        return "index";
    }
    @GetMapping("/index/{id}")
    public String edit(@PathVariable(name = "id")Long id){
        questionService.deleteQuestion(id);
        return "redirect:/";
    }
}
