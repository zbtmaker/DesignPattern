package Factory_Pattern;

public class FactoryPatternDemo {
	public static void main(String[] args) {
		ShapeFactory sf = new ShapeFactory();
		//
		Shape s1 = sf.getShape("Circle");
		s1.draw();
		
		//
		Shape s2 = sf.getShape("Square");
		s2.draw();
		
		//
		Shape s3 = sf.getShape("Rectangle");
		s3.draw();
	}
}
