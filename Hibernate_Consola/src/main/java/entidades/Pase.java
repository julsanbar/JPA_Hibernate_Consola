package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="PASES",uniqueConstraints = {
		@UniqueConstraint(columnNames = "codpase"),@UniqueConstraint(columnNames = "codsala"),@UniqueConstraint(columnNames = "codpelicula")
})
public class Pase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codpase",unique = true, nullable = false)
	private int codpase;
	@Column(name="fecha_pase", nullable = false)
	private Date fechaPase;
	@Column(name="tipo_pase")
	private String tipoPase;

	@OneToMany(mappedBy="pase")
	private List<Entrada> entradas;

	@ManyToOne
	@JoinColumn(name="codpelicula")
	private Pelicula pelicula;

	@ManyToOne
	@JoinColumn(name="codsala")
	private Sala sala;

	public Pase() {
	}

	public int getCodpase() {
		return this.codpase;
	}

	public void setCodpase(int codpase) {
		this.codpase = codpase;
	}

	public Date getFechaPase() {
		return this.fechaPase;
	}

	public void setFechaPase(Date fechaPase) {
		this.fechaPase = fechaPase;
	}

	public String getTipoPase() {
		return this.tipoPase;
	}

	public void setTipoPase(String tipoPase) {
		this.tipoPase = tipoPase;
	}

	public List<Entrada> getEntradas() {
		return this.entradas;
	}

	public void setEntradas(List<Entrada> entradas) {
		this.entradas = entradas;
	}

	public Entrada addEntrada(Entrada entrada) {
		getEntradas().add(entrada);
		entrada.setPas(this);

		return entrada;
	}

	public Entrada removeEntrada(Entrada entrada) {
		getEntradas().remove(entrada);
		entrada.setPas(null);

		return entrada;
	}

	public Pelicula getPelicula() {
		return this.pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Sala getSala() {
		return this.sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	@Override
	public String toString() {
		return "Pase [codpase=" + codpase + ", fechaPase=" + fechaPase + ", tipoPase=" + tipoPase + ", pelicula="
				+ pelicula + ", sala=" + sala + "]";
	}
	
}