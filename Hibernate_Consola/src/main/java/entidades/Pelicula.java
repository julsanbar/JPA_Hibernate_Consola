package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="PELICULAS",uniqueConstraints = {
		@UniqueConstraint(columnNames = "codpelicula")
})
public class Pelicula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codpelicula")
	private int codpelicula;
	@Column(name="fecha_prod")
	private Date fechaProd;
	@Column(name="genero")
	private String genero;
	@Column(name="titulo", nullable = false)
	private String titulo;

	@OneToMany(mappedBy="pelicula")
	private List<Pase> pases;

	public Pelicula() {
	}

	public int getCodpelicula() {
		return this.codpelicula;
	}

	public void setCodpelicula(int codpelicula) {
		this.codpelicula = codpelicula;
	}

	public Date getFechaProd() {
		return this.fechaProd;
	}

	public void setFechaProd(Date fechaProd) {
		this.fechaProd = fechaProd;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Pase> getPases() {
		return this.pases;
	}

	public void setPases(List<Pase> pases) {
		this.pases = pases;
	}

	public Pase addPas(Pase pase) {
		getPases().add(pase);
		pase.setPelicula(this);

		return pase;
	}

	public Pase removePas(Pase pase) {
		getPases().remove(pase);
		pase.setPelicula(null);

		return pase;
	}

	@Override
	public String toString() {
		return "Pelicula [codpelicula=" + codpelicula + ", fechaProd=" + fechaProd + ", genero=" + genero + ", titulo="
				+ titulo + "]";
	}

}