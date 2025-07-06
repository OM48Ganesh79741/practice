package com.restApi.restApi.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.restApi.restApi.Service.MyService;
import com.restApi.restApi.dto.Qsp;

@ResponseBody
@RestController
@RequestMapping("/api")
public class MyController 
{
	@Autowired
	MyService myservice;
	

	@GetMapping("/readtest")
	public String read()
	{
		return myservice.read();
		
	}
	
//	single data
	@PostMapping("/insert")
	public Qsp insert(@RequestBody Qsp person)
	{
		 return myservice.insert(person);
//		 return "succesfull update";
	   	
	
	}
	
//	multiple data
	@PostMapping("/insertall")
	public List<Qsp> insertMultiple(@RequestBody List<Qsp> persons) {
	    return myservice.insertAll(persons);
	}

	
	@DeleteMapping("/delete/{id}")
	public String deletemapping(@PathVariable(value = "id") String id) {
	    try 
	    {
	     return myservice.deleteMap(id); // void return
	     
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "Failed to delete record with ID: " + id;
	    }
	}
	
	@PutMapping("/update/{id}")
	public Qsp updateResult(@PathVariable("id") String id)
	{
	     return myservice.updateResult(id);
	
	}

	 @GetMapping("/readall")
	    public List<Qsp> readAll() {
	        return myservice.getAll();
	    }
	 
	 
//	 imp updated value send by the  postman
	 
	 @PutMapping("/updatecust/{id}")
	 public String  updateAddress(@PathVariable(value="id") String id,@RequestBody Map<String,String> reqb )
	 {
		 String newAddress=reqb.get("address");
          return myservice.updateAddress(id,newAddress);
	 }
	 
	 
// imp for update specific data	 
	 
	 @PutMapping("/updateAll/{id}")
	 public Qsp updateAll(@PathVariable(value="id") String id ,@RequestBody Qsp persondto)
	 {
			return  myservice.updateAll(id,persondto);
	
	 }
}
