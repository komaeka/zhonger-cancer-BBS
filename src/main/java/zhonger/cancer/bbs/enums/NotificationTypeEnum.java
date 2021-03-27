package zhonger.cancer.bbs.enums;

public enum NotificationTypeEnum {
    REPLY_QUESTION(1,"回复了帖子"),
    REPLY_COMMENT(2,"回复了评论");
    ;
    private int type;
    private String name;
    NotificationTypeEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }
    public static String nameOfType(int type) {
        for (NotificationTypeEnum notificationTypeEnum : NotificationTypeEnum.values()){
            if (notificationTypeEnum.getType()==type){
                return notificationTypeEnum.getName();
            }
        }
        return "";
    }
}
