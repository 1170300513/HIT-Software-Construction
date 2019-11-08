package P3;

public class Board 
{
	private final Position[][] goboard = new Position[19][19];
	private final Position[][] chessboard = new Position[8][8];
	
	// Abstraction function:
    // goboard��ӦΧ�����̣�chessboard��Ӧ�������̡�
    
    // Representation invariant:
    // goboard != null
	// chessboard != null
	// �����ϵ�position����ӦΪ������
	
	// Safety from rep exposure:
    // Use private to prevent the parameter from exposure.
	
	// TODO checkRep
		public void checkRep()
		{
			assert goboard != null;
			assert chessboard != null;
		}
	
	/**��ʼ��Χ������
	 * 
	 */
	public  void initializegoboard() 
	{
		int i , j;
		for(i = 0 ; i < 19 ; i++)
		{
			for(j = 0 ; j < 19 ; j++)
			{
				goboard[i][j] = new Position(new Point(i,j));
			}
		}
		checkRep();

	}
	
	
	/**��ʼ����������
	 * 
	 */
	public  void initializechessboard()
	{
		int i, j;
		for(i = 0 ; i < 8 ; i++)
		{
			for(j = 0 ; j < 8 ; j++)
			{
				chessboard[i][j] = new Position(new Point(i,j));
			}
		}
		checkRep();
	}
	
	
	/**���ָ��Χ�����̵�����
	 * 
	 * @return ָ��Χ�����̵�����goboard
	 */
	public Position[][] getgoboard()
	{
		return goboard;
	}
	
	
	
	
	/**���ָ���������̵�����
	 * 
	 * @return ָ���������̵�����chessboard
	 */
	public Position[][] getchessboard() 
	{
		return chessboard;
	}
	
}
