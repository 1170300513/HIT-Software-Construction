package P3;

import static org.junit.Assert.*;

import org.junit.Test;


public class ActionTest {

	// Testing strategy:
	// ����������ʵ��ִ��ÿ�д�����߸�����;
	// ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�
	
	Board board = new Board();
	@Test
	public void testgoAction() {
		goAction action = new goAction();
		goPlayer player = new goPlayer("CJ");
		player.initialize("White");
		board.initializegoboard();

		
		/*����showsituation������*/
		player.getgoPicecs()[5].getpos().x = 1; 
		player.getgoPicecs()[5].getpos().y = 1;
		action.showsituation(player);
		
		
		/*����place����*/
		//�������̵������
		assertEquals(false, action.place(player, player.getgoPicecs()[0], new Position(new Point(100,100))));
		
		//λ�����Ѿ������ӵ������
		Position p = new Position(new Point(3,3));
		p.isempty = false;
		assertEquals(false, action.place(player, player.getgoPicecs()[0], p)); 
		
		//�����Ѿ��������̵������
		player.getgoPicecs()[0].getpos().x = 1; 
		player.getgoPicecs()[0].getpos().y = 1;
		assertEquals(false, action.place(player, player.getgoPicecs()[0], board.getgoboard()[0][0]));
		
		//���Ӳ����ڸ�ѡ�ֵ������
		Piece piece = new Piece("1", "wyz");
		assertEquals(false, action.place(player, piece, board.getgoboard()[0][0]));
		
		//��ȷ�����
		assertEquals(true, action.place(player, player.getgoPicecs()[1], board.getgoboard()[1][1]));
		
		
		/*����remove������*/
		//��ȷ�����
		assertEquals(true, action.remove(player, board.getgoboard()[1][1]));
		
		//�������̵������
		Position extreme = new Position(new Point(100,100));
		extreme.reset(player.getgoPicecs()[6]);
		extreme.isempty = false;
		assertEquals(false, action.remove(player, extreme));
		
		//������û���ӵ������
		p.isempty = true;
		assertEquals(false, action.remove(player, p));
		
		//���Ӳ����ڸ���ҵ������
		p.isempty = false;
		p.reset(piece);
		assertEquals(false, action.remove(player, p)); 
		
	}
	
	@Test
	public void testchessAction() {
		chessAction action = new chessAction();
		ChessPlayer player1 = new ChessPlayer("CJ");
		player1.initialize("White");
		ChessPlayer player2 = new ChessPlayer("wyz");
		player2.initialize("Black");
		board.initializechessboard();
		
		/*����showsituation������*/
		action.showsituation(player1);
		
		
		/*����remove����*/
		//��ʼ�㳬�����̵������
		Position p = new Position(new Point(100,100));
		assertEquals(-1, action.move(player1, p, board.getchessboard()[0][0]));
		
		//Ŀ�ĵس������̵������
		assertEquals(-1, action.move(player1, board.getchessboard()[0][0], p));
		
		//�����غϵ������
		assertEquals(-1, action.move(player1, board.getchessboard()[0][0], board.getchessboard()[0][0]));
		
		//��ʼ���������ӵ������
		assertEquals(-1, action.move(player1, board.getchessboard()[0][0], board.getchessboard()[5][5]));
		
		//�����Ӱ������̡�
		int i; 
		for(i = 0 ; i < player1.getchessPieces().length ; i++)
		{
			int x = player1.getchessPieces()[i].getpos().x;
			int y = player1.getchessPieces()[i].getpos().y;
			board.getchessboard()[x][y].isempty = false;
			board.getchessboard()[x][y].reset(player1.getchessPieces()[i]);
		}
		for(i = 0 ; i < player2.getchessPieces().length ; i++)
		{
			int x = player2.getchessPieces()[i].getpos().x;
			int y = player2.getchessPieces()[i].getpos().y;
			board.getchessboard()[x][y].isempty = false;
			board.getchessboard()[x][y].reset(player2.getchessPieces()[i]);
		}
		
		//Ŀ�ĵ����м����ӵ������
		assertEquals(-1, action.move(player1, board.getchessboard()[0][0], board.getchessboard()[0][1]));
		
		//�ƶ��Ǽ����ӵ����
		assertEquals(-1, action.move(player1, board.getchessboard()[0][7], board.getchessboard()[3][3]));
		
		//���ӵ����
		assertEquals(1, action.move(player1, board.getchessboard()[0][0], board.getchessboard()[0][7]));
		
		//�������ƶ������
		assertEquals(0, action.move(player1, board.getchessboard()[0][1], board.getchessboard()[3][3]));
		
		
	}
}
