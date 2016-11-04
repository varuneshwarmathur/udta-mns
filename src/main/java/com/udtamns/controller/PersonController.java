package com.udtamns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.udtamns.model.Person;
import com.udtamns.repository.PersonRepository;

@Controller
public class PersonController {
	@Autowired
	private PersonRepository repository;
	
	@RequestMapping("/home")
    public String home(Model model) {
		model.addAttribute("personList", repository.findAll());
        return "home";
    }
	@RequestMapping(value ="/addData",  method = RequestMethod.POST)
	public String addPerson(@ModelAttribute Person person) {
		repository.save(person);
        return "redirect:home";
    }
	@RequestMapping("/update")
    public String update(@RequestParam(value="oracleid", required=false, defaultValue="51065") String oracleID, Model model) {
		model.addAttribute("personList", repository.findByOracleID(oracleID));
        return "update";
    }
	@RequestMapping(value ="/updateData",  method = RequestMethod.POST)
	public String updatePerson(@ModelAttribute Person person) {
		repository.save(person);
        return "redirect:home";
    }
	@RequestMapping("/clear")
    public String clear(Model model) {
		repository.deleteAll();
        return "redirect:home";
    }
	@RequestMapping("/delete")
    public String delete(@RequestParam(value="oracleid", required=false, defaultValue="51065") String oracleID, Model model) {
		Person person =repository.findByOracleID(oracleID);
		repository.delete(person);
        return "redirect:home";
    }
}
