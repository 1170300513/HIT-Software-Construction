package APIs;


import circularOrbit.CircularOrbit;



import java.lang.Math;




import assist.Difference;



public class CircularOrbitAPIs<L,E>
{

	/**
	 * �������ϵͳ�и����������ֲ�����ֵ
	 * @param ����ϵͳc
	 * @return ����ϵͳ�и����������ֲ�����ֵ
	 */
	public  double getObjectDistributionEntropy(CircularOrbit<L,E> c)
	{
		double entropy = 0;
		int i , j;
		for(i = 0 ; i < c.getorbits().size() ; i++)
		{
			
			if(c.getorbits().get(i).getthingsintrack().size() > 0)
			{
				double p = (double)1 / c.getorbits().get(i).getthingsintrack().size();
				for(j = 0 ; j < c.getorbits().get(i).getthingsintrack().size() ; j++)
				{
					entropy += p*Math.log(p);
				}
			}
		}
		return entropy;
	}
	
	
	/**
	 * ����������������֮�������߼����롣
	 * @param ����ϵͳc
	 * @param �������e1
	 * @param �������e2
	 * @return e1��e2֮�������߼�����
	 */
	public int getLogicalDistance (CircularOrbit<L,E> c, E e1, E e2)
	{
		return c.getlogicdistance(e1, e2);
	}
	
	
	/**
	 * ����������������֮����������
	 * @param ����ϵͳc
	 * @param �������e1
	 * @param �������e2
	 * @return e1��e2֮����������
	 */
	public double getPhysicalDistance (CircularOrbit<L,E> c, E e1, E e2)
	{
		return c.getphysicaldistance(e1, e2);
	}
	
	/**
	 * ������������ϵͳ֮��Ĳ���
	 * @param ����ϵͳc1
	 * @param ����ϵͳc2
	 * @return ��ʾ�������ϵͳ�����Different��
	 */
	public Difference<E> getDifference (CircularOrbit<L,E> c1, CircularOrbit<L,E> c2)
	{
		return new Difference<E>(c1.getorbits(), c2.getorbits());
	}
	
	
	
	
}



