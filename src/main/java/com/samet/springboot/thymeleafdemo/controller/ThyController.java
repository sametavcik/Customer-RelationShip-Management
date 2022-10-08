package com.samet.springboot.thymeleafdemo.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.samet.springboot.thymeleafdemo.entity.Employee;
import com.samet.springboot.thymeleafdemo.service.EmployeeService;

@Controller // uygulamanın ana controller'ı
@RequestMapping("/employees")
public class ThyController {
	
	
	private EmployeeService employeeService;  // employeeService katmanının değişkeni
	
	@Autowired  // constructor dependency injection
	public ThyController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
	

	@GetMapping("/list")  // databasedeki listeyi döndüren link uzantısı 
	public String getList(Model theModel) { 
		
		List<Employee> employees = employeeService.findAll(); // databasedeki verilerin getirilmesi için alt katmana başvurmak
		
		theModel.addAttribute("theemployees", employees); // getirilen listenin modele taşınması
		
		return "list-employees";  // modelin içindeki verilerle geri döndürülerek ilgili sayfanın çağırılması
		
	}
	
	@GetMapping("/showFormAdd")  // yeni kayıt yapan link uzantısı
	public String ShowFromAdd(Model theModel) {
		
		Employee employee = new Employee();  // boş nesnenin oluşturulması
		
		theModel.addAttribute("employee", employee); // nesnenin modele atanması
		
		return "form-employee";  // ilgili ekleme sayfasının döndürülmesi
		
	}
	
	
	@PostMapping("/save")  // update işlemini yapan uzantı(post işlemi ile gönderilen veriyi aldığı için postmapping deniyor)
	public String ShowFromAdd(@ModelAttribute("employee") Employee employee) {  // sayfadan postlanan modelin yakalanması
		
		employeeService.save(employee); // model nesnesinin güncellenmesi

		return "redirect:/employees/list";  // otomatik olarak list uzantısının döndürülmesi
		
	}
	
	@GetMapping("/showFromUpdate") // update yapılacak elemanın bulunması
	public String ShowFromUpdate(@RequestParam("employeeId") int employeeId,Model theModel) {  // id ve boş modelin getirilmesi
		
		Employee employee = employeeService.getById(employeeId); // id'ye göre employee'nin bulunması için alt katmana istek
		theModel.addAttribute("employee",employee);  // employee'nin modele atanması
		
		return "form-employee";  // dolu model bilgisiyle update sayfasının gösterilmesi
		
	}
	
	
	@GetMapping("/delete")  // delete isteği
	public String delete(@RequestParam("employeeId") int employeeId) {  // delete yapılacak id'nin yakalanması
		
		employeeService.deleteById(employeeId);  // employee'nin silinmesi için alt katmana istek
		
		return "redirect:/employees/list";  // listeye geri dönülmesi
		
	}
	
	
	
	
	
	

}
