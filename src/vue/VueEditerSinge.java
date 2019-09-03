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
	protected TextField valeurPoids;
	protected TextField valeurCaractere;
	protected TextField valeurId;
	
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
		
		valeurPoids = new TextField("");
		grilleSinge.add(new Label("poids : "), 0, 1);
		grilleSinge.add(valeurPoids, 1, 1);

		valeurCaractere = new TextField("");
		grilleSinge.add(new Label("caractere : "), 0, 2);
		grilleSinge.add(valeurPoids, 1, 2);	
		
		valeurId= new TextField("");
		grilleSinge.add(new Label("id : "), 0, 3);
		grilleSinge.add(valeurPoids, 1, 3);				
	
		// Todo : retirer les textes magiques
		panneau.getChildren().add(new Label("Editer un Singe")); // Todo : créer un sous-type de Label ou Text pour les titres
		panneau.getChildren().add(grilleSinge);
		panneau.getChildren().add(this.actionEnregistrerSinge);
	}
	
	public void afficherSinge(Singe Singe)
	{
		//a regarder => affichage?
		
		
		this.idSinge = Singe.getId();
		this.valeurPoids.setText(String.valueOf(Singe.getPoids()));
		this.valeurCaractere.setText(Singe.getCaractere());
		this.valeurNom.setText(Singe.getNom());
	}
		
	public Singe demanderSinge()
	{
		String leNom,lePoidsTexte,leCaractere,lIdTexte;
		int lId,lePoidsInt;
		Singe objSinge;
		
		lIdTexte=this.valeurId.getText();
		lId=Integer.parseInt(lIdTexte);
		leNom=this.valeurNom.getText();
		lePoidsTexte=this.valeurPoids.getText();
		lePoidsInt=Integer.parseInt((lePoidsTexte));
		leCaractere=this.valeurCaractere.getText();
		
		objSinge=new Singe(lId,leNom,lePoidsInt,leCaractere);
								
		return objSinge;
	}
	
	public void setControleur(ControleurSinge controleur) {
		this.controleur = controleur;
	}
	

}
