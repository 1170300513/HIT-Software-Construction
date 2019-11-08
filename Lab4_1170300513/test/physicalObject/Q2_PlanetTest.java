package physicalObject;

import static org.junit.Assert.*;

import org.junit.Test;

import assist.number;

public class Q2_PlanetTest {

	PhysicalObject earth = PhysicalObject.Q2creator("earth", "solid", "blue", 6371, 10, "CW");
	PhysicalObject earth2 = PhysicalObject.Q2creator("earth", "solid", "blue",  6371, 10, "CW");
	// Testing strategy:
	// ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�
	
	@Test
	public void testGetform() {
		String form = "solid";
		assertEquals(form, earth.getform());
	}

	@Test
	public void testGetcolor() {
		String color = "blue";
		assertEquals(color, earth.getcolor());
	}

	@Test
	public void testGetplanetr() {
		int planetr = 6371;
		assertEquals(planetr, earth.getplanetr().intValue());
	}

	@Test
	public void testGetv() {
		int v = 10;
		assertEquals(v, earth.getv().intValue());
	}

	@Test
	public void testGetdirection() {
		String direction = "CW";
		assertEquals(direction, earth.getdirection());
	}

	@Test
	public void testGetname() {
		String name = "earth";
		assertEquals(name, earth.getname());
	}

	@Test
	public void testEqualsPhysicalObject() {
		assertEquals(true, earth.equals(earth2));
	}

	

}
