# Filter Patter-过滤器模式
过滤器模式(标准模式)是一种能够让开发者通过逻辑操作以解耦的方式使用不同的标准过滤一些Object或者是将束缚这些Object(这里的束缚指的是过滤后的Object)。
  在这列我们创建一个Person类，一个Criteria接口以及一些具体的类实现我们的Criteria接口，这些实现了Criteria接口的类，都是通过对Person类中的一个域或者是多个域添加一些限制条件用于过滤一些Person对象，从而得到我们想要的Person对象集合。
## Step one
首先我们创建一个Person类，这个类中包含三个域，名称、性别、婚姻状态。一个构造方法，以及域的get方法和set方法  
```Java
public class Person {
	private String name;
	private String gender;
	private String maritalStatus;
	
	public Person(String name,String gender,String maritalStatus) {
		this.name = name;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
	}
  //getters and setters ...
}
```
