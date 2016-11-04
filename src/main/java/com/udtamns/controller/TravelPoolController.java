package com.udtamns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.udtamns.model.TravelPool;
import com.udtamns.repository.TravelPoolRepository;

@Controller
public class TravelPoolController {
	@Autowired
	private TravelPoolRepository repository;
	
	@RequestMapping("/travelPoolHome")
    public String home(Model model) {
		model.addAttribute("personList", repository.findAll());
        return "travelPoolHome";
    }
	@RequestMapping(value ="/addTravelPoolData",  method = RequestMethod.POST)
	public String addAssignment(@ModelAttribute TravelPool travelPool) {
		repository.save(travelPool);
        return "redirect:travelPoolHome";
    }
	@RequestMapping("/updateTravelPool")
    public String update(@RequestParam(value="oracleid", required=false, defaultValue="51065") String oracleID, Model model) {
		model.addAttribute("personList", repository.findByOracleID(oracleID));
        return "updateTravelPool";
    }
	@RequestMapping(value ="/updateTravelPoolData",  method = RequestMethod.POST)
	public String updateAssignment(@ModelAttribute TravelPool travelPool) {
		repository.save(travelPool);
        return "redirect:travelPoolHome";
    }
	@RequestMapping("/travelPoolClear")
    public String clear(Model model) {
		repository.deleteAll();
        return "redirect:travelPoolHome";
    }
	@RequestMapping("/travelPoolDelete")
    public String delete(@RequestParam(value="oracleid", required=false, defaultValue="51065") String oracleID, Model model) {
		TravelPool travelPool =repository.findByOracleID(oracleID);
		repository.delete(travelPool);
        return "redirect:travelPoolHome";
    }
	@RequestMapping("/travelPoolJson")
    public String createJson(Model model) {
		model.addAttribute("developerList", repository.findByDomain("Developer"));
		model.addAttribute("qaList", repository.findByDomain("QA"));
		model.addAttribute("infraList", repository.findByDomain("INFRA"));
		model.addAttribute("sitedevList", repository.findByDomain("Site Dev"));
        return "travelPoolJson";
    }
	@RequestMapping(value ="/testTravelPoolJson",  method = RequestMethod.GET)
	public @ResponseBody String sayHello(@RequestParam(value="domain", required=false, defaultValue="Developer") String domain) {
        List<TravelPool> list = repository.findByDomain(domain);
        String str ="{\"name\": \"India Travel Pool\",\"children\": [{\"name\": \"Developer\",\"children\":[";
        String strDeveloper = "";
        for (TravelPool travelPool : list) {
        	strDeveloper = strDeveloper.concat("," + travelPool.toString());
        }
        strDeveloper = strDeveloper.replaceFirst(",", "");
        str = str.concat(strDeveloper);
        str = str.concat("]},{\"name\": \"QA\",\"children\":[" );
        List<TravelPool> list2 = repository.findByDomain("QA");
        String strQA="";
        for (TravelPool travelPool : list2) {
        	strQA = strQA.concat("," + travelPool.toString());
        }
        strQA = strQA.replaceFirst(",", "");
        str = str.concat(strQA);
        str = str.concat("]},{\"name\": \"INFRA\",\"children\":[" );
        List<TravelPool> list3 = repository.findByDomain("QA");
        String strInfra="";
        for (TravelPool travelPool : list3) {
        	strInfra = strInfra.concat("," + travelPool.toString());
        }
        strInfra = strInfra.replaceFirst(",", "");
        str = str.concat(strInfra);
        str = str.concat("]},{\"name\": \"Site Dev\",\"children\":[" );
        List<TravelPool> list4 = repository.findByDomain("QA");
        String strSiteDev="";
        for (TravelPool travelPool : list4) {
        	strSiteDev = strSiteDev.concat("," + travelPool.toString());
        }
    	strSiteDev = strSiteDev.replaceFirst(",", "");
        str = str.concat(strInfra);
        str = str.concat("]}]}");
		return str;
    }
}
