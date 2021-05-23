package JPAControladorDao;

import java.util.List;

import javax.persistence.TypedQuery;

import entidades.Pelicula;

public class PeliculaFacadeImpl extends AbstractFacadeJPAImpl<Pelicula> implements PeliculaFacade{

	public PeliculaFacadeImpl() {
		super(Pelicula.class);
	}

	@Override
	public List<Pelicula> mostrarTodas() {
		
		TypedQuery<Pelicula> peliculas = em.createQuery("SELECT p FROM Pelicula AS p",Pelicula.class);
		
		return peliculas.getResultList();
	}

	public List<String> generosNoProyectados(List<Integer> proyectadas) {
				
		String jpql = "SELECT DISTINCT(p.genero) FROM Pelicula p WHERE p.codpelicula NOT IN(:proyecciones)";
		
		TypedQuery<String> peliculas = em.createQuery(jpql,String.class);
		
		peliculas.setParameter("proyecciones", proyectadas);
		
		return peliculas.getResultList();
	}

	public List<String> generosNoProyectadosV2(){

		String jpql = "SELECT DISTINCT(p.genero) FROM Pelicula p WHERE p.codpelicula NOT IN(SELECT DISTINCT(pase.pelicula.codpelicula) FROM Pase pase)";

		TypedQuery<String> peliculas = em.createQuery(jpql,String.class);

		return peliculas.getResultList();
	}

	public List<Pelicula> consulta5() {
		
		String jpql = "SELECT pase.pelicula FROM Pase pase WHERE pase.sala.tipoSonido = :sonido";
		
		TypedQuery<Pelicula> peliculas = em.createQuery(jpql, Pelicula.class);
		
		peliculas.setParameter("sonido", "DOLBY");
		
		return peliculas.getResultList();
	}
	
	public List<Pelicula> consulta6() {
		
		String jpql = "SELECT p FROM Pelicula p where (select count(pas.codpase) from Pase pas where p.codpelicula = pas.pelicula.codpelicula) > 5";
		
		TypedQuery<Pelicula> peliculas = em.createQuery(jpql, Pelicula.class);
		
		return peliculas.getResultList();
	}

	@Override
	public List<Object[]> consulta2() {
		
		String jpql = "SELECT p.titulo, p.codpelicula, (select count(pas.codpase) from Pase pas where pas.pelicula.codpelicula = p.codpelicula), (select sum(ent.pvp) from Entrada ent where ent.pase.pelicula.codpelicula = p.codpelicula) * (select count(pas.codpase) from Pase pas where pas.pelicula.codpelicula = p.codpelicula)  FROM Pelicula p";
		
		TypedQuery<Object[]> campos = em.createQuery(jpql, Object[].class);
		
		return campos.getResultList();
	}
	
}
