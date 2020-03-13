/**
 * 
 */
package org.formation.zoo.stockage;

import java.awt.Point;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import org.apache.tomcat.websocket.pojo.PojoEndpointBase;

import service.CagePOJO;
import service.GazellePOJO;

/**
 * @author algas
 *
 */
public class DaoJDBCImpl implements Dao<CagePOJO> {

	DaoMemoire daomemoire;
	private DaoORB connecteur;
	private List<CagePOJO> liste;
	public DaoJDBCImpl() {
		liste = new Vector<CagePOJO>();
		connecteur = new DaoORB();
		daomemoire = new DaoMemoire();
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
			lesCagePojo = new Vector<>();
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
			e.printStackTrace();
		}
		
		return lesCagePojo;
	}
	/**
	 * @return the liste
	 */
	public List<CagePOJO> getListe() {
		return liste;
	}
	/**
	 * @param liste the liste to set
	 */
	public void setListe(List<CagePOJO> liste) {
		this.liste = liste;
	}
	@Override
	public void ecrireTous(List<CagePOJO> elt) {
		CagePOJO pojo  = null;
		Statement st = null;
		
		
//		String requete = "INSERT INTO animal(codeAnimal,nom,age,poids,x,y) VALUES (?,?,?,?,?,?);";
		String requete = "INSERT INTO animal(codeAnimal,nom,age,poids,x,y) VALUES ('Lion','Nash','12','100','503','403');";
		try {
			//elt = new Vector<>();
			st = connecteur.getConnection().createStatement();
//			PreparedStatement pst = connecteur.getConnection().prepareStatement(requete);
//			pojo = new CagePOJO();
//			pst.setString(1,"Lion");
//			pst.setString(2,"lionli");
//			pst.setInt(3,12);
//			pst.setDouble(4,50);
//			pst.setInt(5, 402);
//			pst.setInt(6, 320);
//			
//			int rs = pst.executeUpdate(requete);
			int rs = st.executeUpdate(requete);
			elt.add(pojo);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		
		}
		
	}
 
	@Override
	public void modifier(int cle, CagePOJO obj) {
		PreparedStatement prepareStatement = null;
		
		String req = "UPDATE FROM animal where"+ this.getListe().get(obj.getCle()) +  "= " + cle;
		try {
			prepareStatement = connecteur.getConnection().prepareStatement(req);
			prepareStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	@Override
	public void effacer(CagePOJO obj) {
		PreparedStatement prepareStatement = null;
	
		String req = "DELETE FROM animal where"+ this.getListe().getClass().getName() +  "= " + obj;
		//String requete = String.join("","DELETE FROM animal where", Integer.toString(this.getListe().get(tmp.getCle())),"= cle" );
		
		try {
			prepareStatement = connecteur.getConnection().prepareStatement(req);
			prepareStatement.setString(1, obj.getCodeAnimal());
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void ajouter(CagePOJO obj) {
		//Statement st = null;
		PreparedStatement pst = null;
		
		
		String requete = "INSERT INTO animal(codeAnimal,nom,age,poids,x,y) VALUES (?,?,?,?,?,?);";
		//String requete = String.join("", "INSERT INTO  animal values" () ) VALUES ('Lion','Nash','12','100','503','403');";
//		String requete =  "INSERT INTO animal (idAnimal,codeAnimal,nom,age,poids,x,y) values(null,'"+obj.getCodeAnimal()+"','"+obj.getNom()+
//				"','"+obj.getAge()+"','"+obj.getPoids()+"',"
//				+obj.getX()+"','"+obj.getY()+"');'";
		try {
			//elt = new Vector<>();
			//st = connecteur.getConnection().createStatement();
			pst = connecteur.getConnection().prepareStatement(requete);
	
			pst.setString(1,obj.getCodeAnimal());
			pst.setString(2,obj.getNom());
			pst.setInt(3,obj.getAge());
			pst.setDouble(4,obj.getPoids());
			pst.setInt(5, obj.getX());
			pst.setInt(6, obj.getX());
			
//			
//			int rs = pst.executeUpdate(requete);
		    pst.executeUpdate();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	}	
	@Override
	public void effacer(int cle) {
		CagePOJO tmp = null;
		PreparedStatement prepareStatement = null;
		tmp = new CagePOJO();
		String req = "DELETE FROM animal where"+ this.getListe().get(tmp.getCle()) +  "= " + cle;
		//String requete = String.join("","DELETE FROM animal where", Integer.toString(this.getListe().get(tmp.getCle())),"= cle" );
		
		try {
			prepareStatement = connecteur.getConnection().prepareStatement(req);
			prepareStatement.setInt(1, tmp.getCle());
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @return the daomemoire
	 */
	public DaoMemoire getDaomemoire() {
		return daomemoire;
	}
	public static void main(String [] args) {
		
		DaoJDBCImpl daojdbc = new DaoJDBCImpl();
		daojdbc.ajouter(new CagePOJO());
		daojdbc.lireTous().forEach(System.out::println);
//		daojdbc.ecrireTous(daojdbc.getDaomemoire().lireTous());
//		daojdbc.lireTous().forEach(System.out::println);
	//	daojdbc.ecrireTous(daojdbc.getListe());
		
	}
		
}

