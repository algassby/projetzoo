/**
 * 
 */
package org.formation.zoo;

import static org.junit.jupiter.api.Assertions.*;

import org.formation.zoo.modele.metier.Animal;
import org.formation.zoo.modele.metier.Lion;
import org.junit.jupiter.api.Test;

import controleur.Manager;

/**
 * @author algas
 *
 */
class TestManager {

	/**
	 * Test method for {@link controleur.Manager#getInstance()}.
	 */
	@Test
	void testGetInstance() {
		try {
		Manager.getInstance();
		}
		catch(Exception e) {
			fail("Cela n'aurait pas du arriver");
		}
		
	}

	/**
	 * Test method for {@link controleur.Manager#devorer(int, int)}.
	 */
	@Test
	void testDevorer() {

			assertEquals("INCOMPATIBLE", Manager.getInstance().devorer(0,0));
			assertEquals("INCOMPATIBLE", Manager.getInstance().devorer(0,1));
			assertEquals("INCOMPATIBLE", Manager.getInstance().devorer(0,2));
			assertEquals("INCOMPATIBLE", Manager.getInstance().devorer(1,1));
			assertEquals("INCOMPATIBLE", Manager.getInstance().devorer(1,2));
			assertEquals("MIAM", Manager.getInstance().devorer(1,3));
			assertEquals("INCOMPATIBLE", Manager.getInstance().devorer(2,2));
			assertEquals("INCOMPATIBLE", Manager.getInstance().devorer(2,3));
			assertEquals("INCOMPATIBLE", Manager.getInstance().devorer(3,3));
	
	}
	

}
