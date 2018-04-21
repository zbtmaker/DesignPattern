# Facade Pattern-外观模式
外观模式通过隐藏现有系统的复杂性，通过向外部提供一个接口供外部接入这个系统。这个接口提供了一些简单的方法供第三方进行调用，同时也隐藏了我们需要调用的类的构造方法，直接通过接口来调用该类的一般方法  
我们在定义一个Shape接口及其相关的实现了该接口的类，然后定义一个ShapeMaker类用于调用实现了Shape类的子类的一些方法
# Step one
首先我们定义一个Shape接口并定义一个draw方法
public interface Shape {
	  void draw();
}
# Step two
创建一个Rectangle类实现Shape接口并实现其中的方法
public class Rectangle implements Shape{
	  @Override
	  public void draw() {
		    System.out.println("Rectangle:: draw()");
	  }
}
# Step three
创建一个Circle类实现Shape接口并实现其中的方法
public class Circle implements Shape{
	  @Override
	  public void draw() {
		    System.out.println("Circle:: draw()");
	  }
}
# Step four
创建一个Square类实现Shape接口并实现其中的方法
public class Square implements Shape{
	  @Override
	  public void draw() {
		    System.out.println("Square:: draw()");
	  }
}
# Step five
创建一个ShapeMaker类用于调用实现了Shape类对象的共有方法
```Java
public class ShapeMaker {
    //field
	  private Shape circle;
	  private Shape rectangle;
	  private Shape square;
    
	  //constructor
	  public ShapeMaker() {
		    circle = new Circle();
		    rectangle = new Rectangle();
		    square = new Square();
	  }
    
	  // get the Circle method
	  public void drawCircle() {
		    circle.draw();
	  }
    
    // get Rectangle method
	  public void drawRectangle() {
		    rectangle.draw();
	  }
    
    // get Square method
	  public void drawSquare() {
		    square.draw();
	  }
}
```
# Step six
验证代码
```Java
public class FacadePatternDemo {
	  public static void main(String[] args) {
		    ShapeMaker shapeMaker = new ShapeMaker();
		    shapeMaker.drawCircle();
		    shapeMaker.drawRectangle();
		    shapeMaker.drawSquare();
	  }
}
```
# Step seven
输出结果
```Java
Circle draw
Square draw
Rectangle draw
```
