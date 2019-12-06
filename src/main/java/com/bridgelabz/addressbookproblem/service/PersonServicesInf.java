package com.bridgelabz.addressbookproblem.service;

import com.bridgelabz.addressbookproblem.model.Person;

import java.io.IOException;
import java.util.ArrayList;

public interface PersonServicesInf {
    public boolean addPerson(Person person) throws IOException;
    public boolean editInfo(Person person,String firstName) throws IOException;
    public boolean deletePerson(String firstName) throws IOException;
    public void sortByLastName(Person person);
    public void sortByZipCode(Person person);
    public void writeIntoJson(ArrayList<Person> list);
    public void printEntries();
    public ArrayList<Person> fileRead() throws IOException;
}
