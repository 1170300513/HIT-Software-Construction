package centralobject;

import static org.junit.Assert.assertEquals;

import centralobject.CentralObject;
import org.junit.Test;


public class AtomicnucleusTest {

  CentralObject nucleus = CentralObject.atomcreator("Na");
  CentralObject nucleus2 = CentralObject.atomcreator("Na");

  // Testing strategy:
  // ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�

  @Test
  public void testGetname() {
    String n = "Na";
    assertEquals(n, nucleus.getname());
  }


  @Test
  public void testEqualsCentralObject() {
    assertEquals(true, nucleus.equals(nucleus2));
  }

}
