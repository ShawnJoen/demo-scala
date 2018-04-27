package main.scala

//object和类的区别是，object对象不能带参数
//当单例对象与某个类共享同一个名称时，称作是这个类的伴生对象：companion object。
//你必须在同一个源文件里定义类和它的伴生对象。类被称为是这个单例对象的伴生类：companion class。
//类和它的伴生对象可以互相访问其私有成员
// 私有构造方法
class CompanionClass private(val color:String) {
  println("创建" + this)
  override def toString(): String = "颜色标记："+ color
}
object CompanionClass {
  private val markers: Map[String, CompanionClass] = Map(
    "red" -> new CompanionClass("red"),
    "blue" -> new CompanionClass("blue"),
    "green" -> new CompanionClass("green")
  )
  def apply(color:String) = {
    if(markers.contains(color)) markers(color) else null
  }
  def getCompanionClass(color:String) = {
    if(markers.contains(color)) markers(color) else null
  }
  def main(args: Array[String]) {
    println(CompanionClass("red"))//颜色标记：red
    // 单例函数调用，省略了.(点)符号
    println(CompanionClass getCompanionClass "blue")//颜色标记：blue
  }
}