# Iterator Pattern-迭代器模式
迭代器模式时行为模式中的一种，可以在不知道集合的表现形式(数组/链表/...)的情况下,以一定的顺序的方式接入集合对象中的元素  
这里我们创建一个Iterator 接口，创建一个Container接口用于返回一个Iterator 对象。一个具体的类实现Container接口,同时我们在这个具体的类中定义一个私有的类用来实现我们的Iterator，然后返回一个Iterator。
## Step one
首先我们创建一个Iterator接口，其中hasNext方法用于判断我们是否遍历到一个集合的末尾，next方法返回当前我们遍历的值
```Java
public interface Iterator{
    boolean hasNext();
    object next();
}
```
## Step two
创建一个Container接口，其中的getIterator用于返回一个Iterator对象供第三方使用
```Java
public interface Container{
    Iterator getIterator();
}
```
## Step three
我们创建一个nameRepository类实现Container接口，我们必须要实现getIterator方法。如果我们要返回一个接口的对象，然而接口是不可实例化的。因此我们只有在那meRepository当中创建一个私有的类来实例化我们的Iterator,然后利用面向对象中多态的特性向上转型成Iterator,并返回。
```Java
public class nameRepository implements Container{
    public String names[] = {"Robert","John","Julie","Lora"};
    @Override
    public Iterator getIterator() {
		  
	return new NameIterator();
    }
	
    private class NameIterator implements Iterator{
	int index;
	@Override
	public boolean hasNext() {
	    if(index < names.length) {
	       return true;
	    }
	    return false;
	}

	@Override
	public Object next() {
	    if(this.hasNext()) {
	       return names[index++];
	    }
	    return null;
	}
    }
}
```
## Step four
验证代码
```Java
public class IteratorPatternDemo {
	  public static void main(String[] args) {
		    NameRepository namesRepository = new NameRepository();
		
		    for(Iterator iter = namesRepository.getIterator();iter.hasNext();) {
			      String name = (String)iter.next();
			      System.out.println("Name: "+name);
		    }
	  }
}
```
## Step five
输出结果
```Java
Name: Robert
Name: John
Name: Julie
Name: Lora
```
