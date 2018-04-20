package UserStrategyPattern;

import java.util.ArrayList;

public class UserStrategyPatternDemo {
	public static void main(String[] args) {
		ArrayList<User> users = new ArrayList<User>();
		
		users.add(new User(12,"A"));
		users.add(new User(10,"F"));
		users.add(new User(15,"B"));
		users.add(new User(13,"D"));
		
		Context context = new Context(new SortByNameDescend());
		
		context.executeStrategy(users);
		
		System.out.println(users.toString());
	}
}
