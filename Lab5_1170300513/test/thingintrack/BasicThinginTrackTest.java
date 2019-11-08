package thingintrack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import physicalobject.PhysicalObject;
import thingintrack.BasicThinginTrack;
import track.Track;

public class BasicThinginTrackTest {

  PhysicalObject p1 = PhysicalObject.electronicscreator();
  PhysicalObject p2 = PhysicalObject.electronicscreator();
  Track track = Track.roundcreator(3);

  // Testing strategy:
  // ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�

  @Test
  public void testGettrack() {
    BasicThinginTrack<PhysicalObject> thinginTrack = new BasicThinginTrack<>(track);
    assertEquals(track, thinginTrack.gettrack());
  }

  @Test
  public void testAddobject() {
    BasicThinginTrack<PhysicalObject> thinginTrack = new BasicThinginTrack<>(track);
    thinginTrack.addobject(p2);
    assertEquals(p2, thinginTrack.getthingsintrack().get(0));
  }

  @Test
  public void testGetthingsintrack() {
    BasicThinginTrack<PhysicalObject> thinginTrack = new BasicThinginTrack<>(track);
    thinginTrack.addobject(p1);
    assertEquals(p1, thinginTrack.getthingsintrack().get(0));
  }

  @Test
  public void testDeleteobject() {
    BasicThinginTrack<PhysicalObject> thinginTrack = new BasicThinginTrack<>(track);
    thinginTrack.addobject(p2);
    thinginTrack.addobject(p1);
    thinginTrack.deleteobject(p1);
    assertEquals(p2, thinginTrack.getthingsintrack().get(0));

  }

}
