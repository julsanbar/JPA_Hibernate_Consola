package JPAControladorDao;

import java.util.List;

import javax.persistence.TypedQuery;

import entidades.Entrada;

public class EntradaFacadeImpl extends AbstractFacadeJPAImpl<Entrada> implements EntradaFacade{

	public EntradaFacadeImpl() {
		super(Entrada.class);
	}

	@Override
	public List<Entrada> mostratTodos() {
		
		TypedQuery<Entrada> q = em.createQuery("SELECT p FROM Entrada AS p",Entrada.class);
	    return q.getResultList();
	}
	
}
