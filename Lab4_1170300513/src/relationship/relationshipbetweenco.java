package relationship;
import java.util.*;




/**
 * mutable�Ŀɸ�����ӿ�relationshipbetweenco<L,E>�����ڱ�ʾ����ϵͳ�����ĵ�����͹������Ĺ�ϵ��
 * @author junbaba
 *
 * @param ����ϵͳ�����ĵ���������<L>
 * @param ������������<E>
 */
public interface relationshipbetweenco<L,E> 
{
	
	
	/**
	 * ����һ��ʵ��relationshipbetweenco�ӿڵĶ���ľ�̬��������
	 * @return ʵ�� relationshipbetweenco�ӿڵĶ���
	 */
	public static <L,E> relationshipbetweenco<L,E>  creator(L c , String choice)
	{
		if(choice.equals("Basics"))
		{
			return new Basicrelationshipbetweenco<L, E>(c);
		}
		else 
			throw new UnsupportedOperationException();
	}
	
	/**
	 * ���ع�ϵ�е����ĵ�����
	 * @return ���ĵ�����
	 */
	public L getc();
	
	/**
	 * ���������ĵ����������ϵ�Ĺ��������б�
	 * @return ��ϵ�б�
	 */
	public List<Socialtie<E>> getrel();
	
	/**
	 * ��������ĵ������ϵ�Ĺ������
	 * @param ��Ҫ�����ϵ�Ĺ������object
	 */
	public void addconnection(E object , Number intimacy);
}


