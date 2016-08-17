package com.java.base.javaEnum;

/**
 * Created by gongchunru on 2016/8/7.
 */
public enum SeasonEnum {
    //枚举类的实例，需要在枚举类的第一行列出。
    // 系统会自动添加上public static final 修饰。
    SPRING("春天","春风又绿江南岸"),
    SUMMER("夏天","映日荷花别样红"),
    AUTUMN("秋天","秋水共长天一色"),
    WINTER("冬天","窗含西岭千秋雪");

    private final String seasonName;
    private final String seasonDesc;

    SeasonEnum(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
}
