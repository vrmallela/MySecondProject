package com.example.ProjectIntakeBackend.repository;

import com.example.ProjectIntakeBackend.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Person, Long> {

}
