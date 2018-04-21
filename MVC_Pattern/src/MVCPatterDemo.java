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
