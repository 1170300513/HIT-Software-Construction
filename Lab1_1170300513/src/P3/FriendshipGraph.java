package P3;

import java.util.*;

public class FriendshipGraph 
{
	List<Person> Vertex = new ArrayList<>();
	public static void main(String[] args)
	{
		FriendshipGraph graph = new FriendshipGraph();
		Person rachel = new Person("Rachel"); //�����ĸ��㲢Ϊ�������Ӧ�ı�
		Person ross = new Person("Ross");
		Person ben = new Person("Ben");
		Person kramer = new Person("Kramer");
		graph.addVertex(rachel);
		graph.addVertex(ross);
		graph.addVertex(ben);
		graph.addVertex(kramer);
		graph.addEdge(rachel, ross);
		graph.addEdge(ross, rachel);
		graph.addEdge(ross, ben);
		graph.addEdge(ben, ross);
		System.out.println(graph.getDistance(rachel, ross));  //���ʹ��getDistance�����õ��Ľ����
		System.out.println(graph.getDistance(rachel, ben)); 
		System.out.println(graph.getDistance(rachel, rachel)); 	
		System.out.println(graph.getDistance(rachel, kramer)); 

	}
	public void addVertex(Person p)
	{
		int i , flag = 1;
		for(i = 0; i < Vertex.size(); i++) //�жϵ㼯���Ƿ���������ˡ�
		{
			if(Vertex.get(i).name.equals(p.name))
				flag = 0;
		}
		if(flag == 1)
			Vertex.add(p);
		else
		{
			System.out.println("Name repetition!"); //����У������˳�����
			System.exit(0);
		}
		return;
	}
	public void addEdge(Person a , Person b)
	{
		int i = getindex(a.name);
		int j = getindex(b.name);
		if((i >= 0) && (j >= 0)) //�ж�a,b�Ƿ���Vertex�У��������Ӷ�Ӧ�ıߡ�
		{
			Person n = Vertex.get(i);
			n.Edge.add(b);
			Vertex.set(i, n);
		}
		if(i == -1) //������ھͱ����˳�����
		{
			System.out.println(a.name + " is not in the Vretex!");
			System.exit(0);
		}
		if(j == -1)
		{
			System.out.println(b.name + " is not in the Vretex!");
			System.exit(0);
		}
		return;
	}
	public int getDistance(Person a , Person b)
	{
		int n = Vertex.size();
		int mycounter = 0 , pre = 0 , last = 1 , mid = 1; //mycounter���ڼ�¼���롣
		Queue<Integer> queue = new LinkedList<>(); //�ö�����ʵ�����������̾���ķ��������ѣ���
		boolean[] visit = new boolean[n];
		int numa = getindex(a.name);
		int numb = getindex(b.name);
		queue.offer(numa);
		while(queue.peek() != null)
		{
			int i = queue.poll();
			int j;
			visit[i] = true;
			if(visit[numb] == true)
				break;
			pre++;
			Person p1 = Vertex.get(i);
			for(j = 0 ; j < p1.Edge.size();j++)
			{
				int m = getindex(p1.Edge.get(j).name);
				Person p2 = Vertex.get(m);
				if(visit[m] != true) 
				{
					queue.offer(m);
					last ++;
				}
			}
			if(pre == mid) //˵���Ѿ���������һ�㡣
			{
				mycounter++;
				mid = last;
			}	
		}
		if(visit[numb] == true)
			return mycounter;
		else
			return -1;
	}
	private int getindex(String name) /**��name����ӦѰ����ӦԪ���ڶ����е��±�  */
	{
		int i;
		for(i = 0 ; i < Vertex.size(); i++)
		{
			if(name.equals(Vertex.get(i).name))
				return i;
		}
		return -1;
	}
	private  boolean inEdge(Person a , Person b) /**�ж�a��b�Ƿ��б�*/
	{
		int i;
		for(i = 0 ; i < a.Edge.size() ; i++)
		{
			if(b.name.equals(a.Edge.get(i).name))
				return true;
		}
		return false;
	}
}
