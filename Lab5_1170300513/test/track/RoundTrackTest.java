package track;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RoundTrackTest {

  Track track = Track.roundcreator(2);

  // Testing strategy:
  // ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�

  @Test
  public void testGetridus() {
    int r = 2;
    assertEquals(r, track.getridus().intValue());
  }

}
