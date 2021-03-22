package com.spring.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	private int num1 = 0,num2 = 0;
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="calculate")
	public ModelAndView calculateController(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display");
		
		try {
			num1 = Integer.parseInt(request.getParameter("num1").trim());
			num2 = Integer.parseInt(request.getParameter("num2").trim());
		}catch(NumberFormatException e) {
			System.err.print("NumberFormatException : "+e.getMessage());
			
			mv.addObject("res", "Error : the fields should contain numeric values only and cannot be empty.");
			return mv;
		}
		
		double res;
		
		if(request.getParameter("addition") != null) {
			res = num1 + num2;
		}
		else if(request.getParameter("subtraction") != null) {
			res = num1 - num2;
		}
		else if(request.getParameter("multiplication") != null) {
			res = num1 * num2;
		}
		else
			res = (double)num1 / num2;
		
		
		mv.addObject("res",res);
		return mv;
	}
}
