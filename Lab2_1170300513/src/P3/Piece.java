package P3;

public class Piece {
	private final String type;
	private final String belongs;
	private  Point pos = new Point(-1 , -1); //����δ��������ʱ��������ͳһ��Ϊ(-1,-1)
	
	// Abstraction function:
    // type��Ӧ�������ͣ�belong��Ӧ����������ѡ�֡�
    
    // Representation invariant:
    // type != null
	// belongs != null
	// belongs��Ӧ��ѡ�ֱ�����ڡ�
	
	// Safety from rep exposure:
    // Use private to prevent the parameter from exposure.
	
	// TODO checkRep
	public void checkRep()
	{
		assert type != null;
		assert belongs != null;
	}
	
	Piece(String type , String belongs)
	{
		this.type = type;
		this.belongs = belongs;
		checkRep();
	}
	public  String  gettype()
	{
		return type;
	}
	
	public Point getpos() 
	{
		return pos;
	}
	
	public String getbelongs() 
	{
		return belongs;
	}
	

	 @Override public String toString()
	 {
		 StringBuilder str = new StringBuilder();
		 str.append(type + ": ");
		 str.append(pos.toString());
		 return str.toString();
	 }
	
}

/**�����࣬���ڱ�ʾ������ĵ�
 * 
 */
class Point{
	int x;
	int y;
	Point(int x , int y)
	{
		this.x = x;
		this.y = y;
	}
	@Override public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("(" + x + "," + y + ")");
		return str.toString();
	}
}