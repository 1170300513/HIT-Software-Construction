package P3;

import java.util.*;

public class Person 
{
	final String name;
	public 	Person(String name) //在person类中的构造方法里对final前缀的name进行赋值（保证其不可被修改）。
	{
		 this.name = name;
	}
	List<Person> Edge = new ArrayList<>(); //定义一个数组以实现邻接表的数据结构。
	
}
