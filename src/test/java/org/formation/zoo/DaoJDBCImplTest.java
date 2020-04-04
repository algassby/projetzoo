/**
 * 
 */
package org.formation.zoo;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.formation.zoo.service.CagePOJO;
import org.formation.zoo.service.GazellePOJO;
import org.formation.zoo.stockage.DaoJDBCImpl;
import org.formation.zoo.stockage.DaoORB;
import org.junit.jupiter.api.Test;

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
		
	}

	/**
	 * Test method for {@link org.formation.zoo.stockage.DaoJDBCImpl#modifier(int, org.formation.zoo.service.CagePOJO)}.
	 */
	@Test
	void testModifier() {
		DaoJDBCImpl dao =null;
		CagePOJO tmp  = null;
		GazellePOJO gz = null;
		gz = new GazellePOJO();
		gz.setLgCornes(7);
		tmp = new CagePOJO();
		
	try {
		tmp.setCodeAnimal("Gazelle");
		tmp.setNom("clarence");
		tmp.setPoids(14);
		tmp.setX(222);
		tmp.setY(333);
		tmp.setCle(11);
		tmp.setGaz(gz);
		dao = new DaoJDBCImpl();
		//dao.ajouter(tmp);
		dao.modifier(6,tmp);
		assertNotNull(tmp);
		assertEquals("clarence", dao.getNom(6));
		

		} catch (Exception e) {
			fail("ce la n'aurait pas du arrivé");
		}

	}

	/**
	 * Test method for {@link org.formation.zoo.stockage.DaoJDBCImpl#effacer(org.formation.zoo.service.CagePOJO)}.
	 */
	@Test
	void testEffacerCagePOJO() {
		
				CagePOJO tmp  = null;
				tmp = new CagePOJO();
				DaoJDBCImpl dao =null;
			try {
				tmp.setCodeAnimal("Lion");
				tmp.setNom("clarence");
				tmp.setPoids(14);
				tmp.setX(120);
				tmp.setY(150);
				tmp.setCle(12);
				dao = new DaoJDBCImpl();
				//dao.ajouter(tmp);
				assertNotNull(tmp);
				dao.effacer(tmp);
				//assertNull(tmp.getNom(), "l'objet ne devrait pas exister");
			
		
			} catch (Exception e) {
				fail("ce la n'aurait pas du arrivé");
			}

		
	}

	/**
	 * Test method for {@link org.formation.zoo.stockage.DaoJDBCImpl#ajouter(org.formation.zoo.service.CagePOJO)}.
	 */
	@Test
	void testAjouter() {
		
		try {
			CagePOJO tmp  = null;
			tmp = new CagePOJO();
			DaoJDBCImpl dao =null;
		
			tmp.setCodeAnimal("Singe");
			tmp.setNom(null);
			tmp.setCle(15);
			dao = new DaoJDBCImpl();
			//dao.ajouter(tmp);
			assertNotNull(tmp);
			//assertEquals("clarence",tmp.getNom());
			assertNull(dao.getNom(63));
			assertNotEquals("Marie",dao.getNom(63));
			
		} catch (Exception e) {
			fail("cela ne devrait pas arrivé");
		}
		
		
	}

	/**
	 * Test method for {@link org.formation.zoo.stockage.DaoJDBCImpl#effacer(int)}.
	 */
	@Test
	void testEffacerInt() {
			CagePOJO tmp  = null;
			tmp = new CagePOJO();
			DaoJDBCImpl dao =null;
		try {
			tmp.setCodeAnimal("Lion");
			tmp.setNom("Claire");
			tmp.setPoids(14);
			tmp.setX(200);
			tmp.setY(201);
			//tmp.setCle(25);
			dao = new DaoJDBCImpl();
			//dao.ajouter(tmp);
			dao.effacer(64);
			//assertNull(dao.getNom(64));
	
		} catch (Exception e) {
			fail("its not ok");
		}
	}

}
