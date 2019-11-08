package physicalobject;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import physicalobject.PhysicalObject;

public class FriendTest {

  PhysicalObject friend = PhysicalObject.friendcreator("CJ", "M", 20);
  PhysicalObject friend2 = PhysicalObject.friendcreator("CJ", "M", 20);

  // Testing strategy:
  // ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�

  @Test
  public void testGetname() {
    String name = "CJ";
    assertEquals(name, friend.getname());
  }

  @Test
  public void testGetsex() {
    String sexString = "M";
    assertEquals(sexString, friend.getsex());
  }

  @Test
  public void testGetages() {
    int year = 20;
    assertEquals(year, friend.getages().intValue());
  }

  @Test
  public void testEqualsPhysicalObject() {
    assertEquals(true, friend.equals(friend2));
  }
}
