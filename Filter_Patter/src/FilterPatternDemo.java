package Filter_Pattern;

import java.util.ArrayList;
import java.util.List;

public class FilterPatternDemo {
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();
		
		persons.add(new Person("Robert","Male","Single"));
		persons.add(new Person("Jhon","Male","Married"));
		persons.add(new Person("Laura","Female","Married"));
		persons.add(new Person("Diana","Female","Single"));
		persons.add(new Person("Mike", "Male", "Single"));
	    persons.add(new Person("Bobby", "Male", "Single"));
	    
	    Criteria male = new CriteriaMale();
	    Criteria female = new CriteriaFemale();
	    Criteria single = new CriteriaSingle();
	    Criteria SingleMan = new AndCriteria(male,single);
	    Criteria singleOrFemale = new OrCriteria(female,single);
	    
	    System.out.println(male.meetCriteria(persons));
	    System.out.println(female.meetCriteria(persons));
	    System.out.println(single.meetCriteria(persons));
	    System.out.println(SingleMan.meetCriteria(persons));
	    System.out.println(singleOrFemale.meetCriteria(persons));
	}
}
