# MVC Pattern(Model-View-Controller) Pattern-模型视图控制模式
MVC 模式主要分为三个部分：
* model:代表一个java 对象或者是一个简单的Java对象(POJO),当对象的数据发生变化时会升级controller
* view:代表一个模型所包含的数据的visualization(这一模块主要是将对象的数据展示给系统的外部世界)
* controller:用于控制model和view。controller用于控制model中object的数据流，当数据改变的时候升级view 
这个模式在做项目的时候非常有用，在学习Servlet&JSP时用到这种模式，而且做一个项目大多数是将对象(model)改变的信息存储到数据库中，或者是从数据库中展示一些对象的信息，这里网页模块则是充当着iew模块，而servlet则是充当一个controller的角色
model模块下创建一个Student类作为一个，view模块下创建一个StudentView类将Student 的信息到控制台上。同时我们创建一个StudenController用于控制Student对象的存储和升级StudentView类的对象
## Step one
创建一个Student类
```Java
public class Student {
	  private String rollNo;
	  private String name;
    //getters and setters method...
}
```
## Step two 
创建一个StudentView用于将将Student对象的信息输出到Console上
```Java
public class StudentView {
    public void printStudentDetails(String studentName,String studentRollNo) {
		    System.out.println("Student");
		    System.out.println("Name:"+studentName);
		    System.out.println("Roll No:"+studentRollNo);
	  }
}
```
## Step three
创建一个StudentController用于控制Student信息的更新，同时将更新后的数据输出到Console上
```Java
public class StudentController {
	  private Student model;
	  private StudentView view;
    
	  public StudentController(Student model,StudentView view) {
		    this.model = model;
		    this.view = view;
	  }
	
	  public void setStudentName(String name) {
		    model.setName(name);
	  }
	
	  public void setStudentRollNo(String rollNo) {
		    model.setRollNo(rollNo);
	  }
	
	  public String getStudentRollNo() {
		    return model.getRollNo();
	  }
	
	  public void updateView() {
		    view.printStudentDetails(model.getName(),model.getRollNo());
	  }
}
```
## Step four
代码验证
```Java
public class MVCPatterDemo {
	  public static void main(String[] args) {
		    //fetch studen record based on his roll no from database
		    Student model = retriveStudentFromDatabase();
		
		   //Create a view :to write student details on Console
		   StudentView view = new StudentView();
		
		   StudentController controller = new StudentController(model,view);
		
		   controller.updateView();
		
		   //update model data;
		   controller.setStudentName("Li Gang");
		
		   controller.updateView();
	  }

	  private static Student retriveStudentFromDatabase() {
		    Student student = new Student();
		    student.setName("Robert");
		    student.setRollNo("10");
		    return student;
	  }
}
```
## Step five
输出结果
```Java
Student
Name:Robert
Roll No:10
Student
Name:Li Gang
Roll No:10
```

