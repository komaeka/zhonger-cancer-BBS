package zhonger.cancer.bbs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import zhonger.cancer.bbs.mapper.QuestionMapper;
import zhonger.cancer.bbs.model.Question;

import java.util.List;

@SpringBootTest
class BbsApplicationTests {
    @Autowired
    private QuestionMapper questionMapper;

    @Test
    void contextLoads() {
        List<Question> questions = questionMapper.selectList(null);
        System.out.println(questions);
    }

}
