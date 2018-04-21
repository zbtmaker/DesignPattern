# Filter Patter-过滤器模式
过滤器模式(标准模式)是一种能够让开发者通过逻辑操作以解耦的方式使用不同的标准过滤一些Object或者是将束缚这些Object(这里的束缚指的是过滤后的Object)。
  在这列我们创建一个Person类，一个Criteria接口以及一些具体的类实现我们的Criteria接口，这些实现了Criteria接口的类，都是通过对Person类中的一个域或者是多个域添加一些限制条件用于过滤一些Person对象，从而得到我们想要的Person对象集合。
## Step one
首先我们创建一个Person类，这个类中包含三个域，名称、性别、婚姻状态。一个构造方法，以及域的get方法和set方法  
```Java
public class Person {
    private String name;
    private String gender;
    private String maritalStatus;
    
    public Person(String name,String gender,String maritalStatus) {
    	this.name = name;
	this.gender = gender;
	this.maritalStatus = maritalStatus;
	}
    //getters and setters ...
}
```
## Step two
采用Criteri接口的方式定义一个过滤方法，过滤一个Person类链表，同时返回过滤后的结果仍是一个Person类的链表
```Java
public interface Criteria {
    List<Person> meetCriteria(List<Person> persons);
}
```
## Step three
我们定义一个CriteriaMale实现Criteria接口，根据性别过滤Person链表中的女性后得到性别为male的Person链表
```Java
public class CriteriaMale implements Criteria{

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
    	List<Person> malePersons = new ArrayList<Person>();
	for(Person p:persons) {
	    if(p.getGender().equalsIgnoreCase("MALE")) {
		malePersons.add(p);
	    }
	}
	return malePersons;
    }	
}
```
## Step four
我们定义一个CriteriaFemale实现Criteria接口，根据性别过滤Person链表中的男性后得到一个Female的Person链表
```Java
public class CriteriaFemale implements Criteria{
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
    	List<Person> femalePersons = new ArrayList<Person>();
	for(Person p:persons) {
	    if(p.getGender().equalsIgnoreCase("FEMALE")) {
		femalePersons.add(p);
	    }
	}
	return femalePersons;
    }
}
```
## Step five
我们定义了一个CriteriaSingle实现Criteria接口，根据婚姻状态过滤Person链表中婚姻状态为Marriage的Person对象得到婚姻状态为Single的Person集合
```Java
public class CriteriaSingle implements Criteria{
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singlePersons = new ArrayList<Person>();
	for(Person p:persons) {
	    if(p.getMaritalStatus().equalsIgnoreCase("SINGLE")) {
	       singlePersons.add(p);
	    }
	}
	return singlePersons;
    }
}
```
## Step six
我们需要定义一个方法使得我们的Person链表同时满足我们的两个Criteria。我们定义一个AndCriteri类并实现Criteria接口，同时我们在类中定义两个域criteria、otherCriteria。我们既然要Person链表中的Person对象既满足criteria，又满足otherCriteria，那么我们就需要首先调用criteria方法将Person链表进行第一次过滤，并将过滤的得到的结果传递到otherCriteria中进行第二次过滤。这样过滤了以后就得到了我们想要的结果。
```Java
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
```
## Step seven
我们需要定义一个方法将使得我们过滤后的的结果集合中的Person对象要么是满足criteria或者是满足otherCriteria。那么我们就需要首先将我们的Person链表对象分别传递给criteria和otherCriteria(并行过滤，之前采用的是串行过滤)，将过滤后的结果，将第一个链表中第二个链表不存在的Person对象添加到第二个链表当中。
```Java
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
```
## Step eight
验证代码：
```Java
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
```
## Step nine
输出结果
```Java
[Robert-Male-Single, Jhon-Male-Married, Mike-Male-Single, Bobby-Male-Single]
[Laura-Female-Married, Diana-Female-Single]
[Robert-Male-Single, Diana-Female-Single, Mike-Male-Single, Bobby-Male-Single]
[Robert-Male-Single, Mike-Male-Single, Bobby-Male-Single]
[Robert-Male-Single, Diana-Female-Single, Mike-Male-Single, Bobby-Male-Single, Laura-Female-Married]
```
### Reference
|1|' https://www.tutorialspoint.com/design_pattern/filter_pattern.htm
