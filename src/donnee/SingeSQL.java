package donnee;

public interface SingeSQL {
	
	public static final String SQL_LISTER_SingeS = "SELECT * FROM singe";
	public static final String SQL_AJOUTER_Singe = "INSERT into singe(idSinge,nomSinge, poidsSinge, caractereSinge) VALUES(?,?,?,?)";
	public static final String SQL_MODIFIER_Singe = "UPDATE singe SET nomSinge = ?, poidsSinge = ?, caractereSinge = ? WHERE idSinge = ?";
	public static final String SQL_RAPPORTER_Singe = "SELECT * FROM singe WHERE id = ?";

}
