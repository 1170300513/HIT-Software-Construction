package centralObject;

import static org.junit.Assert.*;

import org.junit.Test;

import centralObject.CentralObject;

public class Q3_ProtonTest {

	CentralObject p1 = CentralObject.Q3creator("Proton");
	CentralObject p2 = CentralObject.Q3creator("Proton");
	
	// Testing strategy:
	// ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�
	
	@Test
	public void testGetname() {
		String answer = "Proton";
		assertEquals(answer, p1.getname());
	}

	@Test
	public void testEqualsCentralObject() {
		assertEquals(true, p1.equals(p2));
	}

}
