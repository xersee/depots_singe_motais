package donnee;

import java.sql.Connection;

public class ClanSingeDAO {

	private Connection LaConnection;
	
	public ClanSingeDAO() {
		
	this.LaConnection = BaseDeDonnees.getInstance().getConnection();	
	}
	
	
}


