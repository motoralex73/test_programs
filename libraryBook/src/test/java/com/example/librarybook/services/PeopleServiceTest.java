package com.example.librarybook.services;

import com.example.librarybook.models.Person;
import com.example.librarybook.repositories.PeopleRepository;
import com.example.librarybook.services.PeopleService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.Iterator;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class PeopleServiceTest {
    @InjectMocks
    private PeopleService peopleService;
    @Mock
    private PeopleRepository peopleRepository;

//    PeopleServiceTest(PeopleService peopleService, PeopleRepository peopleRepository) {
//        this.peopleService = peopleService;
//        this.peopleRepository = peopleRepository;
//    }

    @Test
    void findAll() {
        System.out.println("test findAll");
        List<Person> list = List.of(new Person("Alex", 1987),new Person("Sergey", 1997));
        System.out.println(list);
        //Mockito.when(peopleService.findAll()).thenReturn(list);
    }

    @Test
    void findOne() {

    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getPersonByFullName() {
    }

    @Test
    void getBooksByPersonId() {
    }
}