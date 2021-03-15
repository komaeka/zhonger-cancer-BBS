package zhonger.cancer.bbs.service;

import org.springframework.stereotype.Service;
import zhonger.cancer.bbs.exception.CustomizeErrorCode;
import zhonger.cancer.bbs.exception.CustomizeException;
import zhonger.cancer.bbs.model.Comment;

@Service
public class CommentService {
    public void insert(Comment comment) {
        if (comment.getParentId()==null ||comment.getParentId()==0){
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
    }
}
