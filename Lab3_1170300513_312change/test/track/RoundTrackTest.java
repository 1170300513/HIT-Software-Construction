package track;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoundTrackTest {

	Track t = Track.Roundcreator(2);
	
	// Testing strategy:
	// ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�
	
	@Test
	public void testGetridus() {
		int r = 2;
		assertEquals(r, t.getridus().intValue());
	}

}
