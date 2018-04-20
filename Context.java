package UserStrategyPattern;

import java.util.List;

public class Context {
	private Strategy strategy;
	
	public Context(Strategy strategy) {
		
		this.strategy = strategy;
		
	}
	public void executeStrategy(List<User> users) {
		
		strategy.sort(users);
		
	}
}
