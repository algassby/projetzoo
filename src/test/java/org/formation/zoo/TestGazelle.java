/**
 * 
 */
package org.formation.zoo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.formation.zoo.modele.metier.Animal;
import org.formation.zoo.modele.metier.Gazelle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author algas
 *
 */
class TestGazelle {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Animal gazelle = new Gazelle();
	}

	/**
	 * Test method for {@link org.formation.zoo.modele.metier.Gazelle#finalize()}.
	 */
	@Test
	void testFinalize() {
		Gazelle gazelle = new Gazelle();
		try {
			gazelle.finalize();

		}
		catch(Exception e) {
			fail("n'aurit pas du arriver");
		}
	}

	/**
	 * Test method for {@link org.formation.zoo.modele.metier.Gazelle#Gazelle(java.lang.String, int, double, int)}.
	 */
	@Test
	void testGazelleStringIntDoubleInt() {
		try {
			this.setUpBeforeClass();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull("",new Gazelle());
	}

}
