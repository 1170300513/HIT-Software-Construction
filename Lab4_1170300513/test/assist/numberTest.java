package assist;

import static org.junit.Assert.*;

import org.junit.Test;

public class numberTest {

	
	// Testing strategy:
	// ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�
	
	@Test
	public void testIntValue() 
	{
		number num = new number("23");
		assertEquals(23, num.intValue());
	}

	@Test
	public void testDoubleValue() {

		number num = new number("2E7");
		double answer = 2.0E7;
		assertEquals(0, (int)(answer -num.doubleValue()));
	}

}
