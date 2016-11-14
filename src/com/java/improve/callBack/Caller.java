package com.java.improve.callBack;

/**
 * @author gongchunru
 * @Package com.java.improve.callBack
 * @date 16/9/15 16:50
 */
public class Caller {

    public ICall call;

    public void setcallFun(ICall call){
        this.call = call;
    }

    public void call(){
        this.call.method();
    }
}
