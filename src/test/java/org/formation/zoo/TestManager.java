/**
 * 
 */
package org.formation.zoo;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.formation.zoo.modele.technique.CageManager;
import org.formation.zoo.stockage.Dao;
import org.formation.zoo.stockage.DaoFactory;
import org.junit.jupiter.api.Test;

import controleur.Manager;
import service.CagePOJO;

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
	 * Test method for {@link controleur.Manager#Manager()}.
	 */
	@Test
	void testManager() { 
		try {
			List<CageManager> listeCageManager = null;
			assertNull(listeCageManager);
			assertNotNull(DaoFactory.getInstance().getDao());
			
		} catch (Exception e) {
			fail("le constructeur n'a pas pu faire son boulot");
		}
		
	}
	/**
	 * Test method for {@link controleur.Manager#init()}.
	 */
	//@Test
//	void testInit() {
//		try {
//			Dao<CagePOJO> acces = null;
//			List<CageManager> listeCageManager = null;
//			List<CagePOJO> listeCagePOJO = null;
//			listeCagePOJO = acces.lireTous();
//			listeCageManager = new ArrayList<>();
//			for (CagePOJO cagePOJO : listeCagePOJO) {
//				listeCageManager.add(new CageManager(cagePOJO, acces));
//				
//			}
//			
//			
//		} catch (Exception e) {
//			fail("la methode init ne marche pas");
//
//		}
//		
//	}
	
	/**
	 * Test method for {@link controleur.Manager#devorer(int, int)}.
	 */
//	@Test
//	void testDevorer() {
//
//			assertEquals("INCOMPATIBLE", Manager.getInstance().devorer(0,0));
//			assertEquals("INCOMPATIBLE", Manager.getInstance().devorer(0,1));
//			assertEquals("INCOMPATIBLE", Manager.getInstance().devorer(0,2));
//			assertEquals("INCOMPATIBLE", Manager.getInstance().devorer(1,1));
//			assertEquals("INCOMPATIBLE", Manager.getInstance().devorer(1,2));
//			assertEquals("MIAM", Manager.getInstance().devorer(1,3));
//			assertEquals("INCOMPATIBLE", Manager.getInstance().devorer(2,2));
//			assertEquals("INCOMPATIBLE", Manager.getInstance().devorer(2,3));
//			assertEquals("INCOMPATIBLE", Manager.getInstance().devorer(3,3));
//	
//	}
	

}
