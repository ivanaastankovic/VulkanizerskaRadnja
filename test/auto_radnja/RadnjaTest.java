package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {

	protected Radnja radnja;
	@Test
	void testDodajGumu() {
		AutoGuma ag = new AutoGuma();
		ag.setMarkaModel("Michelin");
		radnja.dodajGumu(ag);
		
		assertEquals(ag,radnja.pronadjiGumu(ag.getMarkaModel()).get(0));
		
	}
	@Test
	void testDodajGumuNull() {
		assertThrows(java.lang.NullPointerException.class,()->radnja.dodajGumu(null));
	}
	@Test
	void testDodajGumuDuplikat() {
		AutoGuma ag1=new AutoGuma("Michelin",20,200,50);
		AutoGuma ag2=new AutoGuma("Michelin",20,200,50);
		radnja.dodajGumu(ag1);
		RuntimeException e = assertThrows(java.lang.RuntimeException.class,()->radnja.dodajGumu(ag2));
		assertEquals(e.getMessage(),"Guma vec postoji");
	}
	@Test
	void testPronadjiGumuRazliciteDim() {
		AutoGuma ag1 = new AutoGuma("Michelin",20,200,50);
		radnja.dodajGumu(ag1);
		AutoGuma ag2 = new AutoGuma("Michelin",21,199,49);
		radnja.dodajGumu(ag2);
		AutoGuma ag3 = new AutoGuma("Marka3",19,220,60);
		radnja.dodajGumu(ag3);
		
		
		LinkedList<AutoGuma> gume = radnja.pronadjiGumu("Michelin");
		assertEquals(2,gume.size());
		assertTrue(gume.contains(ag1));
		assertTrue(gume.contains(ag2));
	}
	@Test
	void testPronadjiGumuIsteDim() {
		AutoGuma ag1 = new AutoGuma("Michelin",20,200,50);
		radnja.dodajGumu(ag1);
		AutoGuma ag2 = new AutoGuma("Mic",20,200,50);
		radnja.dodajGumu(ag2);
		
		
		LinkedList<AutoGuma> gume = radnja.pronadjiGumu("Michelin");
		assertEquals(1,gume.size());
		assertTrue(gume.contains(ag1));
		assertTrue(!gume.contains(ag2));
	}
	@Test
	void testPronadjiGumuNull() {
		assertEquals(radnja.pronadjiGumu(null),null);
	}
	
	@Test
	void testPronadjiGumuNePostoji() {
		AutoGuma ag1 = new AutoGuma("Michelin",20,200,50);
		radnja.dodajGumu(ag1);
		AutoGuma ag2 = new AutoGuma("Michel",21,199,49);
		radnja.dodajGumu(ag2);
		
		LinkedList<AutoGuma> gume = radnja.pronadjiGumu("M");
		assertEquals(0,gume.size());
		assertTrue(!gume.contains(ag1));
		assertTrue(!gume.contains(ag2));
	}
}
