package assist;

import static org.junit.Assert.assertEquals;

import centralobject.CentralObject;
import circularorbit.CircularOrbit;
import exceptions.TheSameTagRException;
import org.junit.Test;
import physicalobject.PhysicalObject;
import track.Track;


public class DifferenceTest {
  CircularOrbit<CentralObject, PhysicalObject> c1 = CircularOrbit.empty("Q3");
  CircularOrbit<CentralObject, PhysicalObject> c2 = CircularOrbit.empty("Q3");
  Track t1 = Track.roundcreator(1);
  Track t2 = Track.roundcreator(2);
  Track t3 = Track.roundcreator(3);
  PhysicalObject p1 = PhysicalObject.electronicscreator();
  PhysicalObject p2 = PhysicalObject.electronicscreator();
  PhysicalObject p3 = PhysicalObject.electronicscreator();
  // Testing strategy:
  // ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�

  @Test
  public void testToString() throws TheSameTagRException {
    c1.addorbit(t1);
    c1.addorbit(t2);
    c2.addorbit(t3);
    c1.addtoorbit(p1, t1);
    c1.addtoorbit(p2, t1);
    c2.addtoorbit(p3, t3);
    Difference<PhysicalObject> difference = new Difference<>(c1.getorbits(), c2.getorbits());
    String answer = "���������:1\n" + "���1��������������:1; �������:��\n";
    assertEquals(answer, difference.toString());


  }

}
