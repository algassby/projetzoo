/**
 * 
 */
package org.formation.zoo;

import static org.junit.jupiter.api.Assertions.*;

import org.formation.zoo.modele.metier.Cage;
import org.formation.zoo.service.CagePOJO;
import org.junit.jupiter.api.Test;

import utilitaire.Conversion;

/**
 * @author algas
 *
 */
class TestConversion {

	/**
	 * Test method for {@link utilitaire.Conversion#pojoToCage(org.formation.zoo.service.CagePOJO)}.
	 */
	@Test
	void testPojoToCage() {
		CagePOJO cp =null;
		Cage cage = null;
		
		cp = new CagePOJO();
		cp.setX(23);
		cp.setY(24);
		cp.setCle(0);
		
		cage = Conversion.pojoToCage(cp);
		
		assertNotNull(cage);
		assertEquals(23,cp.getX());
		assertNull(cage.getOccupant());
		
		cp.setCodeAnimal("Leo");
		cp.setAge(4);
		cp.setPoids(143.3);
		cage= Conversion.pojoToCage(cp);
		assertNotNull(cage);
//		assertNotNull(cage.getOccupant());
//		assertEquals("Leo",cage.getOccupant().getNom());
//		assertEquals("Lion",cage.getOccupant().getClass().getSimpleName());
		
	}

}
