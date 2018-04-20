package Factory_Pattern;

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
