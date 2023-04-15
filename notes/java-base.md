# Java 基础

## 面向对象

> 面向对象的SOLID原则
>
> S.O.L.I.D 是面向对象设计和变成（OOD%OOP）中几个重要编码原则（Programming Priciple）的首字母缩写
>
> | SRP  | The Single Responsibility Principle | 单一责任原则 |
> | ---- | ----------------------------------- | ------------ |
> | OCP  | The Open Closed Principle           | 开放封闭原则 |
> | LSP  | The Liskov Substitution Principle   | 里氏替换原则 |
> | DIP  | The Dependency Inversion Principle  | 依赖倒置原则 |
> | ISP  | The Interface Segregation Principle | 接口分离原则 |
>
> 单一责任原则：
>
> ​	当需要修改某个类的时候原因只有一个（The should never be more than one reason for a class to change).换句话说就是让一个类只做一种类型责任，当这个类需要承当其他类型的责任的时候，就需要分解这个类
>
> 开放封闭原则：
>
> ​	软件实体应该是可扩展，而不可修改的。也就是说，对扩展是开放的，而对修改时封闭的。这个原则是诸多面向对象变成原则中最城乡、最难理解的一个
>
> 里氏替换原则：
>
> ​	当一个子类的实例应该能够替换任何其超累的实例时，它们之间才具有is-A关系
>
> 依赖倒置原则：
>
> ​	高层模块不应该依赖于低层模块，二者都应该依赖于抽象
>
> ​	抽象不应该依赖于细节，细节应该依赖于抽象
>
> 接口分离原则：
> 	不能强迫用户去依赖那些他们不使用的接口。换句话说，使用多个专门的接口比使用单一的总接口总要好。

### 三大特性

#### 封装

利用抽象数据类型将数据和基于数据的操作封装在一起，使其构成一个不可分割的独立实体。数据被保护在抽象数据类型的内部，尽可能地隐藏内部地细节，只保留一些对外接口使之与外部发生联系。用户无需知道对象内部地细节，但可以通过对象对外提供地接口来访问该对象

优点：

- 减少耦合：可以独立地开发、测试、优化、使用、理解和修改
- 减轻维护地负担：可以更容易被程序员理解，并且在调试地时候可以不影响其他模块
- 有效地调节性能：可以通过剖析确定哪些模块影响了系统的性能
- 提高软件的可重用性
- 降低了构建大型系统的风险：即使整个系统不可用，但是这些独立的模块却有可能是可用的

 ![image-20230404144822081](E:\IdeaProject\JDK\notes\projectImg\image-20230404144822081.png)

#### 继承

继承实现了IS-A关系

继承应该遵循里氏替换原则，子类对象必须能够替换掉所有父类对象

 ![image-20230404144909899](E:\IdeaProject\JDK\notes\projectImg\image-20230404144909899.png)

Cat可以当作Animal来使用，也就是说可以使用Animal引用Cat对象，父类引用指向子类对象称为向上转型

#### 多态

多态分为 编译时多态 和 运行时多态

- 编译时多态主要指方法的重载
- 运行时多态指程序中定义的对象引用所指向的具体类型在运行期间才确定

运行时多态有三个条件：

- 继承
- 覆盖（重写）
- 向上转型

 ![image-20230404145215450](E:\IdeaProject\JDK\notes\projectImg\image-20230404145215450.png)

#### 类图 

绘制工具：[PlantUML](https://www.planttext.com/)

更多语法及使用请参考: http://plantuml.com/

##### 泛化关系（Generalization）

用来描述继承关系，在Java中使用extends关键字

 ![image-20230404145405165](E:\IdeaProject\JDK\notes\projectImg\image-20230404145405165.png)

##### 实现关系（Realization）

用来实现一个接口，在Java中使用implements关键字

 ![image-20230404151127416](E:\IdeaProject\JDK\notes\projectImg\image-20230404151127416.png)

##### 聚合关系（Aggregation)

表示整体由部分组成，但是整体和部分不是强依赖的，整体不存在了部分还是会存在

 ![image-20230404154058920](E:\IdeaProject\JDK\notes\projectImg\image-20230404154058920.png)

##### 组合关系（Composition）

和聚合不同，组合中整体和部分是强依赖的，整体不存在了部分也就不存在了。比如公司和部门，公司没了部门就不存在了。但是公司和员工就属于聚合关系了，因为公司没了员工还在

 ![image-20230404154439721](E:\IdeaProject\JDK\notes\projectImg\image-20230404154439721.png)

##### 关联关系（Association）

表示不同类对象之间有关联，这是一种静态关系，与运行过程的状态无关，在最开始就可以确定。因此也可以用1对1、多对1、多对多这种关联关系来表示。比如学生和学校就是一种关联关系，一个学校可以有很多学生，但是一个学生只属于一个学校，因此这事一种多对一的关系，在运行开始之前就可以确定

![image-20230404154928131](E:\IdeaProject\JDK\notes\projectImg\image-20230404154928131.png) 

##### 依赖关系（Dependency）

和关联关系不同的是，依赖关系是在运行过程中起作用的。A类和B类是依赖关系主要有三种形式：

- A类是B类中的（某种方法的）局部变量
- A类是B类方法当中的一个参数
- A类向B类发送消息，从而影响B类发生变化

![image-20230404160648438](E:\IdeaProject\JDK\notes\projectImg\image-20230404160648438.png) 

## 知识点

### 数据类型

#### 包装类型

八个基本类型：

- boolean/1
- byte/8
- char/16
- short/16
- int/32
- flaot/32
- long/64
- double/64

基本类型都有对应的包装类型，基本类型与其对应的包装类型之间的赋值使用自动装箱与拆箱完成

![image-20230404163226304](E:\IdeaProject\JDK\notes\projectImg\image-20230404163226304.png) 

#### 缓存池

new Integer(123) 与 Integer.valueOf(123) 的区别在于：

- new Integer(123) 每次都会新建一个对象
- Integer.valueOf(123) 会使用缓存池中的对象，多次调用会取得同一个对象的引用

![image-20230404163505990](E:\IdeaProject\JDK\notes\projectImg\image-20230404163505990.png) 

valueOf() 方法的实现比较简单，就是先判断值是否在缓存池中，如果在的话就直接返回缓存池的内容

![image-20230404163609426](E:\IdeaProject\JDK\notes\projectImg\image-20230404163609426.png) 

在 Java 8 中，Integer 缓存池的大小默认为 -128~127。

![image-20230404163743121](E:\IdeaProject\JDK\notes\projectImg\image-20230404163743121.png) 

编译器会**在缓冲池范围内的基本类型**自动装箱过程调用 valueOf() 方法，因此多个 Integer 实例使用自动装箱来创建并且值相同，那么就会引用相同的对象。

![image-20230404163813639](E:\IdeaProject\JDK\notes\projectImg\image-20230404163813639.png) 

基本类型对应的缓冲池如下:

- boolean values true and false
- all byte values
- short values between -128 and 127
- int values between -128 and 127
- char in range \u0000 to \u007F

在使用这些基本类型对应的包装类型时，就可以直接使用缓冲池中的对象

如果在缓冲池之外：

![image-20230404164013149](E:\IdeaProject\JDK\notes\projectImg\image-20230404164013149.png) 

### String

#### 概览

String 被声明为 final，因此它不可被继承

内部使用 char 数组存储数据，该数组被声明为final，这意味着value数组初始化之后就不能再引用其他数组。并且 String 内部没有改变 value 数组的方法，因此可以保证 String 不可变

![image-20230404164432696](E:\IdeaProject\JDK\notes\projectImg\image-20230404164432696.png) 

#### 不可变的好处

1. 可以缓存hash值

   因为 String 的 Hash 值经常被使用，例如 String 用作 HashMap 的 key。不可变的特性可以使得 hash 值也不可便，因此只需要进行一次计算

2. String Pool的需要

   如果一个 String 对象已经被创建过了，那么就会从 String Pool 中取得引用，只有 String 是不可变的，才可能使用 String Pool。

   ![image-20230404164719998](E:\IdeaProject\JDK\notes\projectImg\image-20230404164719998.png) 

3. 安全性

   String 经常作为参数， String 不可变性可以保证参数不可变。例如在作为网络连接参数的情况下如果 String 是可变的，那么在网络连接过程中，String 被改变，改变 String对象的那一方以为现在连接的是其他主机，而实际情况却不一定是。

4. 线程安全

   String 不可变性天生具备线程安全，可以在多个线程中安全地使用

[Program Creek : Why String is immutable in Java?](https://www.programcreek.com/2013/04/why-string-is-immutable-in-java/)

#### String，StringBuffer and StringBuilder

1. 可变性
   - String 不可变
   - StringBuffer 和 StringBuilder 可变
2. 线程安全
   - String 不可变，因此是线程安全的
   - StringBuilder 不是线程安全的
   - StringBuffer 是线程安全的，内部使用 synchronized 进行同步

[StackOverflow : String, StringBuffer, and StringBuilder](https://stackoverflow.com/questions/2971315/string-stringbuffer-and-stringbuilder)

#### String.intern()

使用 String.intern() 可以保证相同内容的字符串变量引用同一的内存对象

下面示例中，s1和s2 采用 new String() 的方式新建了两个不同对象，而s3是通过s1.intern()方法取得一个对象引用。intern()首先把s1引用的对象放到 String Pool(字符串常量池)中，然后返回这个对象引用。因此s3和s1引用的是同一个字符串常量池的对象

![image-20230404175109939](E:\IdeaProject\JDK\notes\projectImg\image-20230404175109939.png) 

如果是采用 "bbb" 这种使用双引号的形式创建字符串实例，会自动地将新建的对象放入 String Pool 中。

![image-20230404175138346](E:\IdeaProject\JDK\notes\projectImg\image-20230404175138346.png) 

> **HotSpot中字符串常量池保存在哪里？永久代？方法区还是堆区？**
>
> 1. 运行时常量池（Runtime Constant Pool）是虚拟机规范中方法区的一部分，在加载类和结构到虚拟机后，就会创建对应的运行时常量池；而字符串常量池是这个过程中常量字符串的存放位置。所以这个角度，字符串常量池属于虚拟机规范中的方法区，它是一个逻辑上的概念；而堆区，永久代以及元空间是实际的存放位置
> 2. 不同的虚拟机对虚拟机的规范（比如方法区）是不一样的，只有HotSpot才有永久代的概念
> 3. HotSpot也是发展的，由于一些问题的存在，HotSpot考虑逐渐去永久代，对于不同版本的JDK，实际的存储位置是有差异的
>
> | JDK版本      | 是由有永久代，字符串常量池放在哪里？                         | 方法区逻辑上规范，由哪些实际的部分实现的？                   |
> | ------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
> | jdk1.6之前   | 有永久代，运行时常量池（包括字符串常量池），静态变量存放在永久代上 | 这个时期方法区在HotSpot中是由永久代来实现的，以至于这个时期说方法区就是指永久代 |
> | jdk1.7       | 有永久代，但已经逐步“去永久代”，字符串常量池、静态变量移除，保存在堆中 | 这个时期方法区在HotSpot中由永久代（类型信息、字段、方法、常量）和堆（字符串常量池、静态变量）共同实现 |
> | jdk1.8及之后 | 取消永久代，类型信息、字段、方法、常量保存在本地内存的元空间，但字符串常量池、静态变量仍在堆中 | 这个时期方法区在HotSpot中由本地内存                          |
>

### 运算

#### 参数传递

Java的参数是以值传递的形式传入方法中，而不是引用传递

以下代码中 Dog dog 的 dog 是一个指针，存储的是对象的地址。在将一个参数传入一个方法时，本质上是将对象的地址以值的方式传递到形参中。因此在方法中改变指针引用的对象，那么这两个指针此时指向的是完全不同的对象，一方改变其所指向对象的内容对另一方没有影响。

![image-20230413165337357](E:\IdeaProject\JDK\notes\projectImg\image-20230413165337357.png) ![image-20230413165346204](E:\IdeaProject\JDK\notes\projectImg\image-20230413165346204.png) 

但是如果在方法中改变对象的字段值会改变原对象该字段值，因为改变的是同一个地址指向的内容

![image-20230413165608273](E:\IdeaProject\JDK\notes\projectImg\image-20230413165608273.png) 

#### float与double

字面量属于double类型，不能直接将1.1直接赋值给float变量，因为这个向下转型。Java不能隐式执行向下转型，因为这会使得精度降低

```java
// float f = 1.1;
```

字面量才是float类型

```java
float f = 1.1f;
```

#### 隐式类型转换

因为字面1是int类型，它比short类型精度要高，因此不能隐式地将int类型向下转型为short类型

```java
short s1 = 1;
// s1 = s1 + 1
```

但是使用 += 运算符可以执行隐式类型转换

```java
s1 += 1
```

上面地语句相当于将s1+1地计算结果进行了向下转型

```java
s1 = (short)(s1 + 1)
```

#### switch

从Java 7 开始，可以在switch条件判断语句中使用String对象

```java
String s = "a";
switch (s) {
    case "a":
        System.out.println("aaa");
        break;
    case "b":
        System.out.println("bbb");
        break;
}
```

switch 不支持 long，是因为switch地设计初衷是对那些只有少数地几个值进行等值判断，如果值过于复杂，那么还是用if比较合适

```java
// long x = 111;
// switch (x) { // Incompatible types. Found: 'long', required: 'char, byte, short, int, Character, Byte, Short, Integer, String, or an enum'
//     case 111:
//         System.out.println(111);
//         break;
//     case 222:
//         System.out.println(222);
//         break;
// }
```

### 继承

#### 访问权限

Java 中有三个访问权限修饰符：private、protected以及public，如果不加访问修饰符，表示包级可见。

可以对类或类中地成员（字段以及方法）加上访问控制符。

- 类可见表示其他类可以用这个类创建实例对象
- 成员可见表示其他类可以用这个类地实例对象访问到该成员

protected 用于修饰成员，表示在继承体系中成员对于子类可见，但是这个访问修饰符对于类没有意义

设计良好地模块会隐藏所有地实现细节，把它地API与它地实现清晰地隔离开来。模块之间只通过它们地API进行通信，一个模块不需要知道其他模块的内部工作情况，这个概念被称为信息隐藏或封装。因此访问权限应当尽可能地使每个类或者成员不被外界访问

如果子类的方法重写了父类的方法，那么子类中该方法的访问级别不允许低于父类的访问级别。这是味蕾确保可以使用父类实例的地方都可以使用子类实例，也就是确保满足里氏替换原则

字段决不能是公有的，因为这么做的话就失去了对这个字段修改行为的控制，客户端可以对其随意修改。例如下面的例子中，AccessExample 用有 id  共有字段，如果在某个时刻，我们想要使用 int 去存储 id 字段，那么就需要去修改所有的客户端代码。

```java
public class AccessExample {
    public String id;
}
```

可以使用公有的 getter 和 setter 方法来替换公有字段，这样的话就可以控制对字段的修改行为。

```java
public class AccessExample {

    private int id;

    public String getId() {
        return id + "";
    }

    public void setId(String id) {
        this.id = Integer.valueOf(id);
    }
}
```

但是也有例外，如果是包级私有的类或者私有的嵌套类，那么直接暴露成员不会有特别大的影响。

```java
public class AccessWithInnerClassExample {
    private class InnerClass {
        int x;
    }

    private InnerClass innerClass;

    public AccessWithInnerClassExample() {
        innerClass = new InnerClass();
    }

    public int getValue() {
        return innerClass.x;  // 直接访问
    }
}
```

#### 抽象类与接口

1.抽象类

抽象类和抽象方法都使用abstract关键字进行声明。抽象类一般会包含抽象方法，抽象方法一定位于抽象类中

抽象类和普通类最大的区别是，抽象类不能被实例化，需要继承抽象类才能实例化其子类

```java
public abstract class AbstractClassExample {

    protected int x;
    private int y;

    public abstract void func1();

    public void func2() {
        System.out.println("func2");
    }
}
```

```java
public class AbstractExtendClassExample extends AbstractClassExample {
    @Override
    public void func1() {
        System.out.println("func1");
    }
}
```

```java
// AbstractClassExample ac1 = new AbstractClassExample(); // 'AbstractClassExample' is abstract; cannot be instantiated
AbstractClassExample ac2 = new AbstractExtendClassExample();
ac2.func1();
```

2.接口

接口是抽象类的延申，在Java 8之前，它可以看成是一个完全抽象的类，也就是说它不能有任何方法实现

从Java 8 开始，接口也可以拥有默认的方法实现，这事因为不支持默认方法的接口维护成本太高了。在Java 8 之前，如果一个接口想要添加新的方法，那么要修改所有实现了该接口的类

接口的成员（字段 + 方法）默认都是public的，并且不允许定义为private或者protected

接口的字段默认都是static和final的

```java
public interface InterfaceExample {
    void func1();

    default void func2(){
        System.out.println("func2");
    }

    int x = 123;
    // int y;               // Variable 'y' might not have been initialized
    public int z = 0;       // Modifier 'public' is redundant for interface fields
    // private int k = 0;   // Modifier 'private' not allowed here
    // protected int l = 0; // Modifier 'protected' not allowed here
    // private void fun3(); // Modifier 'private' not allowed here
}
```

```java
public class InterfaceImplementExample implements InterfaceExample {
    @Override
    public void func1() {
        System.out.println("func1");
    }
}
```

```java
// InterfaceExample ie1 = new InterfaceExample(); // 'InterfaceExample' is abstract; cannot be instantiated
InterfaceExample ie2 = new InterfaceImplementExample();
ie2.func1();
System.out.println(InterfaceExample.x);
```

3.比较

- 从设计层面上看，抽象类提供了一种IS-A关系，那么就必须满足里氏替换原则，即子类对象必须能够替换掉所有父类对象。而接口更像是一种LIKE-A关系，它只是提供一种方法实现契约，并不是要求接口和实现接口的类具有IS-A关系
- 从使用上来看，一个类可以实现多个接口，但是不能继承多个抽象类
- 接口的字段只能是static 和 final 类型的，而抽象类的字段没有这种限制
- 接口的成员只能是public的，而抽象类的成员可以有多种访问权限

> 抽象类是声明为抽象的类——它可能包含也可能不包含抽象方法。抽象类不能实例化，但可以子类化。抽象类可以具有静态字段和静态方法。当抽象类被子类化时，该子类通常为其父类中的所有抽象方法提供实现。但是，如果没有，则子类也必须声明为抽象的
>
> 以下情况适用抽象类：
>
> 1. 几个密切相关的类之间共享代码
> 2. 国战抽象类的类具有许多常用房和或字段，或者需要公共以外的访问修饰符（如受保护和私有）
> 3. 声明非静态或非最终字段。这使得能够定义可以访问和修改它们所属对象的状态的方法
>
> 
>
> 接口只是对象方法的声明；这不是实现。在接口中，我们定义对象可以执行的操作类型。这些操作由实现接口的类定义。接口在类和外部世界之间形成一个协定，这个协定在生成时由编译器强制执行
>
> 以下情况适用接口：
>
> 1. 不相关的类实现接口，例如Comparable和Cloneable有许多不相关的类实现
> 2. 指定特定数据类型的行为，但不关心谁实现其行为
> 3. 利用多个继承

#### super

- 访问父类的构造函数：可以使用super()函数访问父类的构造函数，从而委托父类完成一些初始化的工作
- 访问父类的成员：如果子类重写了父类的中某个方法的实现，可以通过使用super关键字来引用父类的方法的实现

```java
public class SuperExample {
    protected int x;
    protected int y;

    public SuperExample(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void func() {
        System.out.println("SuperExample.func()");
    }
}
```

```java
public class SuperExtendExample extends SuperExample {
    private int z;

    public SuperExtendExample(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public void func() {
        super.func();
        System.out.println("SuperExtendExample.func()");
    }
}
```

```java
SuperExample e = new SuperExtendExample(1, 2, 3);
e.func();
```

#### 重写与重载

1.重写（Override）

存在于继承体系中，指子类实现了一个与父类在方法声明上完全相同的一个方法

为了满足里氏替换原则，重写有以下两个限制

- 子类方法的访问权限必须大于等于父类方法
- 子类的方法的返回类型必须是父类方法返回类型或为其子类型

使用@Override 注解，可以让编译器帮忙检查是否满足上面的两个限制条件

2.重载（Overload）

存在于同一个类中，指一个方法与已经存在的方法名称上相同，但是参数类型、个数、顺序至少有一个不同

应该注意的是，返回值不同，其它都相同不算是重载
