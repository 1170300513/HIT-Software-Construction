package centralObject;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q3_NeutronTest {

	CentralObject p1 = CentralObject.Q3creator("Neutron");
	CentralObject p2 = CentralObject.Q3creator("Neutron");
	
	// Testing strategy:
	// ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�
	
	@Test
	public void testGetname() {
		String answer = "Neutron";
		assertEquals(answer, p1.getname());
	}

	@Test
	public void testEqualsCentralObject() {
		assertEquals(true, p1.equals(p2));
	}

}
