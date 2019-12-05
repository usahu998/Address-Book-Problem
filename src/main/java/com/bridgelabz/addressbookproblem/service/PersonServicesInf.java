package com.bridgelabz.addressbookproblem.service;

import com.bridgelabz.addressbookproblem.model.Person;

public interface PersonServicesInf {
    public void addPerson(Person person);
    public void editInfo(Person person);
    public void deletePerson(Person person);
    public void sortByLastName(Person person);
    public void sortByZipCode(Person person);
    public void writeJson();
    public void printEntries();
}
