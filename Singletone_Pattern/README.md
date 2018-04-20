# Singletone Pattern-单例模式
  单例模式是java当中最简单的设计模式。我们在该类外的外部创建该类的对象时，不管我们的这个类的引用变量是否相同，但是都是引用该类的对象的同一个地址。因此对于单例设计模式的类，我们不对外提供构造方法，因此我们的构造方法必须是私有的。 假设我们有一个SingleObject类是一个单例模式的类，那么我们不能在外部通过new的方式获得SingleObject的对象。我们只能通过该类的getInstance()方法获得SingleObject对象。  
  Step one:既然我们不能在外部通过new的方式获得SingleObject对象，那么我们需要在这个类中提供一个私有的构造方法:  
  '''Java
  //private constructor
  private SingleObject() {
  }
  '''  
  Step two:那么我们就可以通过私有的构造方法在SingleObject类中定义一个private的SingleObject对象:  
  '''Java
  //private SingleObject field
  private static SingleObject instance = new SingleObject();
  '''  
  Step two:由于我们不对外提供构造方法，同时我们在这个类的外部需要使用这个类时能获得该类的对象，那么我们就需要提供一个getInstance的方法供外部获取SingleObject类的对象:  
  '''Java
  //get the instance of SingleObject
  public static SingleObject getInstance() {
	return instance;
  }
  '''  
