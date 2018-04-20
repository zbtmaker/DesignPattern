package Filter_Pattern;

import java.util.List;

public interface Criteria {
	List<Person> meetCriteria(List<Person> persons);
}
