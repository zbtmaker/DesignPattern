package Filter_Pattern;

import java.util.List;

public class OrCriteria implements Criteria{
	Criteria criteria;
	Criteria otherCriteria;
	
	public OrCriteria(Criteria criteria,Criteria otherCriteria) {
		this.criteria = criteria;
		this.otherCriteria = otherCriteria;
	}

	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> firstCriteriaPerson = criteria.meetCriteria(persons);
		List<Person> otherCriteriaPerson = otherCriteria.meetCriteria(persons);
		
		for(Person p:firstCriteriaPerson) {
			if(!otherCriteriaPerson.contains(p)) {
				otherCriteriaPerson.add(p);
			}
		}
		return otherCriteriaPerson;
	}
	
}
