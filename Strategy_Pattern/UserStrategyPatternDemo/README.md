# UserSort
在这个例子中我们主要是对一个User类的集合进行排序。创建一个User类，域为age和name。我们创建一个Strategy接口添加一个executeStrategy(sort)方法和相应的类实现Strategy接口。这些实现了Strategy的类主要是User的不同属性进行排序，对age进行升降排序，对name进行升降排序。
## Step one
创建一个User类
```Java
public class User {
	  private int age;
	  private String name;
	
	  public User(int age,String name) {
		    this.age = age;
		    this.name = name;
	  }
    //getters and setters of fields....
}
```
## Step two
创建一个Strategy接口，添加一个sort方法
```Java
public interface Strategy {
	  void sort(List<User> user);
}
```
## Step three
创建一个SortByAgeAscend类实现Strategy接口，并实现sort方法。这里我们调用了Collections中的sort方法，并实现了一个新的Comparator。通过比较用户的年龄的方式对用户进行升序排序
```Java
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
```
## Step four
创建一个SortByAgeDescend类实现Strategy接口，并实现sort方法。这里我们调用了Collections中的sort方法，并实现了一个新的Comparator。通过比较用户的年龄的方式对用户进行降序排序
```Java
public class SortByAgeDescend implements Strategy{
	  @Override
	  public void sort(List<User> users) {

		    Collections.sort(users, new ageComparator());
		
	  }
	  private class ageComparator implements Comparator<User>{
		    @Override
		    public int compare(User o1, User o2) {
			      if(o1.getAge() < o2.getAge()) {
				        return 1;
			      }
			      if(o1.getAge() > o2.getAge()) {
				        return -1;
			      }
			      return 0;
		    }
	  }
}
```
## Step five
创建一个SortByNameDescend类实现Strategy接口，并实现sort方法。这里我们调用了Collections中的sort方法，并实现了一个新的Comparator。通过比较用户的姓名的方式对用户进行降序排序
```Java
public class SortByNameDescend implements Strategy{
	  @Override
	  public void sort(List<User> users) {
		
		    Collections.sort(users,new nameComparator());
		
	  }
	  private class nameComparator implements Comparator<User> {
		    @Override
		    public int compare(User o1, User o2) {
			
			      return o2.getName().compareTo(o1.getName());
			
		    }
		
	  }
}
```
## Step Six
创建一个SortByNameDescend类实现Strategy接口，并实现sort方法。这里我们调用了Collections中的sort方法，并实现了一个新的Comparator。通过比较用户的姓名的方式对用户进行升序排序
```Java
public class SortByNameAscend implements Strategy{
	  @Override
	  public void sort(List<User> users) {
		
		    Collections.sort(users,new nameComparator());
		
	  }
	  private class nameComparator implements Comparator<User> {
		    @Override
		    public int compare(User o1, User o2) {
			
			      return o1.getName().compareTo(o2.getName());
			
		    }
		
	  }
}
```
## Step seven
创建一个Context类，类中的有一个私有的field Strategy以及一个构造方法，另有一个executeStrategy来执行我们的Strategy
```Java
public class Context {
	  private Strategy strategy;
	
	  public Context(Strategy strategy) {
		
		    this.strategy = strategy;
		
	  }
	  public void executeStrategy(List<User> users) {
		
		    strategy.sort(users);
		
	  }
}
```
## Step eight
验证代码
```Java
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
```
## Step nine
输出结果
```Java
[10-F, 13-D, 15-B, 12-A]
```
