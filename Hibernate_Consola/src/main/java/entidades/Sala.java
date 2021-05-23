package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="SALAS",uniqueConstraints = {
		@UniqueConstraint(columnNames = "codsala")
})
public class Sala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codsala",unique = true, nullable = false)
	private int codsala;
	@Column(name="numasiporfilas")
	private int numasiporfilas;
	@Column(name="numfilas")
	private int numfilas;
	@Column(name="tipo_sonido")
	private String tipoSonido;

	@OneToMany(mappedBy="sala")
	private List<Pase> pases;

	public Sala() {
	}

	public int getCodsala() {
		return this.codsala;
	}

	public void setCodsala(int codsala) {
		this.codsala = codsala;
	}

	public int getNumasiporfilas() {
		return this.numasiporfilas;
	}

	public void setNumasiporfilas(int numasiporfilas) {
		this.numasiporfilas = numasiporfilas;
	}

	public int getNumfilas() {
		return this.numfilas;
	}

	public void setNumfilas(int numfilas) {
		this.numfilas = numfilas;
	}

	public String getTipoSonido() {
		return this.tipoSonido;
	}

	public void setTipoSonido(String tipoSonido) {
		this.tipoSonido = tipoSonido;
	}

	public List<Pase> getPases() {
		return this.pases;
	}

	public void setPases(List<Pase> pases) {
		this.pases = pases;
	}

	public Pase addPas(Pase pase) {
		getPases().add(pase);
		pase.setSala(this);

		return pase;
	}

	public Pase removePas(Pase pase) {
		getPases().remove(pase);
		pase.setSala(null);

		return pase;
	}

	@Override
	public String toString() {
		return "Sala [codsala=" + codsala + ", numasiporfilas=" + numasiporfilas + ", numfilas=" + numfilas
				+ ", tipoSonido=" + tipoSonido +"]";
	}
	
}