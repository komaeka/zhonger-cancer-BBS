package zhonger.cancer.bbs.controller;

import org.python.core.PyArray;
import org.python.core.PyFunction;
import org.python.util.PythonInterpreter;
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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
        PythonInterpreter interpreter = new PythonInterpreter();
//        if (user!=null){
//            System.out.println("有人");
//        }else {
//            System.out.println("无人");
//        }
//        interpreter.execfile("C:\\code\\recommendation\\test.py");
//        PyFunction test1 = interpreter.get("plus_test", PyFunction.class);
//        test1.__call__(new PyInteger(5),new PyInteger(8));





        interpreter.execfile("C:\\code\\recommendation\\recommendation.py");
        PyFunction test2 = interpreter.get("cosine_similarity", PyFunction.class);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list2.add(10);
        list2.add(20);
        test2.__call__(new PyArray((PyArray) list1),new PyArray((PyArray) list2));
        return "index";
    }
    @GetMapping("/index/{id}")
    public String edit(@PathVariable(name = "id")Long id){
        questionService.deleteQuestion(id);
        return "redirect:/";
    }
}
