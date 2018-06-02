package main.scala

/*
    1.只有主构造函数才可以往基类的构造函数里写参数
    2.在子类中重写超类的抽象方法时，你不需要使用override关键字
    3.Scala 只允许继承一个父类
    4.Scala 没有 static 关键字，但是它也为我们提供了单例模式的实现方法，那就是使用关键字 object
    5.object和类的区别是，object对象不能带参数
    当单例对象与某个类共享同一个名称时，称作是这个类的伴生对象：companion object。
    你必须在同一个源文件里定义类和它的伴生对象。类被称为是这个单例对象的伴生类：companion class。
    类和它的伴生对象可以互相访问其私有成员
    私有构造方法
    访问修饰符:
      保护（Protected）成员的访问比java更严格.因为它只允许保护成员在定义了该成员的的类的子类中
            被访问.而在java中protected除了定义了该成员的类的子类可以访问,同一个包里的其他类也
            可以进行访问
      没有指定任何的修饰符，则默认为 public。这样的成员在任何地方都可以被访问
    作用域保护: private[x], protected[x]
      x指代某个所属的包、类或单例对象。如果写成private[x],读作"这个成员除了对[…]中的类
      或[…]中的包中的类及它们的伴生对像可见外，对其它所有类都是private

    样例类 模式匹配 - case class TestCaseClass(name: String, age: Int)
    声明样例类时，下面的过程自动发生
    构造器的每个参数都成为val，除非显式被声明为var，但是并不推荐这么做
    在伴生对象中提供了apply方法，所以可以不使用new关键字就可构建对象
    提供unapply方法使模式匹配可以工作
    生成toString、equals、hashCode和copy方法，除非显示给出这些方法的定义
*/
class CompanionClass private(val color:String) {//单例对象的伴生类
  println("创建" + this)
  override def toString(): String = "颜色标记："+ color
}
object CompanionClass {//单例对象
  private val markers: Map[String, CompanionClass] = Map(
    "red" -> new CompanionClass("red"),
    "blue" -> new CompanionClass("blue"),
    "green" -> new CompanionClass("green")
  )
  def apply(color:String) = {
    println("-------");
    if(markers.contains(color)) markers(color) else null
  }
  def getCompanionClass(color:String) = {
    if(markers.contains(color)) markers(color) else null
  }
  def main(args: Array[String]) {
    //创建颜色标记：red
    //创建颜色标记：blue
    //创建颜色标记：green

    //构造方法传出事参数
    println(CompanionClass("red"))//输出toString
    //-------
    //颜色标记：red

    //单例函数调用, 省略了.(点)符号
    println(CompanionClass getCompanionClass "blue")//输出toString
    //颜色标记：blue

  }
}