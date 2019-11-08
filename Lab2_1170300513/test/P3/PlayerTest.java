package P3;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {
	// Testing strategy:
	// ����������ʵ��ִ��ÿ�д�����߸�����;
	// ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�
	
	@Test
	public void testgoPlayer() {
		goPlayer player = new goPlayer("CJ");
		assertEquals("CJ", player.getname());
		player.initialize("White");
		assertEquals("CJ", player.getgoPicecs()[0].getbelongs());
		assertEquals("White", player.getgoPicecs()[1].gettype());
	}

	@Test
	public void testchessPlayer() 
	{
		ChessPlayer player = new ChessPlayer("CJ");
		assertEquals("CJ", player.getname());
		player.initialize("White");
		assertEquals("CJ", player.getchessPieces()[0].getbelongs());
		assertEquals("Pawn", player.getchessPieces()[0].gettype());
		player.initialize("Black");
		assertEquals("CJ", player.getchessPieces()[0].getbelongs());
		assertEquals("Pawn", player.getchessPieces()[0].gettype());
	}
}
