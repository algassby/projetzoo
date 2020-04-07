/**
 * 
 */
package org.formation.zoo.stockage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.formation.zoo.service.CagePOJO;
import org.formation.zoo.service.GazellePOJO;

/**
 * @author algas
 *
 */
public class DaoJDBCImpl implements Dao<CagePOJO> {

	private static final String GAZELLE = "Gazelle";
	private DaoORB connecteur;
	private Logger logger;
	private List<CagePOJO> liste;
	public DaoJDBCImpl() {
		liste = new Vector<>();
		connecteur = new DaoORB();
		logger = Logger.getLogger(this.getClass().getName());
	}
	
	/**
	 * Méthode qui permet de recinstituer un pojo à partir d'un ResultSet
	 * @param rs le ResultSet en entrée
	 * @return au moins un POJO "cage vide"
	 * @throws SQLException
	 */
		private CagePOJO creerPOJO(ResultSet rs) throws SQLException {
			CagePOJO ret = null;
			GazellePOJO gaz = null;
			
			ret = new CagePOJO();
			ret.setX(rs.getInt("x"));
			ret.setY(rs.getInt("y"));
			ret.setCle(rs.getInt("idAnimal"));
			//SI c'est autre animal
			if(rs.getString("codeAnimal") != null) {
				ret.setAge(rs.getInt("age"));
				ret.setNom(rs.getString("nom"));
				ret.setPoids(rs.getDouble("poids"));
				ret.setCodeAnimal(rs.getString("codeAnimal"));
			//SI GAZELLE
				if(ret.getCodeAnimal().equals(GAZELLE)) {
					gaz = new GazellePOJO();
					gaz.setId(rs.getInt("id"));
					gaz.setIdAnimal(rs.getInt("idAnimal"));
					gaz.setLgCornes(rs.getInt("lgCornes"));
					ret.setGaz(gaz);
				}
			}
			return ret;
		}
	/**
	 * cette methode permet de lister les animaux
	 */
	
	@Override
	public List<CagePOJO> lireTous() {
		List<CagePOJO> ret = null;
		ResultSet rs = null;
		
		String req = "SELECT * FROM animal as gauche left join gazelle "
							+ "	as droite on gauche.idAnimal = droite.idAnimal;";
		try (Statement st = connecteur.getConnection().createStatement()){
			ret = new Vector<>();
			rs = st.executeQuery(req);
			while(rs.next()) {
				ret.add(creerPOJO(rs));
			}
		} catch (SQLException e) {
			logger.log(Level.INFO,e.getMessage());
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				logger.log(Level.INFO,e.getMessage());
			}
		}
		return ret;
	}
	/**
	 * @param elt, ajouter un element dans la liste
	 */
	@Override
	public void ecrireTous(List<CagePOJO> elt) {
		// vide !!!!! car n'a pas de sens avec les bases de données
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
	@SuppressWarnings("null")
	@Override
	public void modifier(int cle, CagePOJO obj) {
		//nombre d'oocurences modifiées
		 int nb = 0;
		 
		 PreparedStatement prepareStatement = null;
		 PreparedStatement prepareGazelle = null;
		 String requeteCage = "update animal set codeAnimal=?, x=?,y=?,nom=?,poids=?,age=? where idAnimal=? ";
		 String requeteGazelle = "update gazelle set lgCornes=?  where idAnimal=?";

			try {
				connecteur.getConnection().setAutoCommit(false);
		
				prepareStatement = connecteur.getConnection().prepareStatement(requeteCage);
				//Dans le cas ou la cage est pleine
				if(obj.getCodeAnimal()!=null) {
					prepareStatement.setString(1, obj.getCodeAnimal());
				}
				else {
					prepareGazelle.setNull(1, Types.VARCHAR);
				}
				prepareStatement.setInt(2, obj.getX());
				prepareStatement.setInt(3, obj.getY());
				prepareStatement.setString(4, obj.getNom());
				prepareStatement.setDouble(5, obj.getPoids());
				prepareStatement.setInt(6, obj.getAge());
				prepareStatement.setInt(7, cle);
				
			    nb = prepareStatement.executeUpdate();
			    prepareStatement.close();
			    
			    if(obj.getCodeAnimal().equals(GAZELLE))
			    	if((obj.getCodeAnimal() != null) && (obj.getCodeAnimal().equals(GAZELLE))){
			    		prepareGazelle = connecteur.getConnection().prepareStatement(requeteGazelle);
			    		prepareGazelle.setInt(1,obj.getGaz().getLgCornes());
			    		prepareGazelle.setInt(2,obj.getGaz().getIdAnimal());
						nb = prepareGazelle.executeUpdate();
						prepareGazelle.close();
					}
			    // si la modification echoue, on retourne 
			    if (nb != 0) {
					connecteur.getConnection().commit();
				}else {
					//si update echoue (mauvaise clef par exemple)
					connecteur.getConnection().rollback();
				}
			   
				
			}
			catch (SQLException e) {
				try {
					connecteur.getConnection().rollback();
				} catch (SQLException e1) {
					logger.log(Level.INFO, e.getMessage());
				}
				logger.log(Level.INFO, e.getMessage());
			}finally {
				try {
					if(prepareStatement != null) {
							prepareStatement.close();
					}
					if(prepareGazelle != null) {
						prepareGazelle.close();
					}
				} catch (SQLException e) {
					logger.log(Level.INFO, e.getMessage());
				}
			}
	}
	/**
	 * @param obj, effacer l'objet
	 */
	@Override
	public void effacer(CagePOJO obj) {
		String requete = String.join(" ","delete from animal where idAnimal= ",Integer.toString(obj.getCle()),";"); 
		String requeteGazelle =	 String.join(" ", "DELETE FROM animal WHERE idAnimal =",Integer.toString(obj.getCle()),";"); 
		
		Statement st = null;
		try {
			connecteur.getConnection().setAutoCommit(false);
			st = connecteur.getConnection().createStatement();
			st.executeUpdate(requete);
			if(obj.getCodeAnimal().equals(GAZELLE)) {
				st.executeUpdate(requeteGazelle);
			}
			connecteur.getConnection().commit();
		}catch(SQLException e) {
			try {
				connecteur.getConnection().rollback();
			} catch (SQLException e1) {
				logger.log(Level.INFO, e.getMessage());
			}
			logger.log(Level.INFO, e.getMessage());
		}finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					logger.log(Level.INFO, e.getMessage());
				}
			}
		}
		
	}
	/**
	 * ajouter un animal dans la base de donnée, avec une requete preparer,
	 * vous pouvez tester aussi avec le statement
	 */
	@Override
	public void ajouter(CagePOJO obj) {
		Statement st = null;
		String req = String.join("", "insert into animal (idAnimal,codeAnimal, nom, age, poids, x, y) values (",
				Integer.toString(obj.getCle()),",'",obj.getCodeAnimal(),"','",obj.getNom(),"',",Integer.toString(obj.getAge()),",",
				Double.toString(obj.getPoids()),",",Integer.toString(obj.getX()),
				","+Integer.toString(obj.getY()),");");	
		try {
			connecteur.getConnection().setAutoCommit(false);
			st = connecteur.getConnection().createStatement();
		    st.executeUpdate(req);
		    if(obj.getCodeAnimal().equals(GAZELLE))	
		    {
		    	String requeteGazelle = String.join(" ", "insert into gazelle (id,idAnimal, lgCornes) values ('",
				Integer.toString(obj.getGaz().getId()),",",Integer.toString(obj.getCle()),",",Integer.toString(obj.getGaz().getLgCornes()),");");
				st.executeUpdate(requeteGazelle);
		    }
			connecteur.getConnection().commit();
		}
		catch (SQLException e) {
			try {
				connecteur.getConnection().rollback();
			} catch (SQLException e2) {
				logger.log(Level.INFO, e2.getMessage());
			}
		}finally {
			if(st!=null) {
				try {
					st.close();
				} catch (SQLException e) {
					logger.log(Level.INFO, e.getMessage());
				}
			}
		}
	
	}
	/**
	 * @param cle, effacer un animal dans la table en passant sa clé
	 */
	@Override
	
	public void effacer(int cle) {
		String requete = String.join(" ", "SELECT * FROM animal WHERE idAnimal =",Integer.toString(cle),";");
		ResultSet res = null;
	
		try (Statement st = connecteur.getConnection().createStatement()){
			
			res = st.executeQuery(requete);
			if (res.next()) {
				effacer(creerPOJO(res));
			}
		} catch (SQLException e) {
			logger.log(Level.INFO, e.getMessage());
		}finally {
			try {
				if(res != null) {
					res.close();
				}
			} catch (SQLException e) {
				logger.log(Level.INFO, e.getMessage());
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
	
	@Override
	public void modifier(CagePOJO obj) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getNombreEnregistrement() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public CagePOJO getPersonne(int cle) {
		// TODO Auto-generated method stub
		return null;
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
		//GazellePOJO gp = new GazellePOJO();
		
		cp.setAge(22);
		cp.setCodeAnimal("Lion");
		cp.setNom("Marine");
		cp.setPoids(80);
		cp.setX(600);
		cp.setY(500);
		cp.setCle(11);
//		gp.setLgCornes(11);
//		gp.setIdAnimal(10);
//		gp.setId(11);
//		cp.setGaz(gp);
		
		daojdbc.modifier(10, cp);
		daojdbc.lireTous().forEach(item->System.out.println(item));

		
		
	}
		
}

