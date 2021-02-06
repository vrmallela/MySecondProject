package com.example.ProjectIntakeBackend.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RequestNotFoundException  extends RuntimeException{
    public RequestNotFoundException(Long id) {
        super(String.valueOf(id));
        // TODO Auto-generated constructor stub
    }

    public String emptyDatabse ()
    {
        return "Databse is empty";
    }
}
