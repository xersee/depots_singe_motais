package vue;
import java.util.List;

import action.ControleurSinge;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import modele.Singe;

public class VueListeSinge extends Scene {

	protected GridPane grilleSinges;
	
	private ControleurSinge controleur = null;
	
	private Button actionNaviguerAjouterSinge;
	public VueListeSinge() {
		super(new GridPane(), 400,400);
		grilleSinges = (GridPane) this.getRoot();
		this.actionNaviguerAjouterSinge = new Button("Ajouter un Singe");
	}
	
	public void afficherListeSinge(List<Singe> listeSinges)
	{
		this.grilleSinges.getChildren().clear();
		
		int numero = 0;
		this.grilleSinges.add(new Label("Nom"), 0, numero);
		this.grilleSinges.add(new Label("Naissance"), 1, numero);	
		for(Singe Singe : listeSinges)
		{
			Button actionEditerSinge = new Button("Editer");
			actionEditerSinge.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent a) {
					controleur.notifierNaviguerEditerSinge(Singe.getId()); // TODO ameliorer ceci pour respecter architecture cible = pas de parametre dans les notifications au controleur
				}});
			numero++;
			this.grilleSinges.add(new Label(Singe.getNom()), 0, numero);
			this.grilleSinges.add(new Label(Singe.getNaissance()), 1, numero);			
			this.grilleSinges.add(actionEditerSinge, 2, numero);
		}
		
		this.actionNaviguerAjouterSinge.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent arg0) {
				controleur.notifierNaviguerAjouterSinge();
			}	
		});
		
		this.grilleSinges.add(this.actionNaviguerAjouterSinge, 1, ++numero);
	}

	public void setControleur(ControleurSinge controleur) {
		this.controleur = controleur;
	}

}
