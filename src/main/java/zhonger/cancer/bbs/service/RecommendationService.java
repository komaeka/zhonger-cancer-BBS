package zhonger.cancer.bbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhonger.cancer.bbs.mapper.RecommendationMapper;
import zhonger.cancer.bbs.mapper.UserLikeMapper;
import zhonger.cancer.bbs.model.User;
import zhonger.cancer.bbs.model.UserLike;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationService {
    @Autowired
    private UserLikeMapper userLikeMapper;
    @Autowired
    private RecommendationMapper recommendationMapper;

    public List<Integer> userLikeList(User user) {
        List<Integer> userLikeList = new ArrayList<>();
        UserLike userLike = userLikeMapper.selectByPrimaryKey(user.getId());
        userLikeList.add(userLike.getGalgame());
        userLikeList.add(userLike.getAnimation());
        userLikeList.add(userLike.getFantasy());
        userLikeList.add(userLike.getImaginary());
        userLikeList.add(userLike.getBlood());
        userLikeList.add(userLike.getCute());
        userLikeList.add(userLike.getLachrymatory());
        userLikeList.add(userLike.getCampus());
        userLikeList.add(userLike.getCrossing());
        userLikeList.add(userLike.getComedy());
        userLikeList.add(userLike.getMatory());
        userLikeList.add(userLike.getBattle());
        userLikeList.add(userLike.getMagic());
        return userLikeList;
    }
    public double cosine_similarity(List<Integer> list1,List<Integer> list2) {
        double vector1All =0.00;//向量1分量平方和
        double vector1Modulo = 0.00;//向量1的模
        double vector2All = 0.00;//向量1分量平方和
        double vector2Modulo = 0.00;//向量2的模
        double vectorProduct = 0.00; //向量积
        double similarity = 0.00;
        //遍历数组
        for(int i = 0;i < list1.size(); i ++){
            //计算向量积
            vectorProduct += list1.get(i)*list2.get(i);
            //计算平方和
            vector1All += Math.pow(list1.get(i),2);
            vector2All += Math.pow(list2.get(i),2);
        }
        vector1Modulo = Math.sqrt(vector1All);
        vector2Modulo = Math.sqrt(vector2All);
        similarity = vectorProduct / (vector1Modulo*vector2Modulo);
//        System.out.println(similarity);
        return similarity;
    }

    public void saveCharacteristic(User user, String questionCharacteristicString) {
        UserLike userLike = new UserLike();
        userLike.setId(user.getId());
        if (questionCharacteristicString.contains("galgame")){
            System.out.println("galgame");
            recommendationMapper.addGalgame(userLike);
        }
        if (questionCharacteristicString.contains("动漫")){
            System.out.println("动漫");
        }
        if (questionCharacteristicString.contains("奇幻")){
            System.out.println("奇幻");
        }
        if (questionCharacteristicString.contains("架空")){
            System.out.println("架空");
        }
        if (questionCharacteristicString.contains("热血")){
            System.out.println("热血");
        }
        if (questionCharacteristicString.contains("萌系")){
            System.out.println("萌系");
        }
        if (questionCharacteristicString.contains("催泪")){
            System.out.println("催泪");
        }
        if (questionCharacteristicString.contains("穿越")){
            System.out.println("穿越");
        }
        if (questionCharacteristicString.contains("校园")){
            System.out.println("校园");
        }
        if (questionCharacteristicString.contains("搞笑")){
            System.out.println("搞笑");
        }
        if (questionCharacteristicString.contains("恋爱")){
            System.out.println("恋爱");
        }
        if (questionCharacteristicString.contains("战斗")){
            System.out.println("战斗");
        }
        if (questionCharacteristicString.contains("魔法")){
            System.out.println("魔法");
        }
    }
}
