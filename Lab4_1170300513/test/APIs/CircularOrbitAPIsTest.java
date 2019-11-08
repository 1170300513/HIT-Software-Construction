package APIs;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;


import centralObject.CentralObject;
import circularOrbit.CircularOrbit;
import physicalObject.PhysicalObject;

public class CircularOrbitAPIsTest {

	CircularOrbit<CentralObject , PhysicalObject> cir = CircularOrbit.empty("Q3");
	CircularOrbitAPIs<CentralObject, PhysicalObject> Api = new CircularOrbitAPIs<>();
	
	// Testing strategy:
	// ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�
	
	@Test
	public void testGetObjectDistributionEntropy() {
		
		try {
			cir.readfile("test AtomicStructure.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		double answer = -7.742402021815782;
		assertEquals(0, (int)(answer - Api.getObjectDistributionEntropy(cir)));
	}

	@Test
	public void testGetLogicalDistance() {
		try {
			cir.readfile("test AtomicStructure.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		PhysicalObject e1 = cir.getorbits().get(0).getthingsintrack().get(0);
		PhysicalObject e2 = cir.getorbits().get(1).getthingsintrack().get(0);
		assertEquals(-1, Api.getLogicalDistance(cir, e1, e2));
	}

	@Test
	public void testGetPhysicalDistance() {
		try {
			cir.readfile("test AtomicStructure.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		PhysicalObject e1 = cir.getorbits().get(0).getthingsintrack().get(0);
		PhysicalObject e2 = cir.getorbits().get(1).getthingsintrack().get(0);
		assertEquals(-1, (int)Api.getPhysicalDistance(cir, e1, e2));
	}

	@Test
	public void testGetDifference() {
		CircularOrbit<CentralObject , PhysicalObject> cir2 = CircularOrbit.empty("Q3");
		try {
			cir.readfile("test AtomicStructure.txt");
			cir2.readfile("test AtomicStructure.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(Api.getDifference(cir, cir2));
		String answer = "���������:0\n" + 
				"���1��������������:0; �������:��\n" + 
				"���2��������������:0; �������:��\n" + 
				"���3��������������:0; �������:��\n" + 
				"���4��������������:0; �������:��\n" + 
				"���5��������������:0; �������:��\n";
		assertEquals(answer, Api.getDifference(cir, cir2).toString());
	}

}
