package Factory_Pattern;

public class FactoryPatternDemo {
	public static void main(String[] args) {
		ShapeFactory sf = new ShapeFactory();
		//get a Circle Object
		Shape s1 = sf.getShape("Circle");
		s1.draw();
		
		//get a Square Object
		Shape s2 = sf.getShape("Square");
		s2.draw();
		
		//get a Rectangle Object
		Shape s3 = sf.getShape("Rectangle");
		s3.draw();
	}
}
