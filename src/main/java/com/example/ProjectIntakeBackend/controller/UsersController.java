package com.example.ProjectIntakeBackend.controller;

import com.example.ProjectIntakeBackend.error.RequestNotFoundException;
import com.example.ProjectIntakeBackend.model.Person;
import com.example.ProjectIntakeBackend.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
public class UsersController {

    @Autowired
    private UsersService service;

    public UsersController(UsersService service) {      //Constructor
        this.service = service;
    }
    
    @CrossOrigin
    @GetMapping(value = "/view_user/{id}")
    public Person view(@PathVariable Long id)
    {
        return service.view(id).orElseThrow(() -> new RequestNotFoundException(id));
    }
    
    @CrossOrigin
    @GetMapping(value = "/get_users")
    public Iterable<Person> list(){
        Iterable<Person> request = service.list();
        return request;
    }

    @CrossOrigin
    @PostMapping(value="/insert/users", consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    public String create(@RequestBody Person user) throws ParseException {
		service.save(user);
		return "Saved Successfully";
	}
}
