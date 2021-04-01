package com.spring_mvc.TeamManagement.services;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.spring_mvc.TeamManagement.beans.Team;

public class TeamServices {
	private static HashMap<Integer, Team> teams;
	private static int ID;

	static {
		ID = 0;
				
		teams = new HashMap<Integer, Team>();
		teams.put(getNextId(), new Team("FC Barcelona", "Spain", "La Liga"));
		teams.put(getNextId(), new Team("Manchester United", "England", "Premier League"));
		teams.put(getNextId(), new Team("Mumbai City FC", "India", "Indian Super League"));
	}

	
	//Add new team 
	public static void addTeam(HttpServletRequest req) {
		Team team = new Team();
		team.setName(req.getParameter("team_name"));
		team.setCountry(req.getParameter("country"));
		team.setLeague(req.getParameter("league"));
		teams.put(getNextId(), team);
	}

	// returns next Id
	private static int getNextId() {
		System.out.println("ID : "+ID);
		return ++ID;
	}

	// Return object containing all the teams
	public static HashMap<Integer, Team> getAllTeams() {
		return teams;
	}

	//Return a team associated with teamId
	public static final Team getTeam(int teamId) {
		final Team team;
		if (teams.containsKey(teamId))
			team = teams.get(teamId);
		else
			team = null;

		return team;
	}

	//Update data of a team
	public static final Team updateTeam(HttpServletRequest req) {
		final Team team = new Team();
		int teamId = Integer.parseInt(req.getParameter("team_id").trim());
		team.setName(req.getParameter("team_name"));
		team.setCountry(req.getParameter("country"));
		team.setLeague(req.getParameter("league"));

		teams.put(teamId, team);
		return team;
	}

	//Delete a team
	public static int removeTeam(int teamId) {
		teams.remove(teamId);
		return 1;
	}
}
