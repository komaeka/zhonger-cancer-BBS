package zhonger.cancer.bbs.mapper;

import org.apache.ibatis.annotations.Mapper;
import zhonger.cancer.bbs.dto.LikeDTO;
import zhonger.cancer.bbs.model.Comment;
@Mapper
public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}