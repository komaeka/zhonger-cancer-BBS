package zhonger.cancer.bbs.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class QuestionCharacteristicDTO{
    Long questionID;
    List<Integer> questionCharacteristic;
    BigDecimal similarity;

}