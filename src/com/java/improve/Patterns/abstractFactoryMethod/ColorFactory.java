package com.java.improve.Patterns.abstractFactoryMethod;

/**
 * Created by gongchunru on 2016/9/2.
 *
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shape) {
        return null;
    }

    @Override
    Color getColor(String color) {
        if (color==null){
            return null;
        }
        if (color.equalsIgnoreCase("CIRCLE")){
            return new Red();
        }else if (color.equalsIgnoreCase("GREEN")){
            return new Green();
        }else if (color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }
}
