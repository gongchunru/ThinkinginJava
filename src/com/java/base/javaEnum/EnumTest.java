package com.java.base.javaEnum;

import org.junit.Test;

/**
 * Created by gongchunru on 2016/8/7.
 */
public class EnumTest {


    @Test
    public void testEnumMethod(){
        //1 遍历枚举类的方法，每个枚举类都有一个values()方法，返回枚举对象数组
        SeasonEnum[] seasons = SeasonEnum.values();
        for (SeasonEnum seasonEnum:seasons){
            System.out.println(seasonEnum);
        }

        //2:把每个字符串转为对应的枚举类对象
        String input = "SPRING";

        SeasonEnum s =  Enum.valueOf(SeasonEnum.class,input);
        System.out.println(s);

    }

    @Test
    public void testSeason(){
        Season s1 = Season.SPRING;
    }

    @Test
    public void testEnum(){
    SeasonEnum.AUTUMN.getSeasonDesc();
    }
}
