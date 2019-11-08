package track;

public class RoundTrack implements Track
{
	// Abstraction function:
    // ridus��Ӧ����İ뾶.
	
	// Representation invariant:
	// ridus >= 0
	// objects != null
	
	// Safety from rep exposure:
	// ͨ��protectedʹ�������������޷���֪�����е�rep.
	
	protected final Number ridus;
	
	
	// TODO constructor
	public RoundTrack(Number ridus)
	{
		this.ridus = ridus;
	}
	
	// TODO checkRep
    public void checkRep()
    {
    	assert ridus.doubleValue() >= 0;
    }
	
    @Override
	public Number getridus()
	{
		return ridus;
	}

	@Override
	public boolean equals(Track obj) {
		if(this.ridus.doubleValue() == obj.getridus().doubleValue())
			return true;
		else
			return false;
	}
}
