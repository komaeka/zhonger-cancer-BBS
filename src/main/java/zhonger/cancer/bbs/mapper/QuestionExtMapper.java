package zhonger.cancer.bbs.mapper;

import org.apache.ibatis.annotations.Mapper;
import zhonger.cancer.bbs.dto.QuestionQueryDTO;
import zhonger.cancer.bbs.model.Question;

import java.util.List;

@Mapper
public interface QuestionExtMapper {
    int incView(Question record);
    int incCommentCount(Question record);
    List<Question> selectRelated(Question question);
    Integer countBySearch(QuestionQueryDTO questionQueryDTO);

    List<Question> selectBySearch(QuestionQueryDTO questionQueryDTO);
}