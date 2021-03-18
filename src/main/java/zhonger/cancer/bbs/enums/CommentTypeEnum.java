package zhonger.cancer.bbs.enums;

import zhonger.cancer.bbs.model.Comment;

public enum CommentTypeEnum {
    QUESTION(1),
    COMMENT(2)
    ;
    private Integer type;

    public static boolean isExist(Integer type) {
        for (CommentTypeEnum commentTypeEnum :CommentTypeEnum.values()){
            if (commentTypeEnum.getType()==type){
                return true;
            }
        }
        return false;
    }

    public Integer getType() {
        return type;
    }
    CommentTypeEnum(Integer type) {
        this.type = type;
    }
}
