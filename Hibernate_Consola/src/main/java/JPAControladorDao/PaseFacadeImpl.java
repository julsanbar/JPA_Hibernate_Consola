package JPAControladorDao;

import java.sql.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import entidades.Pase;
import entidades.Pelicula;

public class PaseFacadeImpl extends AbstractFacadeJPAImpl<Pase> implements PaseFacade{

	public PaseFacadeImpl() {
		super(Pase.class);
	}

	@Override
	public List<Pase> mostratTodos() {
		
		TypedQuery<Pase> q = em.createQuery("SELECT p FROM Pase AS p",Pase.class);
	    return q.getResultList();
	}

	public List<Integer> peliculasProyectadas() {
		
		String jpql = "SELECT DISTINCT(pase.pelicula.codpelicula) FROM Pase pase";
		
		TypedQuery<Integer> proyectadas = em.createQuery(jpql,Integer.class);
		
		return proyectadas.getResultList();
	}

	@Override
	public List<Long> consulta3(String genero) {
		
		String jpql = "SELECT DISTINCT count(pas.sala.codsala) FROM Pase pas where pas.pelicula.genero = '"+genero+"'";
		
		TypedQuery<Long> salas = em.createQuery(jpql, Long.class);
		
		return salas.getResultList();
	}

	@Override
	public List<Long> consulta7() {
		
		String jpql = "SELECT sum(ent.pvp) FROM Pase pas, Entrada ent where (pas.codpase = ent.pase.codpase) and (pas.fechaPase > ?1 and pas.fechaPase < ?2) group by pas.tipoPase";
		
		TypedQuery<Long> salas = em.createQuery(jpql, Long.class);
		
		salas.setParameter(1,Date.valueOf("2006-06-01"));
		salas.setParameter(2,Date.valueOf("2006-06-30"));
		
		return salas.getResultList();
	}
	
	public List<Pelicula> consulta8(){
		
		String jpql = "SELECT p.pelicula FROM Pase p where ((p.sala.numasiporfilas * p.sala.numfilas) > 100) and (select sum(ent.codentrada) from Entrada ent where p.codpase=ent.pase.codpase) >= (p.sala.numasiporfilas * p.sala.numfilas)*50/100";
		
		TypedQuery<Pelicula> pelis = em.createQuery(jpql, Pelicula.class);
		
		return pelis.getResultList();
	}
	
}
