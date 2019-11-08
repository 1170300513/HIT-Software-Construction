package physicalObject;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q3_ElectronicsTest {

	PhysicalObject e1 = PhysicalObject.Q3creator();
	PhysicalObject e2 = PhysicalObject.Q3creator();
	
	// Testing strategy:
	// ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�
	
	@Test
	public void testGetname() {
		String name = "Electronics";
		assertEquals(name, e1.getname());
	}

	@Test
	public void testEqualsPhysicalObject() {
		assertEquals(true, e1.equals(e1));
		assertEquals(false, e1.equals(e2));
	}
}
