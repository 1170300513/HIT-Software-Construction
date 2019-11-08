package centralObject;

import static org.junit.Assert.*;

import org.junit.Test;

import assist.number;

public class Q5_CentralUserTest {

	CentralObject user = CentralObject.Q5creator("CJ", "M", 20);
	CentralObject user2 = CentralObject.Q5creator("CJ", "M", 20);
	
	// Testing strategy:
	// ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�
	
	@Test
	public void testGetname() {
		String name = "CJ";
		assertEquals(name, user.getname());
	}

	@Test
	public void testGetsex() {
		String sex = "M";
		assertEquals(sex, user.getsex());
	}

	@Test
	public void testGetages() {
		int year = 20;
		assertEquals(year, user.getages().intValue());
	}
	
	@Test
	public void testEqualsCentralObject()
	{
		assertEquals(true, user.equals(user2));
	}

}
