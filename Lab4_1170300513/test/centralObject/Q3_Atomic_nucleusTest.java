package centralObject;

import static org.junit.Assert.*;

import org.junit.Test;

import assist.number;

public class Q3_Atomic_nucleusTest {

	CentralObject nucleus = CentralObject.Q3creator("Na");
	CentralObject nucleus2 = CentralObject.Q3creator("Na");
	
	// Testing strategy:
	// ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�
	
	@Test
	public void testGetname() {
		String n = "Na";
		assertEquals(n, nucleus.getname());
	}


	@Test
	public void testEqualsCentralObject()
	{
		assertEquals(true, nucleus.equals(nucleus2));
	}

}
