package dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import model.Student;

public class StudentDTO {
	
	@NotNull
	private int index;
	@Size(min=2)
	private String ime;
	@Size(min=2)
	private String prezime;
	private String pol;
	private Date godRodjenja;
	
	private String datumS;
	private String sport;
	private String hobi;
	private int fakultet_id;

	
	
	//constructors
	public StudentDTO( int index, String ime, String prezime, String pol, Date godRodjenja, String mesto,
			 String sport, String hobi) {
		super();

		this.index = index;
		this.ime = ime;
		this.prezime = prezime;
		this.pol = pol;
		this.godRodjenja = godRodjenja;


		this.sport = sport;
		this.hobi = hobi;
	}
	
	
	public StudentDTO() {
		super();
	}
	
	public StudentDTO(Student student) {
			setIndex(student.getIndex());
			setSport(student.getSport());
			setHobi(student.getHobi());
			setIme(student.getIme());
			setPrezime(student.getPrezime());
			setPol(student.getPol());
			setGodRodjenja(student.getGodinaRodjenja());
			setDatumS(getGodRodjenja().toString());
			setFakultet_id(student.getFakultet().getFakultetId());
					
	}


	//setters and getters
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getPol() {
		return pol;
	}
	public void setPol(String pol) {
		this.pol = pol;
	}
	public Date getGodRodjenja() {
		return godRodjenja;
	}
	public void setGodRodjenja(Date godRodjenja) {
		this.godRodjenja = godRodjenja;
	}

	
	public String getSport() {
		return sport;
	}
	public void setSport(String sport) {
		this.sport = sport;
	}
	public String getHobi() {
		return hobi;
	}
	public void setHobi(String hobi) {
		this.hobi = hobi;
	}


	@Override
	public String toString() {
		return "StudentDTO [  index=" + index + ", ime=" + ime + ", prezime=" + prezime + ", pol=" + pol
				+ ", godRodjenja=" + godRodjenja  + ", sport="
				+ sport + ", hobi=" + hobi + " fakultet_id "  + fakultet_id+ "]";
	}


	public String getDatumS() {
		return datumS;
	}


	public void setDatumS(String datumS) {
		this.datumS = datumS;
	}




	public int getFakultet_id() {
		return fakultet_id;
	}


	public void setFakultet_id(int fakultet) {
		this.fakultet_id = fakultet;
	}



	
	

}
