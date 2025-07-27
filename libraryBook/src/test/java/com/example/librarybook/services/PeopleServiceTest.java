package com.example.librarybook.services;

import com.example.librarybook.models.Person;
import com.example.librarybook.repositories.PeopleRepository;
import com.example.librarybook.services.PeopleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class PeopleServiceTest {
    @InjectMocks
    private PeopleService peopleService;
    @Mock
    private PeopleRepository peopleRepository;

    @Test
    void findAll_test() {
        System.out.println("test findAll");
        Person p = new Person("Sergey", 1997);
        List<Person> list = List.of(new Person("Alex", 1987), p);
        System.out.println(list);
        Mockito.when(peopleService.findAll()).thenReturn(list);
        Optional<Person> person = peopleService.getPersonByFullName("Sergey");
        Assertions.assertEquals("Sergey",person.get().getFullName());
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