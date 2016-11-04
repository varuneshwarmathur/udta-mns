/**
 * 
 */
package com.udtamns.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.gpedro.integrations.slack.SlackApi;
import net.gpedro.integrations.slack.SlackMessage;

/**
 * @author mshukl
 *
 */
@Controller
public class SlackController {
		
		private Logger logger = Logger.getLogger(SlackController.class);
		
		@RequestMapping(value = "/persons")
		@ResponseBody
		public void returnMessage(){
			logger.info("Inside Demo Projet");
			SlackApi api = new SlackApi("https://hooks.slack.com/services/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");
			api.call(new SlackMessage("Malay", "Malay's End Date of Assignment in one Month"));
			
		}
		@RequestMapping("/IndiaPeopleReport")
	    public String getIndiaPeople(Model model) {
	        return "IndiaPeopleReport";
	    }
		@RequestMapping("/")
	    public String getHomePage(Model model) {
	        return "index";
	    }
		@RequestMapping("/managerSectionHome")
	    public String getVisaStatus(Model model) {
	        return "managerSectionHome";
	    }
		@RequestMapping("/travelReport")
	    public String getTravelReport(Model model) {
	        return "travelReport";
	    }
}
