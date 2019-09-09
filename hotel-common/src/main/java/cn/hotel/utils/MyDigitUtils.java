package cn.hotel.utils;
import java.math.BigDecimal;

/**数据处理、数字金额转换
 * @description:
 * @author: 汪志雄
 * @date: 2019-09-07 15:21
 */
public class MyDigitUtils {

    private static final String[] CN_UPPER_NUMBER = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };

    private static final String[] CN_UPPER_MONETRAY_UNIT = { "分", "角", "元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾",
            "佰", "仟", "兆", "拾", "佰", "仟" };
    /**
     * 将金额转换为大写中文
     *
     * @param money
     * @return
     */
    public static String number2CNMoneyUnit(double money) {
        StringBuffer sbBuffer = new StringBuffer();
        BigDecimal bigDecimalMoney = BigDecimal.valueOf(money);
        int signum = bigDecimalMoney.signum();
        if (signum == 0) {
            return "零元整";
        }
        long number = bigDecimalMoney.setScale(2, BigDecimal.ROUND_HALF_UP).abs().movePointRight(2).longValue();

        int numIndex = 0;
        int numUnit = 0;

        boolean getZero = false;
        if (number % 100 == 0) {
            sbBuffer.append("整");
            number=number/100;
            numIndex = 2;
            getZero = true;
        } else if (number % 10 == 0) {
            number=number/10;
            numIndex = 1;
            getZero = true;
        }
        while (true) {
            if (number == 0) {
                break;
            }
            numUnit = (int) (number % 10);
            if (numUnit == 0) {
                if (getZero) {
                    if (numIndex == 2) {
                        sbBuffer.insert(0, "元");
                    } else if ((numIndex - 2) % 4 == 0 && number % 10000 != 0) {
                        sbBuffer.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);

                    }

                }else {
                    sbBuffer.insert(0, "零");
                }
                getZero = true;
            } else {
                sbBuffer.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                sbBuffer.insert(0, CN_UPPER_NUMBER[numUnit]);
                getZero = false;
            }
            number = number / 10;
            numIndex++;

        }
        if (signum < 0) {
            sbBuffer.insert(0, "负");
        }

        return sbBuffer.toString();
    }
}


