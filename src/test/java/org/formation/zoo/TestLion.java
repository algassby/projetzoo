/**
 * 
 */
package org.formation.zoo;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.formation.zoo.modele.metier.Gazelle;
import org.formation.zoo.modele.metier.Lion;
import org.junit.jupiter.api.Test;

/**
 * @author algas
 *
 */
class TestLion {

	/**
	 * Test method for {@link org.formation.zoo.modele.metier.Lion#manger(org.formation.zoo.modele.metier.Gazelle)}.
	 */
	@Test
	void testMangerGazelle() {
		try {
			Lion lion = new Lion();
			assertEquals("MIAM",lion.manger(new Gazelle()));
		}
		catch(Exception e) {
			fail("Not yet implemented");
			e.getMessage();
		}
		
		
	}


	/**
	 * Test method for {@link org.formation.zoo.modele.metier.Lion#Lion()}.
	 */
	@Test
	void testLion() {
		try {
			Lion lion = new Lion();
		}
		catch(Exception e) {
			fail("problème sur le constructeur");
		}
	}

	/**
	 * Test method for {@link org.formation.zoo.modele.metier.Lion#Lion(java.lang.String, int, double)}.
	 */
	@Test
	void testLionStringIntDouble() {
		
		try {
			Lion lion = new Lion("",1,1);
			assertNotNull(lion);
			
		}
		catch(Exception e) {
			fail("Not yet implemented");
			e.getMessage();
		}
	}

	/**
	 * Test method for {@link org.formation.zoo.modele.metier.Lion#manger(org.formation.zoo.modele.metier.Mangeable)}.
	 */
	@Test
	void testMangerMangeable() {
		try {
			Lion lion = new Lion();
			lion.manger(new Gazelle());
		}
		catch(Exception e) {
			fail("echec: l'animal n'implemente pas mangeable");
		}
		
		
	}

}
