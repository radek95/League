package com.javafee.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Team")
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private Integer id = null;
	
	@Column(name = "name")
	private String name = null;
	
	@Column(name = "nationality")
	private String nationality = null;
	
	@Column(name = "playerQuantity")
	private Integer playersQuantity = null;
	
	@Column(name = "coach")
	private String coach = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Ustawiłem nazwę drużyny " + name);
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Integer getPlayersQuantity() {
		return playersQuantity;
	}

	public void setPlayersQuantity(Integer playersQuantity) {
		this.playersQuantity = playersQuantity;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

}

