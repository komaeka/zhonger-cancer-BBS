package zhonger.cancer.bbs.exception;

import java.lang.reflect.Type;

public enum CustomizeErrorCode implements ICustomizeErrorCode{
    QUESTION_NOT_FOUND(2001,"你找的帖子不在了，要不换个试试？"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中任何贴子或评论进行回复"),
    NO_LOGIN(2003,"当前操作需要登录，请登录后重试"),
    SYS_ERROR(2004,"服务冒烟了，要不然你稍后再试试！！！"),
    Type_ERROR(2005,"评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006,"回复的评论不存在，要不换个试试？"),
    COMMENT_IS_EMPTY(2007,"输入内容不能为空！")
    ;
    @Override
    public String getMessage(){
        return message;
    }

    private Integer code;
    private String message;

    @Override
    public Integer getCode() {
        return this.code;
    }

    CustomizeErrorCode(Integer code, String message){
        this.message = message;
        this.code = code;
    }
}
