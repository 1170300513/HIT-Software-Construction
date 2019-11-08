package relationship;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import physicalobject.PhysicalObject;

public class SocialtieTest {

  PhysicalObject physicalObject = PhysicalObject.electronicscreator();
  Socialtie<PhysicalObject> socialtie = new Socialtie<PhysicalObject>(physicalObject, 1);

  // Testing strategy:
  // ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�

  @Test
  public void testGetobj() {
    assertEquals(physicalObject, socialtie.getobj());
  }

  @Test
  public void testGetIntimacy() {
    assertEquals(1, socialtie.getIntimacy());
  }

}
