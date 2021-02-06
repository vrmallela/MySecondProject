package com.example.ProjectIntakeBackend.services;

import com.example.ProjectIntakeBackend.model.Person;
import com.example.ProjectIntakeBackend.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {
    private UsersRepository usersRepository;

    public Iterable<Person> list(){
        return usersRepository.findAll();
    }

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Person save(Person request) {
        usersRepository.save(request);
        return request;
    }

    public Optional<Person> view(long id) {
       return usersRepository.findById((long) id);
    }

    public Person update(Person request, Long id) {
        Person updated_request = usersRepository.findById(id).orElse(null);    //pulls the request from the database that needs  to be updated
        updated_request = request;   //Replaces the request from the DB to the new updated request
        usersRepository.save(updated_request);
        return updated_request;
    }

    public void softdelete(Long id){
        Person request = usersRepository.findById(id).orElse(null);
        usersRepository.save(request);
    }

    public void delete(){
        usersRepository.deleteAll();
    }
}
