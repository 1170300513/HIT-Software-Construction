package P3;

public class Player 
{
	private final String name;
	
	// Abstraction function:
    // name��Ӧѡ������
    
    // Representation invariant:
    // name != null
	
	// Safety from rep exposure:
    // Use private to prevent the parameter from exposure.
	
	// TODO checkRep
	public void checkRep()
	{
		assert name != null;	
	}
			
	public Player(String name) 
	{
		this.name = name;
	}
	
	/**�õ�ѡ������
	 * 
	 * @return
	 */
	public String getname() 
	{
		return name;
	}
}

class ChessPlayer extends Player
{
	private final Piece[] chessPieces = new Piece[16];
	
	// Abstraction function:
    // ����chessPieces�е�ÿ��Ԫ�ض�Ӧ��ѡ�ֵ����ӡ�
    
    // Representation invariant:
    // chessPieces != null
	// chessPieces�е�Piece��belongs������Player��nameһ�¡�
	
	// Safety from rep exposure:
    // Use private to prevent the parameter from exposure.
	
	@Override
	public void checkRep() {
		
		super.checkRep();
		assert chessPieces != null;
	}
	
	public ChessPlayer(String name) 
	{
		super(name);
	}
	
	/**��ʼ��ѡ�ֵ���������
	 * 
	 * @param ����������type
	 */
	public void initialize(String type) 
	{
		int i;
		//�Ա����г�ʼ����
		if(type.equals("White"))
		{
			for(i = 0 ; i <= 7 ; i++)
			{
				Piece temp = new Piece("Pawn", super.getname());
				temp.getpos().x = i;
				temp.getpos().y = 1;
				chessPieces[i] = temp;
			}
		
			//�Գ����г�ʼ����
			Piece temp = new Piece("Rook", super.getname());
			temp.getpos().x = 0;
			temp.getpos().y = 0;
			chessPieces[8] = temp;
			temp = new Piece("Rook", super.getname());
			temp.getpos().x = 7;
			temp.getpos().y = 0;
			chessPieces[9] = temp;
		
			//������г�ʼ����
			temp = new Piece("Knight", super.getname());
			temp.getpos().x = 1;
			temp.getpos().y = 0;
			chessPieces[10] = temp;
			temp = new Piece("Knight", super.getname());
			temp.getpos().x = 6;
			temp.getpos().y = 0;
			chessPieces[11] = temp;
		
			//������г�ʼ����
			temp = new Piece("Bishop", super.getname());
			temp.getpos().x = 2;
			temp.getpos().y = 0;
			chessPieces[12] = temp;
			temp = new Piece("Bishop", super.getname());
			temp.getpos().x = 5; 
			temp.getpos().y = 0;
			chessPieces[13] = temp;
		
			//��������г�ʼ����
			temp = new Piece("Queen", super.getname());
			temp.getpos().x = 3;
			temp.getpos().y = 0;
			chessPieces[14] = temp;
			
			//�������г�ʼ����
			temp = new Piece("King", super.getname());
			temp.getpos().x = 4;
			temp.getpos().y = 0;
			chessPieces[15] = temp;
		
		}
		
		else if(type.equals("Black"))
		{
			for(i = 0 ; i <= 7 ; i++)
			{
				Piece temp = new Piece("Pawn", super.getname());
				temp.getpos().x = i;
				temp.getpos().y = 6;
				chessPieces[i] = temp;
			}
		
			//�Գ����г�ʼ����
			Piece temp = new Piece("Rook", super.getname());
			temp.getpos().x = 0;
			temp.getpos().y = 7;
			chessPieces[8] = temp;
			temp = new Piece("Rook", super.getname());
			temp.getpos().x = 7;
			temp.getpos().y = 7;
			chessPieces[9] = temp;
		
			//������г�ʼ����
			temp = new Piece("Knight", super.getname());
			temp.getpos().x = 1;
			temp.getpos().y = 7;
			chessPieces[10] = temp;
			temp = new Piece("Knight", super.getname());
			temp.getpos().x = 6;
			temp.getpos().y = 7;
			chessPieces[11] = temp;
		
			//������г�ʼ����
			temp = new Piece("Bishop", super.getname());
			temp.getpos().x = 2;
			temp.getpos().y = 7;
			chessPieces[12] = temp;
			temp = new Piece("Bishop", super.getname());
			temp.getpos().x = 5;
			temp.getpos().y = 7;
			chessPieces[13] = temp;
		
			//��������г�ʼ����
			temp = new Piece("Queen", super.getname());
			temp.getpos().x = 3;
			temp.getpos().y = 7;
			chessPieces[14] = temp;
			
			//�������г�ʼ����
			temp = new Piece("King", super.getname());
			temp.getpos().x = 4;
			temp.getpos().y = 7;
			chessPieces[15] = temp;
		}
		checkRep();
	}
	
	public Piece[] getchessPieces()
	{
		return chessPieces;
	}
	
}

class goPlayer extends Player
{

	private final Piece[] goPieces = new Piece[361];
	
	// Abstraction function:
    // ����goPieces�е�ÿ��Ԫ�ض�Ӧ��ѡ�ֵ����ӡ�
    
    // Representation invariant:
    // goPieces != null
	// goPieces�е�Piece��belongs������Player��nameһ�¡�
	
	// Safety from rep exposure:
    // Use private to prevent the parameter from exposure.
	
	@Override
	public void checkRep() {
		
		super.checkRep();
		assert goPieces != null;
	}
	
	public goPlayer(String name) 
	{
		super(name); 
		
	}
	
	/**��ʼ����ѡ�ֵ�Χ������
	 * 
	 * @param ���Ӻڰ�type
	 */
	public void initialize(String type)
	{
		int i;
		for(i = 0 ; i < 361 ; i++)
		{
			goPieces[i] = new Piece(type ,super.getname());
		}
		checkRep();
	}
	
	public Piece[] getgoPicecs()
	{
		return goPieces;
	}
	

}