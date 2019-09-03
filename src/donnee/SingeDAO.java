package donnee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.Singe;

public class SingeDAO implements SingeSQL{
		
	private Connection connection = null;
	
	public SingeDAO()
	{
		this.connection = BaseDeDonnees.getInstance().getConnection();		
	}
	
	@SuppressWarnings("unused")
	private List<Singe> simulerListerSinges()
	{
		List<Singe> listeSingesTest = new ArrayList<Singe>();
		
		//un singe adulte pèse entre 40 et 60 kilos
		
		
		listeSingesTest.add(new Singe( 1,"César",60, "Amical"));
		listeSingesTest.add(new Singe(2,"Arthur",45, "Aggressif"));
		listeSingesTest.add(new Singe(3,"Hannibal",50, "Joueur"));
		listeSingesTest.add(new Singe(4,"Minamoto",55, "refléchi"));
		return listeSingesTest;
	}	
	
	public List<Singe> listerSinges()
	{

		List<Singe> listeSinges =  new ArrayList<Singe>();			
		Statement requeteListeSinges;
		try {
			requeteListeSinges = connection.createStatement();
			ResultSet curseurListeSinges = requeteListeSinges.executeQuery(SingeSQL.SQL_LISTER_SingeS);
			while(curseurListeSinges.next())
			{
				int id = curseurListeSinges.getInt("idSinge");
				String nom = curseurListeSinges.getString("nomSinge");
				int poids = curseurListeSinges.getInt("poidsSinge");
				String comportement = curseurListeSinges.getString("comportementSinge");
				System.out.println("le singe numéro "+id+"s'appelle "+nom+" , il pèse "+poids+" et possède un comportement"+comportement);
				Singe Singe = new Singe(id, nom, poids, comportement);
				Singe.setId(id);
				listeSinges.add(Singe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		//return this.simulerListerSinges();
		return listeSinges;
	}
	
	public void ajouterSinge(Singe Singe)
	{
		System.out.println("SingeDAO.ajouterSinge()");
		try {
			PreparedStatement requeteAjouterSinge = connection.prepareStatement(SQL_AJOUTER_Singe);
			
			requeteAjouterSinge.setInt(1, Singe.getId());
			requeteAjouterSinge.setString(2, Singe.getNom());
			requeteAjouterSinge.setInt(3, Singe.getPoids());
			requeteAjouterSinge.setString(4, Singe.getCaractere());
			
			System.out.println("SQL : " + SQL_AJOUTER_Singe);
			requeteAjouterSinge.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modifierSinge(Singe Singe)
	{
		System.out.println("SingeDAO.modifierSinge()");
		try {
			PreparedStatement requeteModifierSinge = connection.prepareStatement(SQL_MODIFIER_Singe);
			
			requeteModifierSinge.setString(1, Singe.getNom());
			requeteModifierSinge.setInt(2, Singe.getPoids());
			requeteModifierSinge.setString(3, Singe.getCaractere());
			requeteModifierSinge.setInt(4, Singe.getId());
			
			System.out.println("SQL : " + SQL_MODIFIER_Singe);
			requeteModifierSinge.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Singe rapporterSinge(int idSinge)
	{
		PreparedStatement requeteSinge;
		try {
			requeteSinge = connection.prepareStatement(SQL_RAPPORTER_Singe);
			requeteSinge.setInt(1, idSinge);
			System.out.println(SQL_RAPPORTER_Singe);
			ResultSet curseurSinge = requeteSinge.executeQuery();
			curseurSinge.next();
			int id = curseurSinge.getInt("idSinge");
			String nom = curseurSinge.getString("nomSinge");
			int poids = curseurSinge.getInt("poidsSinge");			
			String comportement = curseurSinge.getString("caractereSinge");
			System.out.println("le singe numéro "+id+"s'appelle "+nom+" , il pèse "+poids+" et possède un comportement"+comportement);
			Singe Singe = new Singe(id, nom, poids, comportement);
			Singe.setId(id);
			return Singe;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
