package JPAControladorDao;

import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import entidades.Sala;

public class SalaFacadeImpl extends AbstractFacadeJPAImpl<Sala> implements SalaFacade{

	public SalaFacadeImpl() {
		super(Sala.class);
	}

	@Override
	public List<Sala> mostratTodos() {
		
		TypedQuery<Sala> q = em.createQuery("SELECT p FROM Sala AS p",Sala.class);
	    return q.getResultList();
	}

	public List<Sala> consulta4(Date fecha) {
		
		String jqpl = "SELECT distinct p.sala FROM Pase AS p WHERE p.pelicula.genero='TERROR' OR p.pelicula.genero='COMEDIA' AND p.pelicula.fechaProd>:ano ORDER BY p.sala.numasiporfilas desc";
		
		TypedQuery<Sala> q = em.createQuery(jqpl, Sala.class);
		
		q.setParameter("ano", fecha);
		
		return q.getResultList();
	}
	
}
