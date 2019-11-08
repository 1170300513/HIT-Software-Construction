package apis;

import static org.junit.Assert.assertEquals;

import apis.CircularOrbitApis;
import centralobject.CentralObject;
import circularorbit.CircularOrbit;
import org.junit.Test;
import physicalobject.PhysicalObject;

public class CircularOrbitApisTest {

  CircularOrbit<CentralObject, PhysicalObject> cir = CircularOrbit.empty("Q3");
  CircularOrbitApis<CentralObject, PhysicalObject> api = new CircularOrbitApis<>();

  // Testing strategy:
  // ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�

  @Test
  public void testGetObjectDistributionEntropy() {

    try {
      cir.readfile("test AtomicStructure.txt", 3);
    } catch (Exception e) {
      e.printStackTrace();
    }
    double answer = -7.742402021815782;
    assertEquals(0, (int) (answer - api.getObjectDistributionEntropy(cir)));
  }

  @Test
  public void testGetLogicalDistance() {
    try {
      cir.readfile("test AtomicStructure.txt", 3);
    } catch (Exception e) {
      e.printStackTrace();
    }
    PhysicalObject e1 = cir.getorbits().get(0).getthingsintrack().get(0);
    PhysicalObject e2 = cir.getorbits().get(1).getthingsintrack().get(0);
    assertEquals(-1, api.getLogicalDistance(cir, e1, e2));
  }

  @Test
  public void testGetPhysicalDistance() {
    try {
      cir.readfile("test AtomicStructure.txt", 3);
    } catch (Exception e) {
      e.printStackTrace();
    }
    PhysicalObject e1 = cir.getorbits().get(0).getthingsintrack().get(0);
    PhysicalObject e2 = cir.getorbits().get(1).getthingsintrack().get(0);
    assertEquals(-1, (int) api.getPhysicalDistance(cir, e1, e2));
  }

  @Test
  public void testGetDifference() {
    CircularOrbit<CentralObject, PhysicalObject> cir2 = CircularOrbit.empty("Q3");
    try {
      cir.readfile("test AtomicStructure.txt", 3);
      cir2.readfile("test AtomicStructure.txt", 3);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println(api.getDifference(cir, cir2));
    String answer1 = "���������:0\n" + "���1��������������:0; �������:��\n";
    String answerm = "���2��������������:0; �������:��\n" + "���3��������������:0; �������:��\n";
    String answer2 = "���4��������������:0; �������:��\n" + "���5��������������:0; �������:��\n";
    String answer = answer1 + answerm + answer2;
    assertEquals(answer, api.getDifference(cir, cir2).toString());
  }

}
