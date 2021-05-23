package JPAControladorDao;

import java.util.List;

import entidades.Pelicula;

public interface PeliculaFacade extends AbstractFacadeJPA<Pelicula> {

	public List<Pelicula> mostrarTodas();
	public List<String> generosNoProyectados(List<Integer> proyectadas);
	public List<String> generosNoProyectadosV2();
	public List<Pelicula> consulta5();
	public List<Pelicula> consulta6();
	public List<Object[]> consulta2();
	
}
