package vue;
import action.ControleurSinge;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modele.Singe;

public class VueAjouterSinge extends Scene {

	protected TextField valeurNom;
	protected TextField valeurPoids;
	protected TextField valeurCaractere;
	
	private ControleurSinge controleur = null;
	protected Button actionEnregistrerSinge = null;
	
	public VueAjouterSinge()  {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleSinge = new GridPane();
		this.actionEnregistrerSinge = new Button("Enregistrer");
		
		this.actionEnregistrerSinge.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				controleur.notifierEnregistrerNouveauSinge();
				
			}});
		
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
			
			
		// Todo : retirer les textes magiques
		panneau.getChildren().add(new Label("Ajouter un Singe")); // Todo : cr�er un sous-type de Label ou Text pour les titres
		panneau.getChildren().add(grilleSinge);
		panneau.getChildren().add(this.actionEnregistrerSinge);
	}
	
	public Singe demanderSinge()
	{
		String leNom,lePoidsTexte,lePoids,leCaractere;
		int lePoids;
		Singe objSinge;
		
		leNom=this.valeurNom.getText();
		lePoidsTexte=this.valeurPoids.getText();
		lePoids=Integer.parseInt((lePoidsTexte));
		leCaractere=this.valeurCaractere.getText();
		
		objSinge=new Singe(leNom,lePoids,leCaractere);
								
		return Singe;
	}
	
	public void setControleur(ControleurSinge controleur) {
		this.controleur = controleur;
	}
	

}