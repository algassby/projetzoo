/**
 * 
 */
package org.formation.zoo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.formation.zoo.stockage.DaoJDBCImpl;
import org.junit.jupiter.api.Test;

import service.CagePOJO;

/**
 * @author algas
 *
 */
class DaoJDBCImplTest {

	/**
	 * Test method for {@link org.formation.zoo.stockage.DaoJDBCImpl#getListe()}.
	 */
	@Test
	void testGetListe() {
		DaoJDBCImpl dao = null;
		dao = new DaoJDBCImpl();
		assertNotNull(dao.getListe());
	}

	/**
	 * Test method for {@link org.formation.zoo.stockage.DaoJDBCImpl#ecrireTous(java.util.List)}.
	 */
	@Test
	void testEcrireTous() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link org.formation.zoo.stockage.DaoJDBCImpl#modifier(int, service.CagePOJO)}.
	 */
	@Test
	void testModifier() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link org.formation.zoo.stockage.DaoJDBCImpl#effacer(service.CagePOJO)}.
	 */
	@Test
	void testEffacerCagePOJO() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link org.formation.zoo.stockage.DaoJDBCImpl#ajouter(service.CagePOJO)}.
	 */
	@Test
	void testAjouter() {
		CagePOJO tmp  = null;
		tmp = new CagePOJO();
		DaoJDBCImpl dao =null;
	
		tmp.setCodeAnimal("Lion");
		tmp.setNom("clarence");
		tmp.setCle(12);
		dao = new DaoJDBCImpl();
		dao.ajouter(tmp);
		
		dao.getListe().forEach(System.out::print);
	}

	/**
	 * Test method for {@link org.formation.zoo.stockage.DaoJDBCImpl#effacer(int)}.
	 */
	@Test
	void testEffacerInt() {
		fail("Not yet implemented"); // TODO
	}

}
