package relationship;

import static org.junit.Assert.*;

import org.junit.Test;

import centralObject.CentralObject;
import physicalObject.PhysicalObject;

public class BasicrelationshipbetweencoTest {

	PhysicalObject p = PhysicalObject.Q3creator();
	CentralObject centralObject = CentralObject.Q3creator("Na");
	
	// Testing strategy:
	// ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�
	
	
	@Test
	public void testGetc() {
		Basicrelationshipbetweenco<CentralObject, PhysicalObject> rel = new Basicrelationshipbetweenco<>(centralObject);
		assertEquals(centralObject, rel.getc());
	}

	@Test
	public void testGetrel() {
		Basicrelationshipbetweenco<CentralObject, PhysicalObject> rel = new Basicrelationshipbetweenco<>(centralObject);
		rel.addconnection(p, 0.2);
		assertEquals(p, rel.getrel().get(0).getobj());
	}

	@Test
	public void testAddconnection() {
		Basicrelationshipbetweenco<CentralObject, PhysicalObject> rel = new Basicrelationshipbetweenco<>(centralObject);
		rel.addconnection(p, 0.1);
		assertEquals(p, rel.getrel().get(0).getobj());
	}

}
