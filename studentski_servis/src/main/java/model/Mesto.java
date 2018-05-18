package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mesto database table.
 * 
 */
@Entity
@Table(name="mesto")
@NamedQuery(name="Mesto.findAll", query="SELECT m FROM Mesto m")
public class Mesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mesto_id")
	private int mestoId;

	private String naziv;

	@Column(name="postanski_broj")
	private int postanskiBroj;

	//bi-directional many-to-one association to Fakultet
	@OneToMany(mappedBy="mesto")
	private List<Fakultet> fakultets;

	public Mesto() {
	}

	public int getMestoId() {
		return this.mestoId;
	}

	public void setMestoId(int mestoId) {
		this.mestoId = mestoId;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getPostanskiBroj() {
		return this.postanskiBroj;
	}

	public void setPostanskiBroj(int postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}

	public List<Fakultet> getFakultets() {
		return this.fakultets;
	}

	public void setFakultets(List<Fakultet> fakultets) {
		this.fakultets = fakultets;
	}

	public Fakultet addFakultet(Fakultet fakultet) {
		getFakultets().add(fakultet);
		fakultet.setMesto(this);

		return fakultet;
	}

	public Fakultet removeFakultet(Fakultet fakultet) {
		getFakultets().remove(fakultet);
		fakultet.setMesto(null);

		return fakultet;
	}

}