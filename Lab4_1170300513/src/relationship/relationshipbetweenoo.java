package relationship;

import java.util.*;


/**
 * mutable�Ŀɸ�����ӿ�relationshipbetweenoo<E>�����ڱ�ʾ����ϵͳ�й����������͹������Ĺ�ϵ��
 * @author junbaba
 *
 * @param ������������<E>
 */
public interface relationshipbetweenoo<E> 
{
	
	/**
	 * ����һ��ʵ��relationshipbetweenoo�ӿڵĶ���ľ�̬��������
	 * @return ʵ�� relationshipbetweenoo�ӿڵĶ���
	 */
	public static <E> relationshipbetweenoo<E>  creator(E object , String choice)
	{
		if(choice.equals("Basics"))
		{
			return new Basicrelationshipbetweenoo<E>(object);
		}
		else 
			throw new UnsupportedOperationException();
	}
	
	
	/**
	 * ���ظù������
	 * @return �������
	 */
	public E geto();
	
	
	/**
	 * ������ù�����������ϵ�Ĺ��������б�
	 * @return ���������б�
	 */
	public List<Socialtie<E>> getrel();
	
	
	/**
	 * �����ù�����������ϵ�Ĺ������
	 * @param ��Ҫ�����ϵ�Ĺ������newobejct
	 */
	public void addconnection(E newobejct , Number intimacy);
}




