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
    public static double cosine_similarity(List<Integer> list1,List<Integer> list2) {
        double vector1All =0.00;//向量1分量平方和
        double vector1Modulo = 0.00;//向量1的模
        double vector2All = 0.00;//向量1分量平方和
        double vector2Modulo = 0.00;//向量2的模
        double vectorProduct = 0.00; //向量积
        double similarity = 0.00;
        //遍历数组
        for(int i = 0;i < list1.size(); i ++){
            //计算向量积
            vectorProduct += list1.get(i)*list2.get(i);
            //计算平方和
            vector1All += Math.pow(list1.get(i),2);
            vector2All += Math.pow(list2.get(i),2);
        }
        vector1Modulo = Math.sqrt(vector1All);
        vector2Modulo = Math.sqrt(vector2All);
        similarity = vectorProduct / (vector1Modulo*vector2Modulo);
//        System.out.println(similarity);
        return similarity;
    }
}
