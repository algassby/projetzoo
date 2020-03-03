/**
 * 
 */
package org.formation.zoo.stockage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import service.CagePOJO;
import service.GazellePOJO;

/**
 * @author algas
 *
 */
public class DaoJDBCImpl implements Dao<CagePOJO> {

	private DaoORB connecteur;
	public DaoJDBCImpl() {
		connecteur = new DaoORB();
	}
	@Override
	public List<CagePOJO> lireTous() {
		
		String req = "SELECT * FROM animal as gauche left join gazelle as droite on gauche.idAnimal = droite.idAnimal;";
		List<CagePOJO> lesCagePojo = null;
		CagePOJO tmp = null;
		GazellePOJO gaz =null;
		
		
		Statement st = null;
		ResultSet rs = null;
		
		try {
			lesCagePojo = new Vector<CagePOJO>();
			st = connecteur.getConnection().createStatement();
			rs = st.executeQuery(req);
			if(rs != null) {
				while(rs.next()) {
					tmp = new CagePOJO();
					tmp.setX(rs.getInt("x"));
					tmp.setY(rs.getInt("Y"));
					tmp.setCle(rs.getInt("idAnimal"));
					if(rs.getString("codeAnimal")!=null) {
						
						tmp.setAge(rs.getInt("age"));
						tmp.setNom(rs.getString("nom"));
						tmp.setPoids(rs.getDouble("poids"));
						tmp.setCodeAnimal(rs.getString("codeAnimal"));
						
						//si c'est une gazelle
						if (tmp.getCodeAnimal().contentEquals("Gazelle")) {
							gaz = new GazellePOJO();
							gaz.setId(rs.getInt("id"));
							gaz.setIdAnimal(rs.getInt("idAnimal"));
							gaz.setLgCornes(rs.getInt("lgCornes"));
							tmp.setGaz(gaz);
						
					     }
						
					}
					
					lesCagePojo.add(tmp);

				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lesCagePojo;
	}
	@Override
	public void ecrireTous(List<CagePOJO> elt) {
		
		
	}
 
	public static void main(String [] args) {
		DaoJDBCImpl daojdbc = new DaoJDBCImpl();
		daojdbc.lireTous().forEach(System.out::println);
		
	}
	@Override
	public void modifier(int cle, CagePOJO obj) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void effacer(CagePOJO obj) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void ajouter(CagePOJO obj) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void effacer(int cle) {
		// TODO Auto-generated method stub
		
	}
		
}

