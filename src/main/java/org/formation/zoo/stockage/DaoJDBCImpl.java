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
				
	}
 
	@Override
	public void modifier(int cle, CagePOJO obj) {
		Statement st = null;
		String req = "UPDATE animal set nom ='"+obj.getNom()+"', age = "+obj.getAge()+", poids = "+obj.getPoids()+","
				+ " x = "+obj.getX()+", y = "+obj.getY()+" where idAnimal = "+cle+"  ";
		
		
		System.out.println(req);
		try {
			st = connecteur.getConnection().createStatement();
		    st.executeUpdate(req);
		    if(obj.getCodeAnimal().equals("Gazelle"))
		    {
		    	 String sql1 = "UPDATE gazelle set lgCornes = "+obj.getGaz().getLgCornes()+"";
		    	 st.executeUpdate(sql1);
		    }
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}
	@Override
	public void effacer(CagePOJO obj) {
		PreparedStatement prepareStatement = null;
		Statement st = null;
		String req = "DELETE FROM animal where idAnimal ="+obj.getCle()+"";
		String req2 = "DELETE FROM gazelle where idAnimal = "+obj.getCle()+"";
		//String requete = String.join("","DELETE FROM animal where", Integer.toString(this.getListe().get(tmp.getCle())),"= cle" );
		
		try {
			st = connecteur.getConnection().createStatement();
			//prepareStatement.setString(1, obj.getCodeAnimal());
			//prepareStatement.executeUpdate();
			st.executeUpdate(req);
			st.executeUpdate(req2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void ajouter(CagePOJO obj) {
		Statement st = null;
		//PreparedStatement pst = null;
		
		//String requete = "INSERT INTO animal(codeAnimal,nom,age,poids,x,y) VALUES (?,?,?,?,?,?);";
		String sql = "INSERT INTO animal values (null, '"+obj.getCodeAnimal()+"','"+obj.getNom()+"',"+obj.getAge()+","+obj.getPoids()+","
				+ ""+obj.getX()+","+obj.getY()+")";
		System.out.println(sql);
		try {
			st = connecteur.getConnection().createStatement();
		    st.executeUpdate(sql);
		    if(obj.getCodeAnimal().equals("Gazelle"))
		    {
		    	String sql1 = "INSERT INTO gazelle values (null,"+getLassId()+","+obj.getGaz().getLgCornes()+")";
		    	 st.executeUpdate(sql1);
		    }
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}	
	@Override
	public void effacer(int cle) {
		CagePOJO tmp = null;
		PreparedStatement prepareStatement = null;
		Statement st = null;
		tmp = new CagePOJO();
		String req = "DELETE FROM animal where idAnimal="+cle+"" ;
		String req2 = "DELETE FROM gazelle where idAnimal="+ cle+"";
		//String requete = String.join("","DELETE FROM animal where", Integer.toString(this.getListe().get(tmp.getCle())),"= cle" );
		
		try {
			st = connecteur.getConnection().createStatement();
			st.executeUpdate(req);
			st.executeUpdate(req2);
		
//			prepareStatement = connecteur.getConnection().prepareStatement(req);
//			prepareStatement.setInt(1, tmp.getCle());
//			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private int getLassId()
	{
		String req = "select MAX(idAnimal) as idAnimal from animal";
		Statement st = null;
		ResultSet rs = null;
		int id = 0;
		try {
			st = connecteur.getConnection().createStatement();
			rs = st.executeQuery(req);
			rs.next();
			id = rs.getInt("idAnimal");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	/**
	 * @return the daomemoire
	 */
	public DaoMemoire getDaomemoire() {
		return daomemoire;
	}
	public static void main(String [] args) {
		
		DaoJDBCImpl daojdbc = new DaoJDBCImpl();
		//daojdbc.ajouter(new CagePOJO());
		//daojdbc.effacer(12);
		//daojdbc.effacer();
		//daojdbc.lireTous().forEach(System.out::println);
//		daojdbc.ecrireTous(daojdbc.getDaomemoire().lireTous());
//		daojdbc.lireTous().forEach(System.out::println);
	//	daojdbc.ecrireTous(daojdbc.getListe());
		//System.out.println(daojdbc.getLassId());
		CagePOJO cp= new CagePOJO();
		GazellePOJO gp = new GazellePOJO();
		gp.setLgCornes(18);
		cp.setAge(22);
		cp.setCodeAnimal("Gazelle");
		cp.setNom("agazel");
		cp.setPoids(15);
		cp.setX(100);
		cp.setY(150);
		cp.setGaz(gp);
		cp.setCle(31);
		daojdbc.effacer(cp);
		
	}
		
}

