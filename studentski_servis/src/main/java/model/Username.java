package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the username database table.
 * 
 */
@Entity
@Table(name="username")
@NamedQuery(name="Username.findAll", query="SELECT u FROM Username u")
public class Username implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="username_id")
	private int usernameId;

	private String password;

	private String username;

	//bi-directional many-to-one association to Profesor
	@ManyToOne
	private Profesor profesor;

	//bi-directional many-to-one association to Student
	@ManyToOne
	private Student student;

	public Username() {
	}

	public int getUsernameId() {
		return this.usernameId;
	}

	public void setUsernameId(int usernameId) {
		this.usernameId = usernameId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
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