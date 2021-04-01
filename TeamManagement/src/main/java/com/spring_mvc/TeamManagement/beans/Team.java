package com.spring_mvc.TeamManagement.beans;

public class Team {
	private String name, country, league;

	public Team() {
	}

	/**
	 * @param name
	 * @param country
	 * @param league
	 */
	public Team(String name, String country, String league) {
		super();
		this.name = name;
		this.country = country;
		this.league = league;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public String getLeague() {
		return league;
	}

	public String toString() {
		return "{ " + name + ", " + country + ", " + league + " }";
	}
}
