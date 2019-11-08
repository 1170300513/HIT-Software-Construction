package assist;

import java.util.*;

import physicalObject.PhysicalObject;
import thinginTrack.ThinginTrack;

/**
 *  һ�����ڱ�ʾ�������ϵͳ�������
 * @author junbaba
 *
 * @param <E>
 */
public class Difference<E> 
{
	private final int orbitnumdif;
	private final List<orbitdifference<E>> orbitdifferences = new ArrayList<>();
	// Abstraction function:
	// orbitnumdif��Ӧ�����Ŀ���죬orbitdifferences��ÿһ��Ԫ�ض�Ӧ��i��������������
	
	// Representation invariant:
	// orbitdifferences != null
	
	
	// Safety from rep exposure:
	// ͨ��privateʹ���������޷���֪�����е�rep
	
	// TODO checkRep
	public void checkRep()
	{
		assert orbitdifferences != null;
	}
		
	// TODO constructor
	public Difference(List<ThinginTrack<E>> c1 , List<ThinginTrack<E>> c2) 
	{
		int i , min = c1.size();
		orbitnumdif = c1.size() - c2.size();
		if(c1.size() > c2.size())
			min = c2.size();
		for(i = 0 ; i < min ; i++)
		{
			orbitdifferences.add(new orbitdifference<E>(i+1, c1.get(i).getthingsintrack(), c2.get(i).getthingsintrack()));
		}
		checkRep();
	}
	
	
	
	public int getorbitnumdifference()
	{
		return orbitnumdif;
	}
	
	
	
	public List<orbitdifference<E>> getorbitdifferences()
	{
		return List.copyOf(orbitdifferences);
	}
	
	
	@Override
	public String toString() 
	{
		int i;
		StringBuilder str = new StringBuilder();
		str.append("���������:" + orbitnumdif + "\n");
		for(i = 0 ; i < orbitdifferences.size() ; i++)
		{
			str.append(orbitdifferences.get(i).toString() + "\n");		
		}
		return str.toString();
	}
}

/**
 *  �����࣬���ڸ���Difference���ʾ
 * @author junbaba
 *
 * @param <E>
 */
class orbitdifference<E>
{
	private final int orbitnum;
	private final int thingnumdif;
	private final List<E> orbitunique1 = new ArrayList<>();
	private final List<E> orbitunique2 = new ArrayList<>();
	
	
	// Abstraction function:
	// orbitnum��Ӧ���������thingnumdif��Ӧ��������������orbitunique1��Ӧ�����ڹ��һ�����壬oebiunique2��Ӧ�����ڹ����������
	
	// Representation invariant:
	// orbitnum > 0
	// orbitunique1 != null
	// orbitunique2 != null
	
	
	// Safety from rep exposure:
	// ͨ��privateʹ���������޷���֪�����е�rep
	
	// TODO checkRep
	public void checkRep()
	{
		assert orbitunique1 != null;
		assert orbitunique2 != null;
		assert orbitnum > 0;
	}
			
	// TODO constructor
	public orbitdifference(int n , List<E> o1 , List<E> o2 ) 
	{
		orbitnum = n;
		thingnumdif = o1.size() - o2.size();
		int flag = 0;
		for(E thingin1 : o1)
		{
			PhysicalObject thingino1 = (PhysicalObject) thingin1;
			for(E thingin2 : o2)
			{
				PhysicalObject thingino2 = (PhysicalObject) thingin2;
				if(thingino2.equals(thingino1))
					flag = 1;
			}
			if(flag == 0)
				orbitunique1.add(thingin1);
			flag = 0;
		}
		for(E thingin2 : o2)
		{
			PhysicalObject thingino2 = (PhysicalObject) thingin2;
			for(E thingin1 : o1)
			{
				PhysicalObject thingino1 = (PhysicalObject) thingin1;
				if(thingino1.equals(thingino2))
					flag = 1;
			}
			if(flag == 0)
				orbitunique2.add(thingin2);
			flag = 0;
		}
		checkRep();
	}
	
	
	public int getorbitnum()
	{
		return orbitnum;
	}
	
	
	public int getthingnumdif()
	{
		return thingnumdif;
	}
	
	
	public List<E> getorbitunique1()
	{
		return List.copyOf(orbitunique1);
	}
	
	public List<E> getorbitunique2()
	{
		return List.copyOf(orbitunique2);
	}
	
	
	
	@Override
	public String toString() 
	{
		int i;
		StringBuilder str = new StringBuilder();
		str.append("���" + orbitnum + "��������������:" + thingnumdif );
		str.append("; �������:");
		PhysicalObject p = null;
		if(orbitunique1.size() != 0)
		{
			p = (PhysicalObject)orbitunique1.get(0); 
		}
		if(orbitunique2.size() != 0)
		{
			p = (PhysicalObject)orbitunique2.get(0);
		}
		if((orbitunique1.size() != 0 || orbitunique2.size() != 0) && !p.getname().equals("Electronics"))
		{
			str.append("{");
			for(i = 0 ; i < orbitunique1.size() ; i++)
			{
				if(i == orbitunique1.size() - 1)
					str.append(orbitunique1.get(i).toString());
				else
					str.append( orbitunique1.get(i).toString() + ",");
			}
			str.append("}-");
			str.append("{");
			for(i = 0 ; i < orbitunique2.size() ; i++)
			{
				if(i == orbitunique2.size() - 1)
					str.append(orbitunique2.get(i).toString());
				else
					str.append( orbitunique2.get(i).toString() + ",");
			}
			str.append("}");
		}
		else
		{
			str.append("��");
		}
		return str.toString();
	}
}