package com.samet.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.samet.springboot.thymeleafdemo.dao.EmployeeDAO;
import com.samet.springboot.thymeleafdemo.entity.Employee;


@Service  // service anatasyonu
public class EmployeeServiceImpl implements EmployeeService {  // controllerdan isteklerin yapıldığı service
	
	private EmployeeDAO empDao;  // database repository'sinin değişkeni
	
	@Autowired  // constructor dependency injection
	public EmployeeServiceImpl(EmployeeDAO empDao) {
		this.empDao = empDao;
	}
	
	
	@Override
	public List<Employee> findAll() {
		
		return empDao.findAllByOrderByFirstNameAsc(); // eleman sıralama
	}

	@Override
	public Employee getById(int employeeId) {  // id'ye göre getirme
		Optional<Employee> result = empDao.findById(employeeId); // optional null kontrolüdür
		Employee employee =null;
		if(result.isPresent()) {
			employee = result.get();
		}else {
			throw new RuntimeException("Employee is not found "+ employeeId);
		}
		
		return employee;
	}

	@Override
	public void deleteById(int employeeId) {  // elemanın silinmesi
		empDao.deleteById(employeeId);

	}

	@Override
	public void save(Employee employee) { // elemanın güncellenmesi
		empDao.save(employee);

	}

}
