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

public class VueEditerSinge extends Scene {

	protected TextField valeurNom;
	protected TextField valeurCouleur;
	protected TextField valeurPoids;
	protected TextField valeurNaissance;
	
	private ControleurSinge controleur = null;
	protected Button actionEnregistrerSinge = null;
	
	private int idSinge = 0;
	
	public VueEditerSinge()  {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleSinge = new GridPane();
				
		this.actionEnregistrerSinge = new Button("Enregistrer");
		
		this.actionEnregistrerSinge.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				controleur.notifierEnregistrerSinge();
				
			}});
		
		// https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html
		valeurNom = new TextField();
		grilleSinge.add(new Label("Nom : "), 0, 0);
		grilleSinge.add(valeurNom, 1, 0);
		
		valeurCouleur = new TextField("");
		grilleSinge.add(new Label("Couleur : "), 0, 1);
		grilleSinge.add(valeurCouleur, 1, 1);

		valeurPoids = new TextField("");
		grilleSinge.add(new Label("Poids : "), 0, 2);
		grilleSinge.add(valeurPoids, 1, 2);		

		valeurNaissance = new TextField("");
		grilleSinge.add(new Label("Naissance : "), 0, 3);
		grilleSinge.add(valeurNaissance, 1, 3);				
	
		// Todo : retirer les textes magiques
		panneau.getChildren().add(new Label("Editer un Singe")); // Todo : créer un sous-type de Label ou Text pour les titres
		panneau.getChildren().add(grilleSinge);
		panneau.getChildren().add(this.actionEnregistrerSinge);
	}
	
	public void afficherSinge(Singe Singe)
	{
		this.idSinge = Singe.getId();
		this.valeurNom.setText(Singe.getNom());
		this.valeurCouleur.setText(Singe.getCouleur());
		this.valeurPoids.setText(Singe.getPoids());
		this.valeurNaissance.setText(Singe.getNaissance());
	}
		
	public Singe demanderSinge()
	{
		Singe Singe = new Singe(this.valeurNom.getText(), 
								this.valeurCouleur.getText(), 
								this.valeurPoids.getText(), 
								this.valeurNaissance.getText());
		Singe.setId(idSinge);
		return Singe;
	}
	
	public void setControleur(ControleurSinge controleur) {
		this.controleur = controleur;
	}
	

}
