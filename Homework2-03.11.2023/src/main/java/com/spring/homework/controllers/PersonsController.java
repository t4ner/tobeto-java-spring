package com.spring.homework.controllers;

import com.spring.homework.models.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/persons") // Bu controllerin kontrol edeceği routeları tanımlamak.
public class PersonsController {
    List<Person> inMemoryList = new ArrayList<>();
    // In Memory DB
    // CRUD => Create,Read,Update,Delete
    @GetMapping // api/persons
        public List<Person> get() {
        return inMemoryList;
    }
    @GetMapping("{id}")
    //path => http://localhost:8080/api/persons/1 => 1 = id
        public Person getById(@PathVariable int id){
        // Lambda Expressions
        // Stream API
        Person person = inMemoryList.stream()
                                    .filter((p)-> p.getId() == id) // 1 Eleman [{}]
                                    .findFirst() // {}
                                    .orElseThrow(); //person Person tipindeyse Persona gönder değilse null.
        return person;
     }
     @GetMapping("getById")
     //query string => http://localhost:8080/api/persons/getById?id=1
    public int getById2(@RequestParam int id){
        return id;
     }

    // @PostMapping
    // public String add(@RequestBody Person person){
    //      return person.getName();
    //}
    @PostMapping
    public String add(@RequestBody Person person){
        inMemoryList.add(person);
        return person.getId()+" ID' li kullanıcı sisteme eklendi.";
     }

    @PutMapping
    public String update(@RequestBody Person updatedPerson){
        Person person = inMemoryList
                .stream()
                // Lambda Expressions
                .filter((p) -> p.getId() == updatedPerson.getId()) // 1 eleman [ {} ]
                .findFirst() // {}
                .orElseThrow();
        person.setAge(updatedPerson.getAge());
        person.setName(updatedPerson.getName());
        person.setSurname(updatedPerson.getSurname());

        return person.getId()+" ID' li kullanıcı güncellendi.";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable int id){
        Person person = inMemoryList
                .stream()
                // Lambda Expressions
                .filter((p) -> p.getId() == id) // 1 eleman [ {} ]
                .findFirst() // {}
                .orElseThrow();
        inMemoryList.remove(person);
        return id+" ID' li kullanıcı silindi.";
    }
}
