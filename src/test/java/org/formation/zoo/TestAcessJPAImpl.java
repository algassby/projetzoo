/**
 * 
 */
package org.formation.zoo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.formation.zoo.service.CagePOJO;
import org.formation.zoo.stockage.DaoJPAImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author algas
 *
 */
class TestAcessJPAImpl {

	static DaoJPAImpl<CagePOJO> jpa;
	/**
	 * @throws java.lang.Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		jpa = new  DaoJPAImpl();
		
	}

	/**
	 * Test method for {@link org.formation.zoo.stockage.DaoJPAImpl#lireTous()}.
	 */
	@Test
	void testLireTous() {
		try {
			assertEquals(jpa.getNombreEnregistrement(), jpa.lireTous().size());
		} catch (Exception e) {
			fail("cela n'aurait pas du arrivé");
		}
		
	}
	

	@Test
	void testAjouter() {
		
		CagePOJO tmp = null;
		tmp = new CagePOJO();
		tmp.setCle(80);
		tmp.setAge(12);
		tmp.setCodeAnimal("Lion");
		tmp.setPoids(8);
		tmp.setX(222);
		tmp.setY(201);
		tmp.setNom("LILI");
		jpa.ajouter(tmp);
		assertTrue(jpa.lireTous().contains(jpa.lireTous().get(9)));
		jpa.effacer(80);
	}

	/**
	 * Test method for {@link org.formation.zoo.stockage.DaoJPAImpl#modifier(java.lang.Object)}.
	 */
	@Test
	void testModifierT() {
		List<CagePOJO> res = null;
		try {
			res = jpa.lireTous();
			assertNotNull(res.get(8));
			res.get(8).setCle(6);
			res.get(8).setNom("Marie");
			jpa.modifier(res.get(8));
			assertEquals("Marie", res.get(8).getNom());
			assertNotEquals("LILI", res.get(8).getNom());
			assertTrue(res.contains(res.get(8)));
		} catch (Exception e) {
			fail("cela n'aurait pas du arrivé");
		}

		
	}

	/**
	 * Test method for {@link org.formation.zoo.stockage.DaoJPAImpl#effacer(int)}.
	 */
	@Test
	void testEffacerInt() {
		List<CagePOJO> res = null;
		int count = 0;
		try {
			res = jpa.lireTous();
			count = jpa.getNombreEnregistrement();
			assertNotNull(res);
			//jpa.effacer(res.get(9));
			assertEquals(count, res.size());
			
		} catch (Exception e) {
			fail("cela n'aurait pas du arrivé, verifer votre methode effacer");
		}
		
	}
	/**
	 * test de la methode efface T{@link org.formation.zoo.stockage.DaoJPAImpl#effacer(T)}
	 */
	
	@Test
	void testEffacerT() {   
		 DaoJPAImpl<CagePOJO> jpa = null;
		 jpa = new DaoJPAImpl<CagePOJO>();
		 CagePOJO tmp = null;
	     List<CagePOJO>res = jpa.lireTous();
	     tmp = res.get(9);
		 assertNotNull(tmp.getCodeAnimal());
		 tmp.setCle(11);
	     jpa.effacer(tmp);
	     assertTrue(res.contains(tmp));
	}

	/**
	 * Test method for {@link org.formation.zoo.stockage.DaoJPAImpl#getPersonne(int)}.
	 */
	@Test
	void testGetPersonne() {
		List<CagePOJO> res =null;
		CagePOJO tmp = null;
		try {
			res = jpa.lireTous();
			tmp = jpa.getPersonne(1);
			assertNotNull(tmp);
			assertEquals(res.get(0).toString(), tmp.toString());
			assertNotEquals("[x=400, y=401, cle=1, codeAnimal=Lion, nom=clarences, age=10, poids=229.2, gaz=null], actual",tmp);
			assertEquals("clarence", tmp.getNom());
			assertTrue(res.contains(tmp));
		} catch (Exception e) {
			fail("cela n'aurait pas du arrivé, veuillez verifier votre methode getPersonne");
		}
		
	}

}



