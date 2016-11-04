package com.udtamns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.udtamns.model.Assignment;
import com.udtamns.repository.AssignmentRepository;

@Controller
public class AssignmentController {
	@Autowired
	private AssignmentRepository repository;
	@RequestMapping("/assignHome")
    public String home(Model model) {
		model.addAttribute("personList", repository.findAll());
        return "assignHome";
    }
	@RequestMapping(value ="/addAssignData",  method = RequestMethod.POST)
	public String addAssignment(@ModelAttribute Assignment assignment) {
		repository.save(assignment);
        return "redirect:assignHome";
    }
	@RequestMapping("/updateAssign")
    public String update(@RequestParam(value="oracleid", required=false, defaultValue="51065") String oracleID, Model model) {
		model.addAttribute("personList", repository.findByOracleID(oracleID));
        return "updateAssign";
    }
	@RequestMapping(value ="/updateAssignData",  method = RequestMethod.POST)
	public String updateAssignment(@ModelAttribute Assignment assignment) {
		repository.save(assignment);
        return "redirect:assignHome";
    }
	@RequestMapping("/assignClear")
    public String clear(Model model) {
		repository.deleteAll();
        return "redirect:assignHome";
    }
	@RequestMapping("/assignDelete")
    public String delete(@RequestParam(value="oracleid", required=false, defaultValue="51065") String oracleID, Model model) {
		Assignment assignment =repository.findByOracleID(oracleID);
		repository.delete(assignment);
        return "redirect:assignHome";
    }

}
