package relationship;

/**
 * ���ڸ�����ʾ��ϵimmutable����
 * @author junbaba
 *
 */
public class Socialtie<E> 
{
	protected final E object;
	protected final Number Intimacy;
	
	// Abstraction function:
	// object��Ӧ���壬Intimacy��Ӧ���ܶ�
	
	// Representation invariant:
	// object != null
	// Intimacy != null
	
	// Safety from rep exposure:
	// ͨ��protectedʹ�������������޷���֪�����е�rep,����get�������õ��ķ���ֵ����ֻ�ܲ鿴�޷��޸�.
	
	// TODO checkRep
	public void checkRep()
	{
	    assert object != null;
	    assert Intimacy != null;
	    	
	}
	
	// TODO constructor
	public Socialtie(E object , Number Intimacy)
	{
		this.object = object;
		this.Intimacy = Intimacy;
	}
	
	
	/**
	 * �ṩ��ʹ���ߵĵ�֪object�ķ���
	 * @return object
	 */
	public E getobj()
	{
		checkRep();
		return object;
	}
	
	
	/**
	 * �ṩ��ʹ���ߵ�֪���ܶ�Intimacy�ķ���
	 * @return ���ܶ�Intimacy
	 */
	public Number getIntimacy()
	{
		checkRep();
		return Intimacy;
	}
}
