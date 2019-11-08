package physicalobject;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import physicalobject.PhysicalObject;
import track.Track;

public class ElectronicsTest {

  PhysicalObject e1 = PhysicalObject.electronicscreator();
  PhysicalObject e2 = PhysicalObject.electronicscreator();

  // Testing strategy:
  // ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�

  @Test
  public void testGetname() {
    String name = "Electronics";
    assertEquals(name, e1.getname());
    Efactory fac = Efactory.getfactory();
    fac.gete(e1, Track.roundcreator(3));
  }

  @Test
  public void testEqualsPhysicalObject() {
    assertEquals(true, e1.equals(e1));
    assertEquals(false, e1.equals(e2));
  }
}
