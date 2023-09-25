package com.springbootapplication.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springbootapplication.entity.Employee;
import com.springbootapplication.service.impl.EmpService;


@Controller
public class EmpController {

	@Autowired
	private EmpService service;
	
	@GetMapping("/")
	public String home(Model m)
	{
		
//	List<Employee> emp = service.getAllEmp();
//	return "m.addAttribute(emp)";
//	
		
		return findPaginated(0,m);
	}
	
	
	@GetMapping("/addemp")
	public String addEmpForm()
	{
		return "add_emp.html";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e,HttpSession session) {
		
		service.addEmp(e);
		
		session.setAttribute("msg", "Employee Added Sucessfully...");
		return "redirect:/";
		
	}
	@GetMapping("/home") 
	   public String homepage() {
		   
		   return "home.html";
	   }
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m){
		
		Employee e= service.getEmpById(id);
	     m.addAttribute("emp",e);
		
		return "edit.html";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e,HttpSession session)
	{
		service.addEmp(e);
		session.setAttribute("msg","Emp data Updated Successfully...");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEMP(@PathVariable int id, HttpSession session) {
		
		service.deleteEmp(id);
		session.setAttribute("msg","Emp data Deleted Successfully...");
		return "redirect:/";
		
   
		
	}
	
	@GetMapping("/page/{pageno}")
	public String findPaginated(@PathVariable int pageno,Model m)
	{
		Page<Employee> emplist= service.getEmpByPaginate(pageno,6);
		m.addAttribute("emp",emplist);
		m.addAttribute("currentPage",pageno);
		m.addAttribute("totalPages",emplist.getTotalPages());
		m.addAttribute("totalItem",emplist.getTotalElements());
		return "index.html";
	}
		
}
