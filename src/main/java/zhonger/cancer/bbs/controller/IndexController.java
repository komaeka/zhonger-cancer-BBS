package zhonger.cancer.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import zhonger.cancer.bbs.dto.PaginationDTO;
import zhonger.cancer.bbs.dto.QuestionCharacteristicDTO;
import zhonger.cancer.bbs.dto.QuestionDTO;
import zhonger.cancer.bbs.model.Question;
import zhonger.cancer.bbs.model.User;
import zhonger.cancer.bbs.service.QuestionService;
import zhonger.cancer.bbs.service.RecommendationService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private RecommendationService recommendationService;
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
            List<Integer> userLikeList = recommendationService.userLikeList(user);
            List<QuestionCharacteristicDTO> questionCharacteristicDTOList = new ArrayList<>();
            List<Question> questionList = questionService.selectAllQuestion();
            for (Question question:questionList){
                QuestionCharacteristicDTO questionCharacteristicDTO = new QuestionCharacteristicDTO();
                questionCharacteristicDTO.setQuestionID(question.getId());
                questionCharacteristicDTO.setQuestionCharacteristic(recommendationService.StringToList(question.getTag()));
                questionCharacteristicDTO.setSimilarity(recommendationService.cosine_similarity(userLikeList,questionCharacteristicDTO.getQuestionCharacteristic()));
                questionCharacteristicDTOList.add(questionCharacteristicDTO);
            }
            //按照余弦相似度从大到小排序
            questionCharacteristicDTOList.sort((x, y) -> Long.compare(Math.round(x.getSimilarity()), Math.round(y.getSimilarity())));
            Collections.reverse(questionCharacteristicDTOList);
//            for (QuestionCharacteristicDTO questionCharacteristicDTO: questionCharacteristicDTOList){
//                System.out.println(questionCharacteristicDTO.getQuestionID());
//                System.out.println(questionCharacteristicDTO.getQuestionCharacteristic());
//                System.out.println(questionCharacteristicDTO.getSimilarity());
//            }
            //组装推荐帖子
            List<QuestionDTO> recommendationQuestions = recommendationService.assembleRecommendationQuestions(questionCharacteristicDTOList);
            model.addAttribute("recommendationQuestions",recommendationQuestions);
        }
        return "index";
    }
    @GetMapping("/index/{id}")
    public String edit(@PathVariable(name = "id")Long id){
        questionService.deleteQuestion(id);
        return "redirect:/";
    }
}