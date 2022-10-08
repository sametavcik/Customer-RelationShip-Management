package com.samet.springboot.thymeleafdemo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samet.springboot.thymeleafdemo.entity.Employee;

@Repository // repository anotasyonu
public interface EmployeeDAO extends JpaRepository<Employee, Integer>  {  // benzer DAO lar için deegisen tek sey entity olduğu için bunu yaparsak otomatik metotlar eşlenir
		// default 4 işlem JpaRepository Sayesinde sağlanır.
		public List<Employee> findAllByOrderByFirstNameAsc();  // listedeki elemanları ilk adlarına göre sıralayan fonksiyon.(jpaRepository tarafından sağlanır.)
	
}
