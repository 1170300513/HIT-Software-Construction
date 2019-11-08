package relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * һ��relationshipbetweenco�ľ���ʵ��
 * 
 * @author junbaba
 *
 */
public class Basicrelationshipbetweenco<L,E> implements relationshipbetweenco<L, E>
{
	protected final L c;
	protected final List<Socialtie<E>> contacts = new ArrayList<>();
	
	// Abstraction function:
	// c��Ӧ���ĵ����壬contacts�б���ÿһ��Ԫ�ض�Ӧ�����ĵ����������ϵ��һ���������
	
	// Representation invariant:
	// contacts != null
	
	// Safety from rep exposure:
	// ͨ��protectedʹ�������������޷���֪�����е�rep,����get�������õ��ķ���ֵ����ֻ�ܲ鿴�޷��޸�.
	
	// TODO constructor
	public Basicrelationshipbetweenco(L c) 
	{
		this.c = c;
	}
	
	// TODO checkRep
	public void checkRep()
    {
    	assert contacts != null;
    	
    }
	
	@Override
	public L getc()
	{
		return c;
	}
	
	
	@Override
	public List<Socialtie<E>> getrel()
	{
		return contacts;
	}
	
	
	@Override
	public void addconnection(E object , Number intimacy)
	{
		Socialtie<E> s = new Socialtie<E>(object, intimacy);
		contacts.add(s);
		checkRep();
	}
}
