package com.spring_mvc.TeamManagement.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring_mvc.TeamManagement.beans.Team;
import com.spring_mvc.TeamManagement.services.TeamServices;

@Controller
public class HomeController {

	// Redirects to homepage
	@RequestMapping(value = "/")
	public ModelAndView homepage(HttpServletResponse response) throws IOException {
		return new ModelAndView("home");
	}

	// Redirects to insertNewTeam page
	@RequestMapping(value = "/newTeamPage")
	public ModelAndView newTeamPageRedirect() {
		return new ModelAndView("create_new_team");
	}

	// Perform insertion on insertNewTeam page and redirects to home page
	@RequestMapping(value = "/NewTeamData", method = RequestMethod.POST)
	public String insertNewTeamFormData(HttpServletRequest request) {
		TeamServices.addTeam(request);
		return "redirect:/";
	}

	// Redirects to findTeam page
	@RequestMapping("/editTeamPage")
	public ModelAndView findTeamPageRedirect() {
		ModelAndView model = new ModelAndView("/find_team");
		model.addObject("teams", TeamServices.getAllTeams());
		return model;
	}

	// Takes input of teamId from findTeam page and redirects to edit_team page with
	// team data
	@RequestMapping(value = "/getTeamId", method = RequestMethod.POST)
	public ModelAndView editTeamView(HttpServletRequest req) {
		ModelAndView model = null;

		int teamId = Integer.parseInt(req.getParameter("team_id").trim().toString());

		if (req.getParameter("action").equals("update")) {
			model = new ModelAndView("edit_team");
		} else if (req.getParameter("action").equals("delete")) {
			model = new ModelAndView("delete_team");
		}

		// get Team object associated with teamId
		final Team team = TeamServices.getTeam(teamId);

		model.addObject("team_id", teamId);
		model.addObject("team", team);

		return model;
	}

	/**
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/EditTeamData", method = RequestMethod.POST)
	public String updateTeam(HttpServletRequest req) {

		TeamServices.updateTeam(req);
		return "redirect:/";
	}

	@RequestMapping(value = "/DeleteTeamData", method = RequestMethod.POST)
	public String deleteTeam(HttpServletRequest req) {
		int teamId = Integer.parseInt(req.getParameter("team_id").trim().toString());
		TeamServices.removeTeam(teamId);
		return "redirect:/";
	}

}
