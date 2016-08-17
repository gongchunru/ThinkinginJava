package com.java.base.javaEnum;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * Created by gongchunru on 2016/8/7.
 * Season 类共有4个对象，而且对象的属性是固定的。
 */
public class Season {

    //属性是固定的，说明属性是常量
    private final String SEASON_NAME;
    private final String SEASON_DESC;

    //在类的外部不能创建多个对象，所以私有化构造器。
    private Season(String seasonName, String seasonDesc) {
        this.SEASON_NAME = seasonName;
        this.SEASON_DESC = seasonDesc;
    }

    //在类的内部常见的4个对象，且这四个对象不能被修改。
    public final static Season SPRING = new Season("春天","春风又绿江南岸");
    public final static Season SUNMMER = new Season("夏天","映日荷花别样红");
    public final static Season AUTUMN = new Season("秋天","秋水共长天一色");
    public final static Season WINTER = new Season("冬天","窗含西岭千秋雪");

    public String getSEASON_NAME() {
        return SEASON_NAME;
    }

    public String getSEASON_DESC() {
        return SEASON_DESC;
    }
}
