package centralobject;

import static org.junit.Assert.assertEquals;

import centralobject.CentralObject;
import org.junit.Test;


public class SunsTest {

  CentralObject sun = CentralObject.sunscreator("sun", 30, 40);
  CentralObject sun2 = CentralObject.sunscreator("sun", 30, 40);

  // Testing strategy:
  // ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�

  @Test
  public void testGetridus() {
    int a = 30;
    assertEquals(a, sun.getridus().intValue());
  }

  @Test
  public void testGetquality() {
    int b = 40;
    assertEquals(b, sun.getquality().intValue());
  }

  @Test
  public void testGetname() {
    String s = "sun";
    assertEquals(s, sun.getname());
  }

  @Test
  public void testEqualsCentralObject() {
    assertEquals(true, sun.equals(sun2));
  }

}
