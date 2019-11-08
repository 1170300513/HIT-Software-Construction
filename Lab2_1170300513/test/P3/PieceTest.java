package P3;

import static org.junit.Assert.*;

import org.junit.Test;

public class PieceTest {
	// Testing strategy:
	// ����������ʵ��ִ��ÿ�д�����߸�����;
	// ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�
	
	Piece p = new Piece("White", "CJ");
	@Test
	public void testGettype() {
		String answer = "White";
		assertEquals(answer, p.gettype());
	}

	@Test
	public void testGetpos() {
		p.getpos().x = 1;
		p.getpos().y = 1;
		assertEquals(1, p.getpos().y);
		assertEquals(1, p.getpos().x);
	}

	@Test
	public void testGetbelongs() {
		String answer = "CJ";
		assertEquals(answer, p.getbelongs());
	}

	@Test
	public void testToString() {
		System.out.println(p);
		String answer = "White: (-1,-1)";
		assertEquals(answer, p.toString());
	}

}
