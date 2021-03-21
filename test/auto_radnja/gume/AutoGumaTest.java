package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class AutoGumaTest {
	AutoGuma ag;
	@BeforeEach
	void setUp() throws Exception {
		ag = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		ag = null;
	}

	@Test
	void testAutoGuma() {
		ag = new AutoGuma();
		assertNotNull(ag);
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		ag = new AutoGuma("Michelin",15,200,50);
		assertNotNull(ag);
		assertEquals("Michelin",ag.getMarkaModel());
		assertEquals(15,ag.getPrecnik());
		assertEquals(200,ag.getSirina());
		assertEquals(50,ag.getVisina());
	}
	
	@Test
	void testSetMarkaModel() {
		ag.setMarkaModel("Michelin");
		assertEquals("Michelin",ag.getMarkaModel());
	}
	@Test
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class,()-> ag.setMarkaModel(null));
	}
	
	@Test 
	void testSetMarkaModelKratakString() {
		
		assertThrows(java.lang.RuntimeException.class, ()-> ag.setMarkaModel("Mi"));
	}
	@ParameterizedTest
	@CsvSource({
		"20"
		})
	void testSetPrecnik(int precnik) {
		ag.setPrecnik(precnik);
		assertEquals(precnik,ag.getPrecnik());
	}
	
	@ParameterizedTest
	@CsvSource({
		"0,25"
		})
	void testSetPrecnikOpseg(int precnik1, int precnik2) {
		assertThrows(java.lang.RuntimeException.class,()-> ag.setPrecnik(precnik1));
		assertThrows(java.lang.RuntimeException.class,()-> ag.setPrecnik(precnik2));
	}
	@ParameterizedTest
	@CsvSource({
		"200"
		})
	void testSetSirina(int sirina) {
		ag.setSirina(sirina);
		assertEquals(sirina,ag.getSirina());
	}

	@ParameterizedTest
	@CsvSource({
		"100,400"
		})
	void testSetSirinaOpseg(int sirina1, int sirina2) {
		assertThrows(java.lang.RuntimeException.class,()-> ag.setSirina(sirina1));
		assertThrows(java.lang.RuntimeException.class,()-> ag.setSirina(sirina2));
	}
	@ParameterizedTest
	@CsvSource({
		"50"
		})
	void testSetVisina(int visina) {
		ag.setVisina(visina);
		assertEquals(visina,ag.getVisina());
	}
	@ParameterizedTest
	@CsvSource({
		"100,400"
		})
	void testSetVisinaOpseg(int visina1, int visina2) {
		assertThrows(java.lang.RuntimeException.class,()-> ag.setVisina(visina1));
		assertThrows(java.lang.RuntimeException.class,()-> ag.setVisina(visina2));
	}
	@Test
	void testToString() {
		ag.setMarkaModel("Michelin");
		ag.setPrecnik(20);
		ag.setSirina(200);
		ag.setVisina(50);
		String str = ag.toString();
		assertTrue(str.contains("Michelin"));
		assertTrue(str.contains("20"));
		assertTrue(str.contains("200"));
		assertTrue(str.contains("50"));
	}

	@ParameterizedTest
	@CsvSource({
		"Michelin,Mich,20,20,200,200,50,50,false",
		"Michelin,Michelin,20,22,200,200,50,50,false",
		"Michelin,Michelin,20,20,202,200,50,50,false",
		"Michelin,Michelin,20,20,200,200,51,50,false",
		"Michelin,Michelin,20,20,200,200,50,50,true"
		})
	void testEqualsObject(String marka1,String marka2,int p1,int p2,int s1,int s2,int v1,int v2,boolean equal) {
		ag.setMarkaModel(marka1);
		ag.setPrecnik(p1);
		ag.setSirina(s1);
		ag.setVisina(v1);
		
		AutoGuma b = new AutoGuma();
		b.setMarkaModel(marka2);
		b.setPrecnik(p2);
		b.setSirina(s2);
		b.setVisina(v2);
		assertEquals(equal, ag.equals(b));
	}


}
