package Filter_Pattern;

import java.util.List;

public class AndCriteria implements Criteria{
	private Criteria criteria;
	private Criteria othercriteria;
	
	public AndCriteria(Criteria criteria,Criteria othercriteria) {
		this.criteria = criteria;
		this.othercriteria = othercriteria;
	}

	public List<Person> meetCriteria(List<Person> persons ) {
		List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
		List<Person> otherCriteriaPersons = othercriteria.meetCriteria(firstCriteriaPersons);
		return otherCriteriaPersons;
	}
	
}
