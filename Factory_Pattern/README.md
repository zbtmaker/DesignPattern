# Factory Pattern --工厂模式
工厂模式主要是一种创建模式，在这种模式中，我们对第三方隐藏我们的创建对象的逻辑，同意使用接口的方式创建对象。  
这里我们创建一个Shape接口以及一些是想了这类接口的类，然后创建一个ShapeFactory来创建实现了Shape接口的对象
## Step one
创建一个Shape接口，并在其中添加一个draw方法
```Java
public interface Shape {
	  void draw();
}
```
## Step two
创建一个Rectangle类实现Shape接口并实现接口中的draw方法
```Java
public class Rectangle implements Shape{
	  @Override
	  public void draw() {
		    System.out.println("Rectangle draw");
	  }
}
```
## Step three
创建一个Circle类实现Shape接口并实现接口中的draw方法
```Java
public class Circle implements Shape{
	  @Override
	  public void draw() {
		    System.out.println("Circle draw");
	  }
}
```
## Step four
创建一个Square类实现Shape接口并实现接口中的draw方法
```Java
public class Square implements Shape{
	  @Override
	  public void draw() {
		    System.out.println("Circle draw");
	  }
}
```
## Step five
创建一个ShapeFactory用于创建实现了Shape类的对象，并提供对象的获取方法
```Java
public class ShapeFactory {
	  //get Shape object by shapeType
	  public Shape getShape(String shapeType) {
		    if(shapeType == null)
			      return null;
		
		    if(shapeType == "Rectangle") {
			      return new Rectangle();
		    }
		
		    if(shapeType == "Circle") {
			      return new Circle();
		    }
		
		    if(shapeType == "Square") {
			      return new Square();
		    }
		    return null;
	  }
}
```
## Step six
验证代码:
```Java
public class FactoryPatternDemo {
	  public static void main(String[] args) {
		    ShapeFactory sf = new ShapeFactory();
        
		    //get Circle Instance
		    Shape s1 = sf.getShape("Circle");
		    s1.draw();
		
		    //get Square Instance
		    Shape s2 = sf.getShape("Square");
		    s2.draw();
		
		    //get Rectangle Instance
		    Shape s3 = sf.getShape("Rectangle");
		    s3.draw();
	  }
}
```
## Step Seven
输出结果
```Java
Circle draw
Square draw
Rectangle draw
```
