package com.abhishek.app.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.app.entities.CountryEntity;
import com.abhishek.app.entities.CountryRowMapper;
import com.abhishek.app.entities.DepartmentEntity;
import com.abhishek.app.entities.DepartmentRowMapper;
import com.abhishek.app.entities.LocationEntity;
import com.abhishek.app.entities.LocationRowMapper;



@RestController
public class Controller {
	
	@Autowired
	private JdbcTemplate  jdbcTemplate;
	
	
	@RequestMapping(value="/getCountries",method=RequestMethod.GET, headers = "Accept=application/json")
	public List<CountryEntity> getCountries(){
		
		String getAllCountrySQL="SELECT COUNTRY_ID,COUNTRY_NAME FROM countries ";
		List<CountryEntity> countryList=(jdbcTemplate.query(getAllCountrySQL,new CountryRowMapper()));
		
		return countryList;
	}
	
	@RequestMapping(value="/getLocations/{countryId}",method=RequestMethod.GET, headers = "Accept=application/json")
	public List<LocationEntity> getLocations(@PathVariable("countryId") String countryId){
		
		String getLocationSQL="SELECT LOCATION_ID,CITY FROM locations where COUNTRY_ID= '"+countryId+"'";
		System.out.println("getLocationSQL---"+getLocationSQL);
		List<LocationEntity> locationList=(jdbcTemplate.query(getLocationSQL,new LocationRowMapper()));
		
		return locationList;
	}
	
	@RequestMapping(value="/getDepartments/{locationId}",method=RequestMethod.GET, headers = "Accept=application/json")
	public List<DepartmentEntity> getDepartments(@PathVariable("locationId") int locationId){
		
		String getDepartmentSQL="SELECT DEPARTMENT_ID,DEPARTMENT_NAME FROM departments where LOCATION_ID="+locationId;
		List<DepartmentEntity> departmentList=(jdbcTemplate.query(getDepartmentSQL,new DepartmentRowMapper()));
		
		return departmentList;
	}
	
	/*@RequestMapping(value="/getAllCustomers",method=RequestMethod.GET, headers = "Accept=application/json")
	public CustomerResponse getAllCustomer(){
		CustomerResponse customerResponse = new CustomerResponse();
		String getAllCustomersSQL="Select id,customer_name from customer ";
		customerResponse.setCustomerEntity(jdbcTemplate.query(getAllCustomersSQL,new CustomerRowMapper()));
		customerResponse.setStatus("Success");
		customerResponse.setMessage("No_Exceptions");
		return customerResponse;
	}*/
	
	/*@RequestMapping(value="/getAllCustomers",method=RequestMethod.GET, headers = "Accept=application/json")
	public List<CustomerEntity> getAllCustomer(){
		CustomerResponse customerResponse = new CustomerResponse();
		String getAllCustomersSQL="Select id,customer_name from customer ";
		List<CustomerEntity> customerList=(jdbcTemplate.query(getAllCustomersSQL,new CustomerRowMapper()));
		
		return customerList;
	}*/

}
