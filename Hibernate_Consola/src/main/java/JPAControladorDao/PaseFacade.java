package JPAControladorDao;

import java.util.List;

import entidades.Pase;

public interface PaseFacade extends AbstractFacadeJPA<Pase> {

	public List<Pase> mostratTodos();
	public List<Integer> peliculasProyectadas();
	public List<Long> consulta3(String genero);
	public List<Long> consulta7();
	
}
