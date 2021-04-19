package zhonger.cancer.bbs.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuestionCharacteristicDTO {
    Long questionID;
    List<Integer> questionCharacteristic;
    double similarity;
}