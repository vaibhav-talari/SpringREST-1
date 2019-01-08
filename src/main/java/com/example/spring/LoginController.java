package com.example.spring;

import org.springframework.web.servlet.ModelAndView;

import com.example.model.Login;

//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
	
	@ModelAttribute("myUser")
    public Login getLoginForm() {
        return new Login();
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)	
	public String login() 
	{
		

		return "login";
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute("myUser") @Valid Login login,BindingResult check,@RequestParam("userName")String role,@RequestParam("password")String pass) {
		System.out.println("User-"+role);
		System.out.println("pass-"+pass);
		
		if(login.getUserName().equalsIgnoreCase("admin") && login.getPassword().equalsIgnoreCase("admin@123"))
		{

			return new ModelAndView("adminmenu");
		}
		else if(login.getUserName().equalsIgnoreCase("user") && login.getPassword().equalsIgnoreCase("user")) 
		{
			return new ModelAndView("usermenu");
		}
		else if(check.hasErrors())
		{
			return new ModelAndView("login");
		}
		else
		{
			return new ModelAndView("failure");
		}
			
	}
	
	@ModelAttribute("Listofcountries")
	public List<String> getCountries()
	{
		List<String> country =new ArrayList<String>();
		country.add("India");
		country.add("USA");
		country.add("China");
		return country;


	}
	
}
