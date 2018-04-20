package UserStrategyPattern;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByAgeAscend implements Strategy{

	@Override
	public void sort(List<User> users) {

		Collections.sort(users, new ageComparator());
		
	}
	private class ageComparator implements Comparator<User>{
		@Override
		public int compare(User o1, User o2) {
			if(o1.getAge()>o2.getAge()) {
				return 1;
			}
			if(o1.getAge()<o2.getAge()) {
				return -1;
			}
			return 0;
		}
		
	}
}
