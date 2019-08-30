package modele;

public class ClanSinge {
	
	protected int IdClan;
	protected String NomClan;
	protected String Comportement;
	
	/* ********surcharge du constructeur si on ne connait pas le comportement du clan de singe******* */
	
	public ClanSinge(int lIdClan, String LeNomClan, String LeComportement) {
		IdClan=lIdClan;
		NomClan=LeNomClan;
		Comportement=LeComportement;				
	}
	
	public ClanSinge(int lIdClan, String LeNomClan) {
		IdClan=lIdClan;
		NomClan=LeNomClan;				
	}
	
	/* ********************** Getter et Setter **************************  */
	
	public int getIdClan() {
		return IdClan;
	}

	public void setIdClan(int idClan) {
		IdClan = idClan;
	}

	public String getNomClan() {
		return NomClan;
	}

	public void setNomClan(String nomClan) {
		NomClan = nomClan;
	}

	public String getComportement() {
		return Comportement;
	}

	public void setComportement(String comportement) {
		Comportement = comportement;
	}
	
	
	
}
