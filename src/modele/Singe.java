package modele;

public class Singe {

	protected int id;
	protected String nom;
	protected int poids;  //garder
	protected String caractere; //(passif/aggressif/Defensif)
	
	/* ********************** Constructeur surchargé de la classe singe**************************  */
	
	//Constructeur avec tous les paramètres
	public Singe(int id, String nom, int poids, String caractere) {
		super();
		this.id = id;
		this.nom = nom;
		this.poids = poids;
		this.caractere = caractere;
	}
	
	//Constructeur sans le caractère
	public Singe(int id, String nom, int poids) {
		super();
		this.id = id;
		this.nom = nom;
		this.poids = poids;
		this.caractere=null;
	}
	
	//Constructeur avec juste le nom et l'id	
	public Singe(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
		this.poids= 0;
		this.caractere= null;
		
	}
	
	//Constructeur sans id	
		public Singe(String nom, int poids, String caractere) {
			super();
			this.id=0;
			this.nom = nom;
			this.poids = poids;
			this.caractere = caractere;
	}
		
		/* ********************** Getter et Setter **************************  */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public String getCaractere() {
		return caractere;
	}

	public void setCaractere(String caractere) {
		this.caractere = caractere;
	}	
			
}	

