package track;



/**
 * ʵ�ֽӿ�Track�ľ����࣬���ڱ�ʾ��Բ���
 * @author junbaba
 *
 */
public class OvalTrack implements Track {

	protected final Number a;
	protected final Number b;
	
	// Abstraction function:
    // a��Ӧ��Բ���ᣬb��Ӧ��Բ����.
	
	// Representation invariant:
	// a >= 0 , b>=0 , a > b
	
	
	// Safety from rep exposure:
	// ͨ��protectedʹ�������������޷���֪�����е�rep.
	
	
	// TODO checkRep
    public void checkRep()
    {
    	assert a.doubleValue() >= 0;
    	assert b.doubleValue() >= 0;
    	assert a.doubleValue() > b.doubleValue();
    }
	
    
	// TODO constructor
	public OvalTrack(Number a , Number b)
	{
		this.a = a;
		this.b = b;
	}
	
	@Override
	public boolean equals(Track obj) {
		if(this.a.doubleValue() == obj.geta().doubleValue() && this.b.doubleValue() == obj.getb().doubleValue())
			return true;
		return false;
	}

	@Override
	public Number getridus() 
	{
		Number c = (a.doubleValue() + b.doubleValue())/2;
		return c;
	}

	@Override
	public Number geta() {
		return a;
	}

	@Override
	public Number getb() {
		return b;
	}

}
