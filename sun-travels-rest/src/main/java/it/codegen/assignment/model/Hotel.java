package it.codegen.assignment.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SS_HOTEL")
public class Hotel
{
	@Id
	@Column(name="ID")
	private int id;

	@Column(name="NAME")
	private String name;


	public int getID() {
		return id;
	}

	public void setID(int id ) {
		this.id = id;
	}

	public String getNAME() {
		return name;
	}

	public void setNAME(String name ) {
		this.name = name;
	}
}
