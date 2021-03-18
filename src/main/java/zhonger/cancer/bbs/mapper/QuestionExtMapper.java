package zhonger.cancer.bbs.mapper;

import org.apache.ibatis.annotations.Mapper;
import zhonger.cancer.bbs.model.Question;

@Mapper
public interface QuestionExtMapper {
    int incView(Question record);
    int incCommentCount(Question record);
}