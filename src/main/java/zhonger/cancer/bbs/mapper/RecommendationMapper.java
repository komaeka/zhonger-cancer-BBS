package zhonger.cancer.bbs.mapper;

import org.apache.ibatis.annotations.Mapper;
import zhonger.cancer.bbs.model.UserLike;

@Mapper
public interface RecommendationMapper {
    void addGalgame(UserLike userLike);
}
