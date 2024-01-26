package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.domain.Person;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws JsonProcessingException, IOException {
        List<Person> persons =  new ArrayList<>();
        persons.add(Person.createNewPerson("Denis","Saveliev",30));
        persons.add(Person.createNewPerson("Artem","Saveliev",11));
        persons.add(Person.createNewPerson("Roman","Saveliev",7));

        System.out.println(persons.toString());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("target/persons.json"),persons);
        System.out.println(objectMapper.writeValueAsString(persons));
        List<Person> recoveredPersons = new ArrayList<>();
        recoveredPersons = objectMapper.readValue(new File("target/persons.json"),ArrayList.class);
        System.out.println(recoveredPersons.toString());
    }
}