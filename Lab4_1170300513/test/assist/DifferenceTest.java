package assist;

import static org.junit.Assert.*;

import org.junit.Test;

import Exceptions.TheSameTagRException;
import assist.Difference;
import assist.number;
import centralObject.CentralObject;
import circularOrbit.CircularOrbit;
import physicalObject.PhysicalObject;
import track.Track;

public class DifferenceTest {
	CircularOrbit<CentralObject, PhysicalObject> c1 = CircularOrbit.empty("Q3");
	CircularOrbit<CentralObject, PhysicalObject> c2 = CircularOrbit.empty("Q3");
	Track t1 = Track.Roundcreator(1);
	Track t2 = Track.Roundcreator(2);
	Track t3 = Track.Roundcreator(3);
	PhysicalObject p1 = PhysicalObject.Q3creator();
	PhysicalObject p2 = PhysicalObject.Q3creator();
	PhysicalObject p3 = PhysicalObject.Q3creator();	
	// Testing strategy:
	// ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�
	
	@Test
	public void testToString()throws TheSameTagRException {
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
