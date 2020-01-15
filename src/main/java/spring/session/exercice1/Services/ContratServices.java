package spring.session.exercice1.Services;



import spring.session.exercice1.entities.Contrat;
public interface ContratServices {
	
	public void ajoutContrat(Contrat contrat);
	public void deleteContrat(Contrat contrat);
	public Contrat getContratById(Integer id);

}
