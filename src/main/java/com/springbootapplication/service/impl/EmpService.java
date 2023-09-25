package com.springbootapplication.service.impl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springbootapplication.Dao.EmpRepository;
import com.springbootapplication.entity.Employee;

@Service
public class EmpService {
	
	@Autowired
	private EmpRepository repo;
	
	public void addEmp(Employee e) {
		repo.save(e);
	} 
	
	public List<Employee> getAllEmp(){
		return repo.findAll();
		
	}
	
	public Employee getEmpById(int id) {
		
		Optional<Employee> e = repo.findById(id);
		if(e.isPresent()) {
			return e.get();
		}
		return null;
	}

	public void deleteEmp(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}


	public Page<Employee> getEmpByPaginate(int currentpage, int size){
		
		Pageable p =PageRequest.of(currentpage, size);
		
		return repo.findAll(p);
	}
	

}
