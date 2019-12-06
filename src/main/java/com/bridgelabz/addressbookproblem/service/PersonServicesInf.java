package com.bridgelabz.addressbookproblem.service;

import com.bridgelabz.addressbookproblem.model.Person;

import java.io.IOException;
import java.util.ArrayList;

public interface PersonServicesInf {
    public Person addPerson(Person person) throws IOException;
    public String editInfo(Person person) throws IOException;
    public void deletePerson(Person person);
    public void sortByLastName(Person person);
    public void sortByZipCode(Person person);
    public void writeIntoJson();
    public void printEntries();
    public ArrayList<Person> fileRead() throws IOException;
}
