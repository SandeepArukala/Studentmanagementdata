package com.springbootapplication.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootapplication.entity.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee,Integer>{

}
