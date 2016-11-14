package com.java.improve.Patterns.builderPattern.builderPattern2;

/**
 * Created by gongchunru on 2016/11/14.
 */
public class HotDryNoodlesWithBuilder {

    private boolean addShallot;//葱花
    private boolean addParsley;//香菜
    private boolean addChili;//辣椒
    private boolean addSauerkraut;//酸菜

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder("A bowl of hot-dry noodles has:");

        if (this.addShallot) {
            builder.append("葱花.");
        }

        if (this.addParsley) {
            builder.append("香菜.");
        }

        if (this.addChili) {
            builder.append("辣椒.");
        }

        if (this.addSauerkraut) {
            builder.append("酸菜.");
        }

        return builder.toString();
    }

}
