package relationship;

import static org.junit.Assert.*;

import org.junit.Test;

import physicalObject.PhysicalObject;

public class SocialtieTest {

	PhysicalObject p = PhysicalObject.Q3creator();
	Socialtie<PhysicalObject> s = new Socialtie<PhysicalObject>(p, 1);
	
	// Testing strategy:
	// ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�
	
	@Test
	public void testGetobj() {
		assertEquals(p, s.getobj());
	}

	@Test
	public void testGetIntimacy() {
		assertEquals(1, s.getIntimacy());
	}

}
