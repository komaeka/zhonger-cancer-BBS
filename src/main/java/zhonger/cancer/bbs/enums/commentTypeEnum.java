package zhonger.cancer.bbs.enums;

public enum commentTypeEnum {
    QUESTION(1),
    COMMENT(2)
    ;
    private Integer type;
    public Integer getType() {
        return type;
    }
    commentTypeEnum(Integer type) {
        this.type = type;
    }
}
