package JPAControladorDao;

import java.util.Date;
import java.util.List;

import entidades.Sala;

public interface SalaFacade extends AbstractFacadeJPA<Sala> {

	public List<Sala> mostratTodos();
	public List<Sala> consulta4(Date fecha);
	
	
}
