package Singletone_Pattern;
/**
 * 单例设计模式
 * @author zoubaitao
 * 2018-4-20
 */
public class SingleObject {
	//private SingleObject field
	private static SingleObject instance = new SingleObject();
	
	//private constructor
	private SingleObject() {
	}
	
	//get the instance of SingleObject
	public static SingleObject getInstance() {
		return instance;
	}
}
