package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ispit database table.
 * 
 */
@Entity
@Table(name="ispit")
@NamedQuery(name="Ispit.findAll", query="SELECT i FROM Ispit i")
public class Ispit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ispit_id")
	private int ispitId;

	@Column(name="naziv_ispita")
	private String nazivIspita;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="vreme_polaganja")
	private Date vremePolaganja;

	//bi-directional many-to-one association to Amfiteatar
	@ManyToOne
	private Amfiteatar amfiteatar;

	//bi-directional many-to-one association to Predmet
	@ManyToOne
	private Predmet predmet;

	//bi-directional many-to-one association to Profesor
	@ManyToOne
	private Profesor profesor;

	//bi-directional many-to-one association to Student
	@ManyToOne
	private Student student;

	public Ispit() {
	}

	public int getIspitId() {
		return this.ispitId;
	}

	public void setIspitId(int ispitId) {
		this.ispitId = ispitId;
	}

	public String getNazivIspita() {
		return this.nazivIspita;
	}

	public void setNazivIspita(String nazivIspita) {
		this.nazivIspita = nazivIspita;
	}

	public Date getVremePolaganja() {
		return this.vremePolaganja;
	}

	public void setVremePolaganja(Date vremePolaganja) {
		this.vremePolaganja = vremePolaganja;
	}

	public Amfiteatar getAmfiteatar() {
		return this.amfiteatar;
	}

	public void setAmfiteatar(Amfiteatar amfiteatar) {
		this.amfiteatar = amfiteatar;
	}

	public Predmet getPredmet() {
		return this.predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}