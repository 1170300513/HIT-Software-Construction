package P3;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {

	// Testing strategy:
	// ����������ʵ��ִ��ÿ�д�����߸�����;
	// ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�
	
	public Board board = new Board();
	@Test
	public void testGetgoboard() {
		board.initializegoboard();
		assertEquals(2, board.getgoboard()[2][3].getpos().x);
		assertEquals(3, board.getgoboard()[2][3].getpos().y);
		assertEquals(true, board.getgoboard()[2][3].isempty);
	}

	@Test
	public void testGetchessboard() {
		board.initializechessboard();
		assertEquals(4, board.getchessboard()[4][3].getpos().x);
		assertEquals(3, board.getchessboard()[4][3].getpos().y);
		assertEquals(true, board.getchessboard()[4][3].isempty);
	}

}
