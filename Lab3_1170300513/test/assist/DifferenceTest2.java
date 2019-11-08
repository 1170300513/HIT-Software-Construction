package assist;

import static org.junit.Assert.*;

import org.junit.Test;

import assist.Difference;
import assist.number;
import centralObject.CentralObject;
import circularOrbit.CircularOrbit;
import physicalObject.PhysicalObject;
import track.Track;

public class DifferenceTest2 {
	CircularOrbit<CentralObject, PhysicalObject> c1 = CircularOrbit.empty("Q5");
	CircularOrbit<CentralObject, PhysicalObject> c2 = CircularOrbit.empty("Q5");
	Track t1 = Track.Roundcreator(1);
	Track t2 = Track.Roundcreator(2);
	Track t3 = Track.Roundcreator(3);
	PhysicalObject p1 = PhysicalObject.Q5creator("CJ", "M", 20);
	PhysicalObject p2 = PhysicalObject.Q5creator("WYZ", "M", 20);
	PhysicalObject p3 = PhysicalObject.Q5creator("CXK", "M", 20);	
	PhysicalObject p4 = PhysicalObject.Q5creator("CJ", "M", 20);
	// Testing strategy:
	// ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�
	
	@Test
	public void testToString() {
		c1.addorbit(t1);
		c1.addorbit(t2);
		c2.addorbit(t3);
		c1.addtoorbit(p1, t1);
		c1.addtoorbit(p2, t1);
		c2.addtoorbit(p3, t3);
		c2.addtoorbit(p4, t3);
		Difference<PhysicalObject> difference = new Difference<>(c1.getorbits(), c2.getorbits());
		System.out.println(difference);
		//String answer = "���������:1\n" + "���1��������������:1; �������:��\n";
		//assertEquals(answer, difference.toString());

		
	}

}
