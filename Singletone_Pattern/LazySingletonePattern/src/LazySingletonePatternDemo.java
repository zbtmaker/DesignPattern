package Singletone_Pattern;

public class LazySingletonePatternDemo {
	public static void main(String[] args) {
		
		LazySingletoneObject object1 = LazySingletoneObject.getInstance();
		LazySingletoneObject object2 = LazySingletoneObject.getInstance();
		
		if(object1 == object2) {
			System.out.println("object1 equals object2");
		}else {
			System.out.println("object1 didn't equals object2");
		}
	}
}
