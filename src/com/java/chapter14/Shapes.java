package com.java.chapter14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在此主要是为了表现多态
 * @author gongchunru
 *
 */
abstract class Shape {
	void draw(){
		System.out.println(this+".draw()");
	}//以此强调继承制复写该方法，并可以防止对无格式的Shape的实例化。
	abstract public String toString();
}

class Circle extends Shape{
	@Override
	public String toString() {
		return "Circle";
	}
}
class Square extends Shape{
	@Override
	public String toString() {
		return "Square";
	}
}
class Triangle extends Shape{
	@Override
	public String toString() {
		return "Triangle";
	}
}

// 添加一行注释
public class Shapes {
	public static void main(String[] args) {
		List<Shape> shapeList = Arrays.asList(new Circle(),new Square(),new Triangle());
		for(Shape shape : shapeList){
			shape.draw();
		}
	}
	
}
