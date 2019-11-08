package relationship;

import static org.junit.Assert.*;

import org.junit.Test;

import physicalObject.PhysicalObject;

public class BasicrelationshipbetweenooTest {

	PhysicalObject p1 = PhysicalObject.Q3creator();
	PhysicalObject p2 = PhysicalObject.Q3creator();
	
	// Testing strategy:
	// ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�
	
	
	@Test
	public void testGeto() {
		Basicrelationshipbetweenoo<PhysicalObject> rel = new Basicrelationshipbetweenoo<PhysicalObject>(p1);
		assertEquals(p1, rel.geto());
	}

	@Test
	public void testGetrel() {
		Basicrelationshipbetweenoo<PhysicalObject> rel = new Basicrelationshipbetweenoo<PhysicalObject>(p1);
		rel.addconnection(p2, 0.1);
		assertEquals(p2, rel.getrel().get(0).getobj());
	}

	@Test
	public void testAddconnection() {
		Basicrelationshipbetweenoo<PhysicalObject> rel = new Basicrelationshipbetweenoo<PhysicalObject>(p1);
		rel.addconnection(p2, 0.2);
		assertEquals(p2, rel.getrel().get(0).getobj());
	}

}
