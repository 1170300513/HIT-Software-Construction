package P2;

import java.util.*;
import P1.graph.*;

public class FriendshipGraph 
{
 ConcreteEdgesGraph<String> g = new ConcreteEdgesGraph<>();

    // Abstraction function:
    // g��Ӧ��Ӧ��ʫ������ͼ��
    
    // Representation invariant: 
    // g != null
    
   
	
	// TODO checkRep
	public void checkRep()
    {
    	assert g != null;
    }
	
	/**�ͻ���main��
	 * 
	 * @param args
	 */
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
	
	/**��ӵ㡣
	 * 
	 * @param ��Ҫ��ӵ�Person���p��
	 */
	public void addVertex(Person p)
	{
		if(!g.add(p.name)) //���жϹ����о��ѽ�������ӡ�
		{
			System.out.println("Name repetition!"); //������ظ��������˳�����
			System.exit(0);
		}
	}
	
	/**��ӱߡ�
	 * 
	 * @param ��ʼ��Person��a��
	 * @param ��ֹ��Person��b��
	 */
	public void addEdge(Person a , Person b)
	{
		if(g.set(a.name, b.name, 1) == -1) //���жϹ����о��Ѿ���������ӡ�
		{
			System.out.println(a.name + " or "+ b.name + " is not in the Vretex!"); //���a��b���ڵ㼯�оͱ����˳�����
			System.exit(0);
		}
	}
	
	/**Ѱ��Person��a��Person��b�����̾��롣
	 * 
	 * @param ��ʼ��Person��a��
	 * @param ��ֹ��Person��b��
	 * @return Person��a��Person��b�����̾��롣
	 */
	public int getDistance(Person a , Person b)
	{
		int mycounter = 0 , pre = 0 , last = 1 , mid = 1; 
		List<String> mylist = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visit = new boolean[g.vertices().size()];
		for(String p : g.vertices())
		{
			mylist.add(p); //�������еĵ�ŵ�List�У����ڲ�������
		}
		int anum = find(a.name, mylist);
		int bnum = find(b.name, mylist);
		if((bnum == -1) || (anum == -1)) //���a��b���ڵ㼯�оͱ����˳�����
		{
			System.out.println(a.name + " or "+ b.name + " is not in the Vretex!"); 
			System.exit(0);
		}
		queue.offer(anum);
		//�����������¼��̾��롣
		while(queue.peek() != null)
		{
			int i = queue.poll();
			visit[i] = true;
			if(visit[bnum] == true)
				break;
			pre++;
			String p = mylist.get(i);
			for(String per : g.targets(p).keySet())
			{
				int m = find(per, mylist);
				if(visit[m] != true)
				{
					queue.offer(m);
					last ++;
				}
			}
			if(pre == mid)
			{
				mid = last;
				mycounter++;
			}
		}
		if(visit[bnum] == true)
			return mycounter;
		else
			return -1;
	}
	
	/**Ѱ��List���Ƿ����P,��������������±꣬���򷵻�-1.
	 * 
	 * @param Person������p
	 * @param �����б�mylist
	 * @return p���б��е��±�i������������򷵻�-1.
	 */
	public int find(String p , List<String> mylist)
	{
		int i;
		for(i = 0 ; i < mylist.size() ; i++)
		{
			if(p.equals(mylist.get(i)))
				return i;
		}
		return -1;
	}
	
	

}
