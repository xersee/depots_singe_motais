package vue;
import action.ControleurSinge;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import modele.Singe;

public class VueSinge extends Scene{

	protected TextField valeurNom;
	protected TextField valeurPoids;
	protected TextField valeurCaractere;
	protected TextField valeurId;
	
	@SuppressWarnings("unused")
	private ControleurSinge controleur = null;	
	
	public VueSinge() {
		super(new GridPane(),400,400);
		GridPane grilleSinge = (GridPane) this.getRoot();

		// https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html
		valeurNom = new TextField();
		grilleSinge.add(new Label("Nom : "), 0, 0);
		grilleSinge.add(valeurNom, 1, 0);
		
		valeurPoids = new TextField("");
		grilleSinge.add(new Label("poids : "), 0, 1);
		grilleSinge.add(valeurPoids, 1, 1);

		valeurCaractere = new TextField("");
		grilleSinge.add(new Label("caractere : "), 0, 2);
		grilleSinge.add(valeurPoids, 1, 2);	
		
		valeurId= new TextField("");
		grilleSinge.add(new Label("id : "), 0, 3);
		grilleSinge.add(valeurPoids, 1, 3);					
	}
	
	public void afficherSinge(Singe Singe)
	{
		
		
		this.valeurPoids.setText(String.valueOf(Singe.getPoids()));
		this.valeurCaractere.setText(Singe.getCaractere());
		this.valeurNom.setText(Singe.getNom());
	}
	
	
	public void setControleur(ControleurSinge controleur) {
		this.controleur = controleur;
	}

}
