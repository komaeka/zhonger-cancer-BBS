package zhonger.cancer.bbs.controller;

import org.python.antlr.ast.Str;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import zhonger.cancer.bbs.dto.CommentDTO;
import zhonger.cancer.bbs.dto.QuestionDTO;
import zhonger.cancer.bbs.enums.CommentTypeEnum;
import zhonger.cancer.bbs.model.User;
import zhonger.cancer.bbs.service.CommentService;
import zhonger.cancer.bbs.service.QuestionService;
import zhonger.cancer.bbs.service.RecommendationService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private RecommendationService recommendationService;
    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id")Long id, Model model,HttpServletRequest request){
        QuestionDTO questionDTO = questionService.getById(id);
        List<QuestionDTO> relatedQuestions = questionService.selectRelated(questionDTO);
        List<CommentDTO> comments = commentService.listByTargetId(id, CommentTypeEnum.QUESTION);
        questionService.inView(id);
        model.addAttribute("question",questionDTO);
        model.addAttribute("comments",comments);
        model.addAttribute("relatedQuestions",relatedQuestions);
        User user = (User) request.getSession().getAttribute("user");
        if (user!=null){
            String questionCharacteristicString = questionService.selectCharacteristicString(id);
            recommendationService.saveCharacteristic(user,questionCharacteristicString);
        }
        return "question";
    }
}
