package zhonger.cancer.bbs.mapper;

import org.apache.ibatis.annotations.Mapper;
import zhonger.cancer.bbs.model.UserLike;

@Mapper
public interface RecommendationMapper {
    void addGalgame(UserLike userLike);
    void addAnimation(UserLike userLike);
    void addFantasy(UserLike userLike);
    void addImaginary(UserLike userLike);
    void addBlood(UserLike userLike);
    void addCute(UserLike userLike);
    void addLachrymatory(UserLike userLike);
    void addCrossing(UserLike userLike);
    void addCampus(UserLike userLike);
    void addComedy(UserLike userLike);
    void addMatory(UserLike userLike);
    void addBattle(UserLike userLike);
    void addMagic(UserLike userLike);
}
