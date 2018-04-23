package main.scala

import Array._
import java.util.Date

object HelloWorld {
  def main(args: Array[String]) {
    //Unit 和 java的 void 等同
    //Nothing	 它是任何其他类型的子类型
    //Any 是所有其他类的超类
    //AnyRef 类是Scala里所有引用类(reference class)的基类
    //Null 类是null引用对象的类型(继承自AnyRef的类)
    //关键词 "var" 声明变量，使用关键词 "val" 声明常量
    //指定类型
    var myVar1 : String = "Foo"
    println("myVar1：" + myVar1)
    //推断类型
    val myVar2 = 10
    println("myVar2：" + myVar2)
    //多个变量的声明
    val xmax, ymax = 99
    println("xmax：" + xmax)
    //定义元组
    var pa = (40,"Foo")
    println("pa：" + pa)
    //多行字符串
    val myVar3 =
      """
        |多行字符串,
        |用三个双引号来表示分隔符
      """.stripMargin
    println("myVar3：" + myVar3)
    //函数名可以有以下特殊字符：+, ++, ~, &,-, -- , \, /, : 等
    //可以 函数内定义函数（内嵌函数）,匿名函数
    //不写等于号和方法主体，那么方法会被隐式声明为 抽象(abstract),包含类型于是也是
    //基本函数
    println("function addInt( a:Int, b:Int )：" + addInt(6, 6))
    //匿名函数
    var anonymousFunction = (x:Int) => x + 8;
    println("anonymousFunction：" + (anonymousFunction(6) + 2))//16
    //无参匿名函数
    var noArgsAnonymousFunction = () => { System.getProperty("user.dir") }
    println("noArgsAnonymousFunction：" + noArgsAnonymousFunction())
    //传值调用(call-by-value)先计算参数表达式的值，再应用到函数内部(普通的有参函数)
    //函数传名调用(call-by-name)将未计算的参数表达式直接应用到函数内部
    println("delayed(time):")
    delayed(time)
    //指定函数参数名
    println("appointArgsFunction：" + appointArgs(b = 5, a = 7))
    //函数 - 可变参数
    println("variableArgsFunction：" + variableArgs("m1", "x2", "d3"))
    //递归函数
    for (i <- 1 to 10)
      println(i + " 的阶乘为: = " + recursion(i) )
    //默认参数值
    println("defaultArgsFunction：" + defaultArgs(10))
    //高阶函数（Higher-Order Function）就是操作其他函数的函数
    println("higherOrderFunction：" + higherOrderFunction( layout, 10) )
    //偏应用函数是一种表达式，你不需要提供函数需要的所有参数，提供部分，或不提供所需参数
    val date = new Date
    val logWithDateBound = log(date, _ : String)//参数使用下划线(_)替换缺失的参数
    logWithDateBound("partially-applied1" )
    logWithDateBound("partially-applied2")
    logWithDateBound("partially-applied3" )
    //函数柯里化(Currying)
    val str1:String = "Hello, "
    val str2:String = "Scala!"
    println( "str1 + str2 = " +  strcat(str1)(str2) )
    val curryingFunctionResult = curryingFunction(3)
    println( "curryingFunction(x:Int)(y:Int) :" +  curryingFunctionResult(5) )//8
    //闭包
    println( "closuresFunction :" +  closuresFunction(9) )//27
    //StringBuilder字符串
    val buf = new StringBuilder;
    buf += 'a'
    buf ++= "bcdef"
    println( "StringBuilder : " + buf.toString + ",length():" + buf.length());//abcdef
    //Concat字符串链接, 也可以使用加号(+)来连接
    var str3 = "abcdec";
    var str4 = "|aaa";
    println( "String Concat : " + str3.concat(str4));//abcde|aaa
    var floatVar = 12.456f
    var intVar = 9999
    var stringVar = "春林"
    var fs = printf("浮点型变量为：%f, 整型变量为：%d, 字符串为：%s", floatVar, intVar, stringVar)
    println("printf: " + fs)
    println("charAt: " + str3.charAt(2))//c
    var str5 = "b";
    var str6 = "B";
    //compareTo 相同0，大>0，小<0
    println("compareTo: " + str5.compareTo(str6))//32
    println("compareToIgnoreCase: " + str5.compareToIgnoreCase(str6))//0
    //endsWith是否以指定的后缀结束
    println("endsWith: " + str3.endsWith("cde"))//true
    //返回此字符串的哈希码
    println("hashCode: " + str5.hashCode())//98
    //indexOf返回指定字符在此字符串中第一次出现处的索引
    println("indexOf: " + str3.indexOf("c"))//2
    println("indexOf: " + str3.indexOf("c",3))//5
    //--------------------------------------------------------------
    //三种定义一维数组方式
    var arr:Array[String] = new Array[String](3)
    var arr2 = new Array[String](3)
    var arr3 = Array("aaa", "bbb", "ccc")
    arr2(0) = "aaa"; arr2(1) = "bbb"; arr2(4/2) = "ccc"
    for ( x <- arr3 ) {
      println( x )
    }
    var arr4 = Array(1.9, 2.9, 3.4, 3.5, 2)
    var max = arr4(0);
    for ( i <- 1 to (arr4.length - 1) ) {//1为初始值 然后 递增
      if (arr4(i) > max) max = arr4(i);
    }
    println("最大值为 " + max);
    //多维数组
    var myMatrix = ofDim[Int](3,3)
    // 创建矩阵
    for (i <- 0 to 2) {
      for ( j <- 0 to 2) {
        myMatrix(i)(j) = j*10;
      }
    }
    for (i <- 0 to 2) {
      for ( j <- 0 to 2) {
        println(" " + myMatrix(i)(j));
      }
    }
    //合并数组
    var arr5 = Array(1.9, 2.9, 3.4, 3.5)
    var arr6 = Array(8.9, 7.9, 0.4, 3.5)
    var arr7 =  concat( arr5, arr6)
    for ( x <- arr7 ) {
      println( x )
    }
    //创建区间数组 - range() 方法最后一个参数为步长，默认为 1
    var myList1 = range(10, 20, 2)
    var myList2 = range(10,20)

    // 输出所有数组元素
    for ( x <- myList1 ) {
      print( " " + x )
    }
    println()
    for ( x <- myList2 ) {
      print( " " + x )
    }

  }
  //闭包
  var factor = 3
  val closuresFunction = (i:Int) => i * factor
  //函数柯里化(Currying)
  def curryingFunction(x:Int)=(y:Int)=> x + y
  def strcat(s1: String)(s2: String) = {
    s1 + s2
  }
  def log(date: Date, message: String)  = {
    println(date + "----" + message)
  }
  //高阶函数（Higher-Order Function）就是操作其他函数的函数
  //函数 f 和 值 v 作为参数，而函数 f 又调用了参数 v
  def higherOrderFunction(f: Int => String, v: Int) = f(v)
  def layout[A](x: A) = "[" + x.toString() + "]"
  //默认参数值
  def defaultArgs( a:Int=5, b:Int=7 ) : Int = {
    var sum:Int = 0
    sum = a + b
    return sum
  }
  //递归函数
  def recursion(n: BigInt): BigInt = {
    if (n <= 1)
      1
    else
      n * recursion(n - 1)
  }
  //函数 - 可变参数
  def variableArgs( args:String* ) = {
    var i : Int = 0;
    for( arg <- args ){
      println("Arg value[" + i + "] = " + arg );
      i = i + 1;
    }
  }
  def appointArgs( a:Int, b:Int ) = {
    println("Value of a : " + a );
    println("Value of b : " + b );
  }
  //函数
  def addInt( a:Int, b:Int ) : Int = {
    var sum:Int = 0
    sum = a + b
    return sum
  }
  def time() = {
    println("获取时间，单位为纳秒")
    System.nanoTime
  }
  def delayed( t: => Long ) = {
    println("在 delayed 方法内")
    println("参数： " + t)//此处执行同时 获取返回值输出
  }
}
