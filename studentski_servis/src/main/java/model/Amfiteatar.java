package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the amfiteatar database table.
 * 
 */
@Entity
@Table(name="amfiteatar")
@NamedQuery(name="Amfiteatar.findAll", query="SELECT a FROM Amfiteatar a")
public class Amfiteatar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="amfiteatar_id")
	private int amfiteatarId;

	private String naziv;

	//bi-directional many-to-one association to Ispit
	@OneToMany(mappedBy="amfiteatar")
	private List<Ispit> ispits;

	public Amfiteatar() {
	}

	public int getAmfiteatarId() {
		return this.amfiteatarId;
	}

	public void setAmfiteatarId(int amfiteatarId) {
		this.amfiteatarId = amfiteatarId;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Ispit> getIspits() {
		return this.ispits;
	}

	public void setIspits(List<Ispit> ispits) {
		this.ispits = ispits;
	}

	public Ispit addIspit(Ispit ispit) {
		getIspits().add(ispit);
		ispit.setAmfiteatar(this);

		return ispit;
	}

	public Ispit removeIspit(Ispit ispit) {
		getIspits().remove(ispit);
		ispit.setAmfiteatar(null);

		return ispit;
	}

}