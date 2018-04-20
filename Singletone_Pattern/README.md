# Singletone Pattern-单例模式
  单例模式是java当中最简单的设计模式。当一个类在该类的外部创建对象时，只能创建一个对象。也就是说我们在外部创建对象时，不管我们的同一个类的引用变量是否相同，但是都是引用该类的同一个对象地址。  
  假设我们有一个SingleObject类是一个单例模式的类，那么我们不能在外部通过new的方式获得SingleObject的对象。我们只能通过该类的getInstance()方法获得SingleObject对象。  
  Step one：既然我们不能在外部通过new的方式获得SingleObject对象，那么我们需要在SingleObject类中定义一个private的SingleObject对象：  
  
