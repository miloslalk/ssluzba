package dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import model.Profesor;

public class ProfesorDTO {
	@NotNull
	private int id;
	@Size(min=2)
	private String ime;
	@Size(min=2)
	private String prezime;
	private String pol;
	private Date godRodjenja;
	private String mesto;
	private int postanskiBroj;
	private String seminar;
	
	
	
	//constructors
	public ProfesorDTO(int id, String ime, String prezime, String pol, Date godRodjenja, String mesto,
			int postanskiBroj, String seminar) {
		super();
		this.id = id;

		this.ime = ime;
		this.prezime = prezime;
		this.pol = pol;
		this.godRodjenja = godRodjenja;
		this.mesto = mesto;
		this.postanskiBroj = postanskiBroj;
		this.seminar = seminar;
	}
	/*
	public ProfesorDTO(Profesor profesor, Osoba osoba) {
		if(profesor.getId()==osoba.getId()) {
			
			setId(osoba.getId());
			setIme(osoba.getIme());
			setPrezime(osoba.getPrezime());
			setPol(osoba.getPol());
			setGodRodjenja(osoba.getGodRodjenja());
			setMesto(osoba.getMesto());
			setPostanskiBroj(osoba.getPostanskiBr());
			setSeminar(profesor.getSeminar());
			
			
		}
		
	}*/
	
	public ProfesorDTO() {
		super();
	}



	//setters and getters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	public String getMesto() {
		return mesto;
	}
	public void setMesto(String mesto) {
		this.mesto = mesto;
	}
	public int getPostanskiBroj() {
		return postanskiBroj;
	}
	public void setPostanskiBroj(int postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}
	public String getSeminar() {
		return seminar;
	}
	public void setSeminar(String seminar) {
		this.seminar = seminar;
	}
	
}
