/**
 * 
 */
package org.formation.zoo.stockage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import org.formation.zoo.service.CagePOJO;
import org.formation.zoo.service.GazellePOJO;

/**
 * @author algas
 *
 */
public class DaoJDBCImpl implements Dao<CagePOJO> {

	private DaoORB connecteur;
	private List<CagePOJO> liste;
	public DaoJDBCImpl() {
		liste = new Vector<>();
		connecteur = new DaoORB();
	}
	/**
	 * cette methode permet de lister les animaux
	 */
	
	@Override
	public List<CagePOJO> lireTous() {
		List<CagePOJO> lesCagePojo = null;
		CagePOJO tmp = null;
		GazellePOJO gaz =null;
		
		Statement st = null;
		ResultSet rs = null;
		String req = null;
		req = "SELECT * FROM animal as gauche left join gazelle as droite on gauche.idAnimal = droite.idAnimal;";
		
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
						if (tmp.getCodeAnimal().equals("Gazelle")) {
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
	 * @param elt, ajouter un element dans la liste
	 */
	@Override
	public void ecrireTous(List<CagePOJO> elt) {
				
		CagePOJO  tmp = null;
		
		tmp = new CagePOJO();
		if(tmp != null) {
			tmp.setCodeAnimal("Lion");
			tmp.setNom("Elisa");
			tmp.setCle(10);
			tmp.setAge(12);
			tmp.setPoids(82);
			tmp.setX(450);
			tmp.setY(330);
			this.ajouter(tmp);
			elt.add(tmp);
		}
		
		tmp = new CagePOJO();
		if(tmp!=null) {
			tmp.setCodeAnimal("Singe");
			tmp.setNom("kiki");
			tmp.setCle(11);
			tmp.setAge(11);
			tmp.setPoids(60);
			tmp.setX(400);
			tmp.setY(200);
			this.ajouter(tmp);
			elt.add(tmp);
		
		}
		tmp = new CagePOJO();
		if(tmp!=null) {
		tmp.setCodeAnimal("Lion");
		tmp.setNom("BorisJohnson");
		tmp.setAge(20);
		tmp.setPoids(80);
		tmp.setX(400);
		tmp.setY(469);
		this.ajouter(tmp);
		elt.add(tmp);
	
		}
		
			
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
	
 /**
  * @param cle, la clé de l'animal
  * @param obj, l'objet permet de recuperer les parametres de l'objet exemple obj.getCle()
  */
	@Override
	public void modifier(int cle, CagePOJO obj) {
//		 Statement st = null;
		 PreparedStatement prepareStatement = null;
		 String sql1 = null;
		 String req = null;
		
//		 req = "UPDATE animal set nom ='"+obj.getNom()+"', age = "+obj.getAge()+", poids = "+obj.getPoids()+","
//				+ " x = "+obj.getX()+", y = "+obj.getY()+" where idAnimal = "+cle+"  ";

		    req = "UPDATE animal set nom =?, age = ?, poids = ?, x = ?, y = ?, cle = ? where idAnimal = ? ";

			try {
				prepareStatement = connecteur.getConnection().prepareStatement(req);
				prepareStatement.setString(1, obj.getNom());
				prepareStatement.setInt(2, obj.getAge());
				prepareStatement.setDouble(3, obj.getPoids());
				prepareStatement.setInt(4, obj.getX());
				prepareStatement.setInt(5, obj.getY());
				prepareStatement.setString(6, obj.getCodeAnimal());
				prepareStatement.setInt(7, cle);
//				st = connecteur.getConnection().createStatement();
			    prepareStatement.executeUpdate();
//				st.executeUpdate(req);
			    if(obj.getCodeAnimal().equals("Gazelle"))
			    {
//			    	sql1 = "UPDATE gazelle set lgCornes = '"+obj.getGaz().getLgCornes()+"  "+"'";
			    	 sql1 = "UPDATE gazelle set lgCornes = ?";
			    	 prepareStatement = connecteur.getConnection().prepareStatement(sql1);
//			    	 System.out.println(sql1);
//			    	 st.executeUpdate(sql1);
			    	
			    	 prepareStatement.setObject(1, obj.getGaz().getLgCornes());

			    	 prepareStatement.executeUpdate();
			    }
				
			}
			catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
	}
	/**
	 * @param obj, effacer l'objet
	 */
	@Override
	public void effacer(CagePOJO obj) {
		PreparedStatement prepareStatement = null;
		//Statement st = null;
//		String req = "DELETE FROM animal where idAnimal ="+obj.getCle()+"";
//		String req2 = "DELETE FROM gazelle where idAnimal = "+obj.getCle()+"";
		String req = "DELETE FROM animal where idAnimal = ?";
		String req2 = "DELETE FROM gazelle where idAnimal = ?";
		//String requete = String.join("","DELETE FROM animal where", Integer.toString(this.getListe().get(tmp.getCle())),"= cle" );
		
		try {
			prepareStatement = connecteur.getConnection().prepareStatement(req);
			prepareStatement = connecteur.getConnection().prepareStatement(req2);
			prepareStatement.setInt(1, obj.getCle());
			//prepareStatement.setString(1, obj.getCodeAnimal());
			//prepareStatement.executeUpdate();
			prepareStatement.executeUpdate();
//			st.executeUpdate(req);
//			st.executeUpdate(req2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				prepareStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * ajouter un animal dans la base de donnée, avec une requete preparer,
	 * vous pouvez tester aussi avec le statement
	 */
	@Override
	public void ajouter(CagePOJO obj) {
		//Statement st = null;
		PreparedStatement pst = null;
		
		String requete = "INSERT INTO animal(codeAnimal,nom,age,poids,x,y) VALUES (?,?,?,?,?,?);";
//		String sql = "INSERT INTO animal values (null, '"+obj.getCodeAnimal()+"','"+obj.getNom()+"',"+obj.getAge()+","+obj.getPoids()+","
//				+ ""+obj.getX()+","+obj.getY()+")";
		
		
		//System.out.println(requete);
		try {
			
			pst = connecteur.getConnection().prepareStatement(requete);
			pst.setString(1, obj.getCodeAnimal());
			pst.setString(2, obj.getNom());
			pst.setInt(3, obj.getAge());
			pst.setDouble(4, obj.getPoids());
			pst.setInt(5, obj.getX());
			pst.setInt(6, obj.getY());
			pst.executeUpdate();
			
//			st = connecteur.getConnection().createStatement();
//		    st.executeUpdate(sql);
		    if(obj.getCodeAnimal().equals("Gazelle"))
		    {
//		    	String sql1 = "INSERT INTO gazelle values (null,"+getLassId()+","+obj.getGaz().getLgCornes()+")";
		    	String sql1 =  "INSERT INTO gazelle(idAnimal, lgCornes) VALUES (?,?);";
		    	
		    	pst = connecteur.getConnection().prepareStatement(sql1);
		    	//System.out.println(sql1);
		    	pst.setInt(1, getLassId());
		    	pst.setInt(2, obj.getGaz().getLgCornes());
		    	pst.executeUpdate();
//		    	 st.executeUpdate(sql1);
		    }
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}
	/**
	 * @param cle, effacer un animal dans la table en passant sa clé
	 */
	@Override
	
	public void effacer(int cle) {
		String req =null;
		String req2 = null;
		//PreparedStatement prepareStatement = null;
		Statement statement = null;
		req = String.join("", "DELETE FROM animal where idAnimal=",Integer.toString(cle) );
		req2 = String.join("","DELETE FROM gazelle where idAnimal=",Integer.toString(cle));
		
		try {
			statement = connecteur.getConnection().createStatement();
			statement.executeUpdate(req);
			statement.executeUpdate(req2);
		
//			prepareStatement = connecteur.getConnection().prepareStatement(req);
//			prepareStatement.setInt(1, tmp.getCle());
//			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
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
		finally {
			try {
				st.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		return id;
	}
	
	/**
	 * 
	 * 
	 * @return cle,retourne le nom de l'animal, en donnant la clé
	 */
	public String getNom(int cle) {
		Statement st = null;
		ResultSet res = null;
		String req = null;
		String nom = null;
		req = "SELECT nom from animal  where idAnimal ="+cle;
		try {
			st = connecteur.getConnection().createStatement();
			res = st.executeQuery(req);
			res.next();
			nom = res.getString("nom");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				st.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		return nom;
		
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
		
		cp.setAge(2);
		cp.setCodeAnimal("Gazelle");
		cp.setNom("LouisLEN");
		cp.setPoids(80);
		cp.setX(600);
		cp.setY(500);
		cp.setCle(10);
		gp.setLgCornes(11);
		gp.setIdAnimal(10);
		gp.setId(11);
		cp.setGaz(gp);
		
		//daojdbc.ajouter(cp);
		
		//daojdbc.effacer(65);	
		//daojdbc.modifier(7, cp);
		daojdbc.lireTous().forEach(System.out::println);
//		System.out.println(daojdbc.getNom(1));
		
		
	}
		
}

