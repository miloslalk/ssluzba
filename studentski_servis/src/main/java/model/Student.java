package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@Table(name="student")
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int index;

	@Temporal(TemporalType.DATE)
	@Column(name="godina_rodjenja")
	private Date godinaRodjenja;

	private String hobi;

	private String ime;

	private String pol;

	private String prezime;

	private String sport;

	//bi-directional many-to-one association to Ispit
	@OneToMany(mappedBy="student")
	private List<Ispit> ispits;

	//bi-directional many-to-one association to Predmet
	@OneToMany(mappedBy="student")
	private List<Predmet> predmets;

	//bi-directional many-to-one association to Fakultet
	@ManyToOne
	private Fakultet fakultet;

	//bi-directional many-to-one association to Username
	@OneToMany(mappedBy="student")
	private List<Username> usernames;

	public Student() {
	}

	public int getIndex() {
		return this.index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Date getGodinaRodjenja() {
		return this.godinaRodjenja;
	}

	public void setGodinaRodjenja(Date godinaRodjenja) {
		this.godinaRodjenja = godinaRodjenja;
	}

	public String getHobi() {
		return this.hobi;
	}

	public void setHobi(String hobi) {
		this.hobi = hobi;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPol() {
		return this.pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getSport() {
		return this.sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public List<Ispit> getIspits() {
		return this.ispits;
	}

	public void setIspits(List<Ispit> ispits) {
		this.ispits = ispits;
	}

	public Ispit addIspit(Ispit ispit) {
		getIspits().add(ispit);
		ispit.setStudent(this);

		return ispit;
	}

	public Ispit removeIspit(Ispit ispit) {
		getIspits().remove(ispit);
		ispit.setStudent(null);

		return ispit;
	}

	public List<Predmet> getPredmets() {
		return this.predmets;
	}

	public void setPredmets(List<Predmet> predmets) {
		this.predmets = predmets;
	}

	public Predmet addPredmet(Predmet predmet) {
		getPredmets().add(predmet);
		predmet.setStudent(this);

		return predmet;
	}

	public Predmet removePredmet(Predmet predmet) {
		getPredmets().remove(predmet);
		predmet.setStudent(null);

		return predmet;
	}

	public Fakultet getFakultet() {
		return this.fakultet;
	}

	public void setFakultet(Fakultet fakultet) {
		this.fakultet = fakultet;
	}

	public List<Username> getUsernames() {
		return this.usernames;
	}

	public void setUsernames(List<Username> usernames) {
		this.usernames = usernames;
	}

	public Username addUsername(Username username) {
		getUsernames().add(username);
		username.setStudent(this);

		return username;
	}

	public Username removeUsername(Username username) {
		getUsernames().remove(username);
		username.setStudent(null);

		return username;
	}

}