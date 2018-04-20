package UserStrategyPattern;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByNameAscend implements Strategy{

	@Override
	public void sort(List<User> users) {
		Collections.sort(users,new nameComparator());
	}
	
	private class nameComparator implements Comparator<User>{

		@Override
		public int compare(User o1, User o2) {
			return o1.getName().compareTo(o2.getName());
		}
	}

}
