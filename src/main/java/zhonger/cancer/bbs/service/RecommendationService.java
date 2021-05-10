package zhonger.cancer.bbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhonger.cancer.bbs.dto.QuestionCharacteristicDTO;
import zhonger.cancer.bbs.dto.QuestionDTO;
import zhonger.cancer.bbs.mapper.RecommendationMapper;
import zhonger.cancer.bbs.mapper.UserLikeMapper;
import zhonger.cancer.bbs.model.User;
import zhonger.cancer.bbs.model.UserLike;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationService {
    @Autowired
    private UserLikeMapper userLikeMapper;
    @Autowired
    private RecommendationMapper recommendationMapper;
    @Autowired
    private QuestionService questionService;

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
        userLikeList.add(userLike.getCrossing());
        userLikeList.add(userLike.getCampus());
        userLikeList.add(userLike.getComedy());
        userLikeList.add(userLike.getMatory());
        userLikeList.add(userLike.getBattle());
        userLikeList.add(userLike.getMagic());
        return userLikeList;
    }
    public BigDecimal cosine_similarity(List<Integer> list1, List<Integer> list2) {
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
        BigDecimal similarity_result = new BigDecimal(similarity);
        return similarity_result;
    }

    public void saveCharacteristic(User user, String questionCharacteristicString) {
        UserLike userLike = new UserLike();
        userLike.setId(user.getId());
        if (questionCharacteristicString.contains("galgame")){
            recommendationMapper.addGalgame(userLike);
        }
        if (questionCharacteristicString.contains("动漫")){
            recommendationMapper.addAnimation(userLike);
        }
        if (questionCharacteristicString.contains("奇幻")){
            recommendationMapper.addFantasy(userLike);
        }
        if (questionCharacteristicString.contains("架空")){
            recommendationMapper.addImaginary(userLike);
        }
        if (questionCharacteristicString.contains("热血")){
            recommendationMapper.addBlood(userLike);
        }
        if (questionCharacteristicString.contains("萌系")){
            recommendationMapper.addCute(userLike);
        }
        if (questionCharacteristicString.contains("催泪")){
            recommendationMapper.addLachrymatory(userLike);
        }
        if (questionCharacteristicString.contains("穿越")){
            recommendationMapper.addCrossing(userLike);
        }
        if (questionCharacteristicString.contains("校园")){
            recommendationMapper.addCampus(userLike);
        }
        if (questionCharacteristicString.contains("搞笑")){
            recommendationMapper.addComedy(userLike);
        }
        if (questionCharacteristicString.contains("恋爱")){
            recommendationMapper.addMatory(userLike);
        }
        if (questionCharacteristicString.contains("战斗")){
            recommendationMapper.addBattle(userLike);
        }
        if (questionCharacteristicString.contains("魔法")){
            recommendationMapper.addMagic(userLike);
        }
    }

    public List<Integer> StringToList(String tag) {
        List<Integer> questionCharacteristic = new ArrayList<>();
        if (tag.contains("galgame")){
            questionCharacteristic.add(0,1);
        }else
            questionCharacteristic.add(0,0);
        if (tag.contains("动漫")){
            questionCharacteristic.add(1,1);
        }else {
            questionCharacteristic.add(1,0);
        }
        if(tag.contains("奇幻")){
            questionCharacteristic.add(2,1);
        }else {
            questionCharacteristic.add(2,0);
        }
        if (tag.contains("架空")){
            questionCharacteristic.add(3,1);
        }else {
            questionCharacteristic.add(3,0);
        }
        if (tag.contains("热血")){
            questionCharacteristic.add(4,1);
        }else {
            questionCharacteristic.add(4,0);
        }
        if (tag.contains("萌系")){
            questionCharacteristic.add(5,1);
        }else {
            questionCharacteristic.add(5,0);
        }
        if (tag.contains("催泪")){
            questionCharacteristic.add(6,1);
        }else {
            questionCharacteristic.add(6,0);
        }
        if (tag.contains("穿越")){
            questionCharacteristic.add(7,1);
        }else {
            questionCharacteristic.add(7,0);
        }
        if (tag.contains("校园")){
            questionCharacteristic.add(8,1);
        }else {
            questionCharacteristic.add(8,0);
        }
        if (tag.contains("搞笑")){
            questionCharacteristic.add(9,1);
        }else {
            questionCharacteristic.add(9,0);
        }
        if (tag.contains("恋爱")){
            questionCharacteristic.add(10,1);
        }else {
            questionCharacteristic.add(10,0);
        }
        if (tag.contains("战斗")){
            questionCharacteristic.add(11,1);
        }else {
            questionCharacteristic.add(11,0);
        }
        if (tag.contains("魔法")){
            questionCharacteristic.add(12,1);
        }else {
            questionCharacteristic.add(12,0);
        }
        return questionCharacteristic;
    }

    public List<QuestionDTO> assembleRecommendationQuestions(List<QuestionCharacteristicDTO> questionCharacteristicDTOList) {
        List<QuestionDTO> recommendationQuestions = new ArrayList<>();
        for (int i = 0 ;i <7 ;i++){
            QuestionDTO questionDTO = questionService.getById(questionCharacteristicDTOList.get(i).getQuestionID());
            recommendationQuestions.add(questionDTO);
        }
        return recommendationQuestions;

    }
}
