package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the profesor database table.
 * 
 */
@Entity
@Table(name="profesor")
@NamedQuery(name="Profesor.findAll", query="SELECT p FROM Profesor p")
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="profesor_id")
	private int profesorId;

	@Temporal(TemporalType.DATE)
	@Column(name="godina_rodjenja")
	private Date godinaRodjenja;

	private String ime;

	private String pol;

	private String prezime;

	private String seminar;

	//bi-directional many-to-one association to Ispit
	@OneToMany(mappedBy="profesor")
	private List<Ispit> ispits;

	//bi-directional many-to-one association to Fakultet
	@ManyToOne
	private Fakultet fakultet;

	//bi-directional many-to-one association to Username
	@OneToMany(mappedBy="profesor")
	private List<Username> usernames;

	public Profesor() {
	}

	public int getProfesorId() {
		return this.profesorId;
	}

	public void setProfesorId(int profesorId) {
		this.profesorId = profesorId;
	}

	public Date getGodinaRodjenja() {
		return this.godinaRodjenja;
	}

	public void setGodinaRodjenja(Date godinaRodjenja) {
		this.godinaRodjenja = godinaRodjenja;
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

	public String getSeminar() {
		return this.seminar;
	}

	public void setSeminar(String seminar) {
		this.seminar = seminar;
	}

	public List<Ispit> getIspits() {
		return this.ispits;
	}

	public void setIspits(List<Ispit> ispits) {
		this.ispits = ispits;
	}

	public Ispit addIspit(Ispit ispit) {
		getIspits().add(ispit);
		ispit.setProfesor(this);

		return ispit;
	}

	public Ispit removeIspit(Ispit ispit) {
		getIspits().remove(ispit);
		ispit.setProfesor(null);

		return ispit;
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
		username.setProfesor(this);

		return username;
	}

	public Username removeUsername(Username username) {
		getUsernames().remove(username);
		username.setProfesor(null);

		return username;
	}

}