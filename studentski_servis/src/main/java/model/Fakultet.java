package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fakultet database table.
 * 
 */
@Entity
@Table(name="fakultet")
@NamedQuery(name="Fakultet.findAll", query="SELECT f FROM Fakultet f")
public class Fakultet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fakultet_id")
	private int fakultetId;

	private String naziv;

	private String skraceniza;

	@Column(name="student_index")
	private int studentIndex;

	//bi-directional many-to-one association to Mesto
	@ManyToOne
	private Mesto mesto;

	//bi-directional many-to-one association to Profesor
	@OneToMany(mappedBy="fakultet")
	private List<Profesor> profesors;

	//bi-directional many-to-one association to Student
	@OneToMany(mappedBy="fakultet")
	private List<Student> students;

	public Fakultet() {
	}

	public int getFakultetId() {
		return this.fakultetId;
	}

	public void setFakultetId(int fakultetId) {
		this.fakultetId = fakultetId;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getSkraceniza() {
		return this.skraceniza;
	}

	public void setSkraceniza(String skraceniza) {
		this.skraceniza = skraceniza;
	}

	public int getStudentIndex() {
		return this.studentIndex;
	}

	public void setStudentIndex(int studentIndex) {
		this.studentIndex = studentIndex;
	}

	public Mesto getMesto() {
		return this.mesto;
	}

	public void setMesto(Mesto mesto) {
		this.mesto = mesto;
	}

	public List<Profesor> getProfesors() {
		return this.profesors;
	}

	public void setProfesors(List<Profesor> profesors) {
		this.profesors = profesors;
	}

	public Profesor addProfesor(Profesor profesor) {
		getProfesors().add(profesor);
		profesor.setFakultet(this);

		return profesor;
	}

	public Profesor removeProfesor(Profesor profesor) {
		getProfesors().remove(profesor);
		profesor.setFakultet(null);

		return profesor;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Student addStudent(Student student) {
		getStudents().add(student);
		student.setFakultet(this);

		return student;
	}

	public Student removeStudent(Student student) {
		getStudents().remove(student);
		student.setFakultet(null);

		return student;
	}

}