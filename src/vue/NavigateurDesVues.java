package vue;

import action.ControleurSinge;
import javafx.application.Application;
import javafx.stage.Stage;

public class NavigateurDesVues extends Application{
	
	private Stage stade;
	
	private VueListeSinge vueListeSinge = null;
	private VueSinge vueSinge = null;
	private VueAjouterSinge vueAjouterSinge = null;
	private VueEditerSinge vueEditerSinge = null;
	
	private ControleurSinge controleur = null;
	
	public NavigateurDesVues() 
	{		
		this.vueListeSinge = new VueListeSinge();
		this.vueSinge = new VueSinge();
		this.vueAjouterSinge = new VueAjouterSinge();
		this.vueEditerSinge = new VueEditerSinge();
	}

	@Override
	public void start(Stage stade) throws Exception {
		this.stade = stade;
		
		this.stade.setScene(null);
		this.stade.show();
	
		this.controleur = ControleurSinge.getInstance();
		this.controleur.activerVues(this);
		this.vueListeSinge.setControleur(controleur);
		this.vueSinge.setControleur(controleur);
		this.vueAjouterSinge.setControleur(controleur);
		this.vueEditerSinge.setControleur(controleur);
	}	
	
	public VueListeSinge getVueListeSinge() {
		return vueListeSinge;
	}

	public VueSinge getVueSinge() {
		return vueSinge;
	}
	
	public VueAjouterSinge getVueAjouterSinge() {
		return vueAjouterSinge;
	}

	public VueEditerSinge getVueEditerSinge(){
		return this.vueEditerSinge;
	}
	
	public void naviguerVersVueSinge() {
		stade.setScene(this.vueSinge);
		stade.show();
	}
	
	public void naviguerVersVueListeSinge()
	{
		stade.setScene(this.vueListeSinge);
		stade.show();		
	}
	
	public void naviguerVersVueAjouterSinge()
	{
		stade.setScene(this.vueAjouterSinge);
		stade.show();				
	}

	public void naviguerVersVueEditerSinge()
	{
		stade.setScene(this.vueEditerSinge);
		stade.show();				
	}
	
}
