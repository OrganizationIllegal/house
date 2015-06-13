package com.kate.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;




import com.kate.app.service.RecoProjectSerivice;

@Controller
public class RecoProjectController {
	@Autowired
	private RecoProjectSerivice recoprojectSerivice;
	
	//@RequestMapping({ "/", "/RecoProject" })
	/*public String getreco(HttpServletRequest req,HttpServletResponse resp){
		String projectdescription=recoprojectSerivice.getProjectdescription();
		System.out.println(projectdescription+"ssssss");
		
		
		req.setAttribute("projectdescription",projectdescription);
		return "index.jsp";
	}*/

}
