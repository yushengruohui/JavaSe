package enum_package;

import javax.swing.*;

/**
 * @author: yusheng
 * @create-date: 2019-12-18 22:55
 **/
public enum SeasonEnum {
    // 春天
    Spring(0),
    // 冬天
    Winter(1),
    // 夏天
    Summer(2),
    // 秋天
    Autumn(3);

    /**
     * 状态码
     */
    private int code;

    SeasonEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static String getNameByCode(int code){
        for (SeasonEnum seasonEnum : SeasonEnum.values()) {
            if (seasonEnum.getCode()==code){
                // 注意状态码不要相同，否则只会输出前面的一个枚举元素
                return seasonEnum.toString();
            }
        }
        return null;
    }
}
