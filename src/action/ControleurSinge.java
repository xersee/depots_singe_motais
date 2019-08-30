package action;

import java.util.List;

import donnee.SingeDAO;
import modele.Singe;
import vue.NavigateurDesVues;
import vue.VueEditerSinge;
import vue.VueListeSinge;
import vue.VueSinge;

public class ControleurSinge {
	
	private NavigateurDesVues navigateur;
	private VueListeSinge vueListeSinge = null;
	private VueSinge vueSinge = null;
	//private VueAjouterSinge vueAjouterSinge = null;
	private VueEditerSinge vueEditerSinge = null;
	private SingeDAO leSingeDAO = null;
	
	private ControleurSinge()
	{
		System.out.println("Initialisation du controleur");	
		this.leSingeDAO = new SingeDAO();
	}
	
	public void activerVues(NavigateurDesVues navigateur)
	{
		this.navigateur = navigateur;
		//this.vueAjouterSinge = navigateur.getVueAjouterSinge();
		this.vueSinge = navigateur.getVueSinge();
		this.vueListeSinge = navigateur.getVueListeSinge();
		this.vueEditerSinge = navigateur.getVueEditerSinge();
						
		//// TEST ////
		//Singe Singe = new Singe("Dolly", "Grise", "20 kg", "5 juin 2015");
		//this.vueSinge.afficherSinge(Singe); // Appel de ma fonction avant de la programmer (pour tester à mesure)					
		
		this.navigateur.naviguerVersVueSinge();
		
		/// TEST ///
		List<Singe> listeSingesTest = leSingeDAO.listerSinges();
		this.vueListeSinge.afficherListeSinge(listeSingesTest); // Appel de ma fonction avant de la programmer (pour tester à mesure)
		
		this.navigateur.naviguerVersVueListeSinge();		
				
		//this.navigateur.naviguerVersVueAjouterSinge();
		
		//this.vueEditerSinge.afficherListeDistinction(this.distinctionDAO.listerDistinctions());
		
	}
	
	// SINGLETON DEBUT
	private static ControleurSinge instance = null;
	public static ControleurSinge getInstance()
	{
		if(null == instance) instance = new ControleurSinge();
		return instance;
	}
	// SINGLETON FINI

	
	//**********************************************************//
	//                                                          //
	//                   NOTIFICATIONS                          //
	//                                                          //
	//**********************************************************//
	
	// Les notifications peuvent être gérées par callback comme ici ou par événement,
	// Mais dans les deux cas les opérations sont divisées dans des fonctions comme ici
	// Pas de code dans un switch - case
	
	public void notifierEnregistrerNouveauSinge()
	{
		System.out.println("ControleurSinge.notifierEnregistrerNouveauSinge()");
		Singe Singe = this.navigateur.getVueAjouterSinge().demanderSinge();
		this.leSingeDAO.ajouterSinge(Singe);
		this.vueListeSinge.afficherListeSinge(this.leSingeDAO.listerSinges()); // TODO optimiser
		this.navigateur.naviguerVersVueListeSinge();
	}
	
	public void notifierEnregistrerSinge()
	{
		System.out.println("ControleurSinge.notifierEnregistrerSinge()");
		Singe Singe = this.navigateur.getVueEditerSinge().demanderSinge();
		this.leSingeDAO.modifierSinge(Singe);
		this.vueListeSinge.afficherListeSinge(this.leSingeDAO.listerSinges()); // TODO optimiser
		this.navigateur.naviguerVersVueListeSinge();		
	}
	
	public void notifierNaviguerAjouterSinge()
	{
		System.out.println("ControleurSinge.notifierNaviguerAjouterSinge()");
		this.navigateur.naviguerVersVueAjouterSinge();
	}
	
	public void notifierNaviguerEditerSinge(int idSinge)
	{
		System.out.println("ControleurSinge.notifierEditerSinge("+idSinge+")");
		// savoir par la vue liste quel numero de Singe a ete clique
		this.vueEditerSinge.afficherSinge(this.leSingeDAO.rapporterSinge(idSinge));
		this.navigateur.naviguerVersVueEditerSinge();
		
	}
	
	
}
