package vue;
import action.ControleurSinge;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import modele.Singe;

public class VueSinge extends Scene{

	protected Label valeurNom;
	protected Label valeurCouleur;
	protected Label valeurPoids;
	protected Label valeurNaissance;
	
	@SuppressWarnings("unused")
	private ControleurSinge controleur = null;	
	
	public VueSinge() {
		super(new GridPane(),400,400);
		GridPane grilleSinge = (GridPane) this.getRoot();

		// https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html
		valeurNom = new Label("");
		grilleSinge.add(new Label("Nom : "), 0, 0);
		grilleSinge.add(valeurNom, 1, 0);
		
		valeurCouleur = new Label("");
		grilleSinge.add(new Label("Couleur : "), 0, 1);
		grilleSinge.add(valeurCouleur, 1, 1);

		valeurPoids = new Label("");
		grilleSinge.add(new Label("Poids : "), 0, 2);
		grilleSinge.add(valeurPoids, 1, 2);		

		valeurNaissance = new Label("");
		grilleSinge.add(new Label("Naissance : "), 0, 3);
		grilleSinge.add(valeurNaissance, 1, 3);				
	}
	
	public void afficherSinge(Singe Singe)
	{
		this.valeurNom.setText(Singe.getNom());
		this.valeurCouleur.setText(Singe.getCouleur());
		this.valeurPoids.setText(Singe.getPoids());
		this.valeurNaissance.setText(Singe.getNaissance());	
	}
	
	
	public void setControleur(ControleurSinge controleur) {
		this.controleur = controleur;
	}

}
