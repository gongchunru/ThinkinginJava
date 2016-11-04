package com.java.improve.Patterns.builderPattern.builderPattern;

/**
 * Created by gongchunru on 2016/10/28.
 */
public abstract class Builder {
    protected Role role = new Role();

    public abstract void buildHead();

    public abstract void buildFace();

    public abstract void buildBody();

    public abstract void buildHp();

    public abstract void buildSP();

    public abstract void buildMp();

    public Role getResult(){
        return role;
    }

}
