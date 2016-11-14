package com.java.improve.Patterns.ProtorypePattern;

import java.util.Hashtable;

/**
 * @author gongchunru
 * @Package com.java.improve.Patterns.ProtorypePattern
 * @date 16/9/7 02:28
 *
 *
 * 从数据库中获取实体类,并把他们存储在一个Hashtable中
 */
public class ShapeCache {
    private  static Hashtable<String ,Shape> shapeMap = new Hashtable<String, Shape>();

    public static Shape getShape(String shapedId){
        Shape cacheShape = shapeMap.get(shapedId);
        return (Shape)cacheShape.clone();
    }

    //对每种形状都运行数据库查询,并创建该形状
    //shapeMap.put(ShapeKey,shape)
    //例如,我们要添加三种形状
    public static void loadCache(){
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(),circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(),square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(),rectangle);

    }




}
