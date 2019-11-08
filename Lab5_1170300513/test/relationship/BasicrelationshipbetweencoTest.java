package relationship;

import static org.junit.Assert.assertEquals;

import centralobject.CentralObject;
import org.junit.Test;
import physicalobject.PhysicalObject;

public class BasicrelationshipbetweencoTest {

  PhysicalObject physicalobject = PhysicalObject.electronicscreator();
  CentralObject centralObject = CentralObject.atomcreator("Na");

  // Testing strategy:
  // ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�


  @Test
  public void testGetc() {
    Basicrelationshipbetweenco<CentralObject, PhysicalObject> rel =
        new Basicrelationshipbetweenco<>(centralObject);
    assertEquals(centralObject, rel.getc());
  }

  @Test
  public void testGetrel() {
    Basicrelationshipbetweenco<CentralObject, PhysicalObject> rel =
        new Basicrelationshipbetweenco<>(centralObject);
    rel.addconnection(physicalobject, 0.2);
    assertEquals(physicalobject, rel.getrel().get(0).getobj());
  }

  @Test
  public void testAddconnection() {
    Basicrelationshipbetweenco<CentralObject, PhysicalObject> rel =
        new Basicrelationshipbetweenco<>(centralObject);
    rel.addconnection(physicalobject, 0.1);
    assertEquals(physicalobject, rel.getrel().get(0).getobj());
  }

}
