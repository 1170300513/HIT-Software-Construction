package P3;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	// Testing strategy:
	// ����������ʵ��ִ��ÿ�д�����߸�����;
	// ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�
	
	goGame go = new goGame();
	chessGame chess = new chessGame();
	@Test
	public void testInitializeThePlayer() 
	{
		go.InitializeThePlayer("CJ", "wyz");
		chess.InitializeThePlayer("CJ", "wyz");
	}

	@Test
	public void testDisplay() {
		go.InitializeThePlayer("CJ", "wyz");
		chess.InitializeThePlayer("CJ", "wyz");
		go.Initializeboard();
		chess.Initializeboard();
		go.display(0);
		chess.display(0);
	}

	@Test
	public void testInitializeboard() {
		go.InitializeThePlayer("CJ", "wyz");
		chess.InitializeThePlayer("CJ", "wyz");
		go.Initializeboard();
		chess.Initializeboard();
	}

}
