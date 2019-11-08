package centralObject;



/**
 * һ��CentralObject�ӿڵľ���ʵ�֣�����SocialNetworkCircle��
 * @author junbaba
 *
 */
public class Q5_CentralUser implements CentralObject 
{
	
	private final String sex;
	private final String name;
	private final Number ages;
	
	// Abstraction function:
	// sex��Ӧ�Ա�name��Ӧ���֣�ages��Ӧ���䡣
		
	// Representation invariant:
	// sex != null
	// name != null
	// ages > 0
		
	// Safety from rep exposure:
	// ͨ��privateʹ���������޷���֪�����е�rep
		
	// TODO checkRep
	 public void checkRep()
	 {
	    assert name != null;
	    assert sex != null;
	    assert ages.intValue() > 0;

	 }
		
		
	// TODO constructor
	public Q5_CentralUser(String name , String sex , Number ages)
	{
		this.name = name;
		this.sex = sex;
		this.ages = ages;
	}
	
	@Override
	public String getname() 
	{
		return name;
	}
	
	@Override
	public String getsex()
	{
		return sex;
	}
	
	@Override
	public Number getages()
	{
		return ages;
	}




	@Override
	public Number getridus() {
		throw new UnsupportedOperationException();
	}


	@Override
	public Number getquality() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean equals(CentralObject obj) {
		if(this.ages.intValue() == obj.getages().intValue() && this.sex.equals(obj.getsex()) && this.name.equals(obj.getname()))
			return true;
		else
			return false;
	}
	
	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("<" + name + ": " + sex + "," + ages + "years>");
		return str.toString();
	}
}
