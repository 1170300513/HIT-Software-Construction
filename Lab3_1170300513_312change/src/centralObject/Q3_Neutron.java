package centralObject;

public class Q3_Neutron implements CentralObject {

	
	private final String name = "Neutron";
	
	// Abstraction function:
	// name��Ӧ����
		
	// Representation invariant:
	// name != null
		
	// Safety from rep exposure:
	// ͨ��privateʹ���������޷���֪�����е�rep
		
		
		
	// TODO checkRep
	public void checkRep()
	{
		assert name != null;

	}
		
		
	// TODO constructor
	public Q3_Neutron()
	{
		
	}
	
	
	@Override
	public String getname() {
		return name;
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
	public String getsex() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Number getages() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean equals(CentralObject obj) {
		if(name.equals(obj.getname()))
			return true;
		return false;
	}
	
	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("<" + name + ">");
		return str.toString();
	}

}
