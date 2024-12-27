package br.com.testesUnitarios.service;

import br.com.testesUnitarios.model.Person;

import java.util.concurrent.atomic.AtomicLong;

public class PersonService implements IPersonService {
    @Override
    public Person createPerson(Person person) {
        this.emailValidation(person);

        var id = new AtomicLong().incrementAndGet();
        person.setId(id);
        return person;
    }

    public void emailValidation(Person person){
        if(person.getEmail() == null || person.getEmail().isBlank())
            throw new IllegalArgumentException("Email can´t be null");
    }
}
