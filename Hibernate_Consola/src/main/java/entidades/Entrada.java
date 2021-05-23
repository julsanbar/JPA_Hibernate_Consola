package entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="ENTRADAS",uniqueConstraints = {
		@UniqueConstraint(columnNames = "codentrada"), @UniqueConstraint(columnNames = "codpase")
})
public class Entrada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codentrada", nullable = false, unique = true)
	private int codentrada;
	@Column(name = "comprador")
	private String comprador;
	@Column(name = "numenfila")
	private int numenfila;
	@Column(name = "numfila")
	private int numfila;
	@Column(name = "pvp")
	private int pvp;
	@Column(name = "vendido")
	private char vendido;

	@ManyToOne
	@JoinColumn(name="codpase")
	private Pase pase;

	public Entrada() {
	}

	public int getCodentrada() {
		return this.codentrada;
	}

	public void setCodentrada(int codentrada) {
		this.codentrada = codentrada;
	}

	public String getComprador() {
		return this.comprador;
	}

	public void setComprador(String comprador) {
		this.comprador = comprador;
	}

	public int getNumenfila() {
		return this.numenfila;
	}

	public void setNumenfila(int numenfila) {
		this.numenfila = numenfila;
	}

	public int getNumfila() {
		return this.numfila;
	}

	public void setNumfila(int numfila) {
		this.numfila = numfila;
	}

	public int getPvp() {
		return this.pvp;
	}

	public void setPvp(int pvp) {
		this.pvp = pvp;
	}

	public char getVendido() {
		return this.vendido;
	}

	public void setVendido(char vendido) {
		this.vendido = vendido;
	}

	public Pase getPas() {
		return this.pase;
	}

	public void setPas(Pase pase) {
		this.pase = pase;
	}

	@Override
	public String toString() {
		return "Entrada [codentrada=" + codentrada + ", comprador=" + comprador + ", numenfila=" + numenfila
				+ ", numfila=" + numfila + ", pvp=" + pvp + ", vendido=" + vendido + ", pase=" + pase + "]";
	}

	
	
}