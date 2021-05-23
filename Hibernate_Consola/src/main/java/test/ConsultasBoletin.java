package test;

import java.sql.Date;
import java.util.List;

import JPAControladorDao.PaseFacadeImpl;
import JPAControladorDao.PeliculaFacadeImpl;
import JPAControladorDao.SalaFacadeImpl;
import entidades.Pase;
import entidades.Pelicula;
import entidades.Sala;

public class ConsultasBoletin {

	public static void main(String[] args) {
		
		PeliculaFacadeImpl pf = new PeliculaFacadeImpl();
		PaseFacadeImpl pases  = new PaseFacadeImpl();
		SalaFacadeImpl sf = new SalaFacadeImpl();
		
		System.out.println(" ");
		System.out.println("---->>>>  CONSULTA 1 v1(P.DINÁMICO) <<<<-----");
		System.out.println(" ");

		List<Integer> proyectadas = pases.peliculasProyectadas();
		List<String> peliculasc1v1 = pf.generosNoProyectados(proyectadas);
		
		for(String peli: peliculasc1v1) {
			
			System.out.println(peli);
			
		}
		
		System.out.println(" ");
		System.out.println("---->>>>  CONSULTA 1 v2(P.DINÁMICO) <<<<-----");
		System.out.println(" ");		

		List<String> peliculasc1v2 = pf.generosNoProyectadosV2();
		
		for(String peli: peliculasc1v2) {
			
			System.out.println(peli);
			
		}
		
		System.out.println(" ");
		System.out.println("---->>>>  CONSULTA 2(COLECCIONES) <<<<-----");
		System.out.println(" ");		

		List<Pelicula> peliculasc2v1 = pf.mostrarTodas();
		
		for(Pelicula peli: peliculasc2v1) {
			
			System.out.println(peli.getTitulo()+" "+peli.getCodpelicula()+" "+peli.getPases().size()+" ");
			
		}

		System.out.println(" ");
		System.out.println("---->>>>  CONSULTA 2 v2(P.DINÁMICO) <<<<-----");
		System.out.println(" ");		

		List<Object[]> peliculasc2v2 = pf.consulta2();
		
		for(Object[] peli: peliculasc2v2) {
			
			System.out.println(peli[0]+" "+peli[1]+" "+peli[2]+" "+peli[3]);
			
		}
		
		System.out.println(" ");
		System.out.println("---->>>>  CONSULTA 3v1(COLECCIONES) <<<<-----");
		System.out.println(" ");		

		List<Sala> salasc3v1 = sf.mostratTodos();
		String genero = "COMEDIA";
		int con = 0;
		
		for(int i=0;i<salasc3v1.size();i++) {
			
			List<Pase> pas = salasc3v1.get(i).getPases();
			
			for(Pase p:pas) {
				
				if(p.getPelicula().getGenero().equals(genero)) {
					con++;
				}
				
			}
			
		}
		
		System.out.println("PELICULAS GÉNERO "+genero+" "+con);

		System.out.println(" ");
		System.out.println("---->>>>  CONSULTA 3v2(P.DINÁMICO) <<<<-----");
		System.out.println(" ");		
		
		List<Long> salasc3v2 = pases.consulta3("COMEDIA");
		
		for(Long sal:salasc3v2) {
			System.out.println(sal);
		}
		
		
		System.out.println(" ");
		System.out.println("---->>>>  CONSULTA 4(P.DINÁMICO) <<<<-----");
		System.out.println(" ");		
		
		List<Sala> salasc4 = sf.consulta4(Date.valueOf("2007-12-31"));
		
		for(Sala sal:salasc4) {
			System.out.println(sal);
		}
		
		System.out.println(" ");
		System.out.println("---->>>>  CONSULTA 5(P.DINÁMICO) <<<<-----");
		System.out.println(" ");		
		
		List<Pelicula> peli5 = pf.consulta5();
		
		for(Pelicula p:peli5) {
			System.out.println(p);
		}
		
		System.out.println(" ");
		System.out.println("---->>>>  CONSULTA 6(P.DINÁMICO) <<<<-----");
		System.out.println(" ");		
		
		List<Pelicula> peli6 = pf.consulta6();
		
		for(Pelicula p:peli6) {
			System.out.println(p);
		}
		
		System.out.println(" ");
		System.out.println("---->>>>  CONSULTA 7(P.DINÁMICO) <<<<-----");
		System.out.println(" ");		
		
		List<Long> peli7 = pases.consulta7();
		
		for(Long p:peli7) {
			System.out.println(p);
		}		

		System.out.println(" ");
		System.out.println("---->>>>  CONSULTA 8(P.DINÁMICO) <<<<-----");
		System.out.println(" ");		
		
		List<Pelicula> peli8 = pases.consulta8();
		
		for(Pelicula p:peli8) {
			System.out.println(p);
		}
		
	}

}
