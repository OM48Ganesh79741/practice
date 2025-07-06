package com.restApi.restApi.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.restApi.restApi.dto.Qsp;
import com.restApi.restApi.repo.Crud;

@org.springframework.stereotype.Service
public class MyService 
{
	@Autowired
	Crud crud;
	
	
	Qsp  person=new Qsp();
	
   public String  read()
   {
	   return "String";
   }
   
//   insert data
    public Qsp insert(Qsp persondto)
    {
    	return crud.save(persondto);
    }
    
    
    //delete by id
    public String deleteMap(String id)
    {
    	Optional<Qsp> p=crud.findById(id);
    	if(p.isPresent())
    	{
    		crud.deleteById(id);
    		return "success";
    	}
    	else
    	{
    		return "not success";
    	}
    	
    	
    }
    
    //update
    
    public Qsp updateResult(String id) {
        Optional<Qsp> optionalPerson = crud.findById(id);
        
        if (optionalPerson.isPresent()) {
            Qsp pdto = optionalPerson.get();
            pdto.setAddress("nashik");
            return crud.save(pdto); // ✅ Save and return updated object
        } else {
            return null; // ❌ not ideal — better to throw exception or custom response
        }
    }

//    Address updated by postman
    
    public String updateAddress(String id,String newarr)
    {
    	Optional<Qsp> pp=crud.findById(id);
    	if(pp.isPresent())
    	{
    		Qsp dto=pp.get();
    		dto.setAddress(newarr);
    		crud.save(dto);
    		return "success";
    	}
    	else
    	{
    		return "false";
    	}
    }
    
    
    //display all data
    public List<Qsp> getAll() {
        return crud.findAll();
    }
    
    public Qsp updateAll(String id, Qsp persondto) {
        Optional<Qsp> optionalPerson = crud.findById(id);
        
        if (optionalPerson.isPresent()) {
            Qsp existingPerson = optionalPerson.get();
            existingPerson.setName(persondto.getName());
            existingPerson.setAddress(persondto.getAddress());
            existingPerson.setSalary(persondto.getSalary());
            return crud.save(existingPerson); // ✅ Return the updated + saved entity
        }

        return null; // Or throw an exception
    }
    
    
    public List<Qsp> insertAll(List<Qsp> persons) {
        return crud.saveAll(persons);
    }


}

