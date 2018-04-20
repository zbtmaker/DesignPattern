package Singletone_Pattern;

public class SinglePatternDemo {
	public static void main(String[] args) {
		SingleObject object1 = SingleObject.getInstance();
		SingleObject object2 = SingleObject.getInstance();
		
		if(object1 == object2) {
			System.out.println("object1 equals object2");
		}else {
			System.out.println("object1 didn't equals object2");
		}
	}
}
