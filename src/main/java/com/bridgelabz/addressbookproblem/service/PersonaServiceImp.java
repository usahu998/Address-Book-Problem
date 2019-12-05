package com.bridgelabz.addressbookproblem.service;

import com.bridgelabz.addressbookproblem.model.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PersonaServiceImp implements PersonServicesInf{
  public static String filepath="/home/admin265/IdeaProjects/AddressBookProblem/src/main/java/com/bridgelabz/addressbookproblem/json/AddressBook.json";
    ArrayList<Person> addPerson = new ArrayList<>();
    @Override
    public Person addPerson(Person personData) throws IOException {
        try {
            addPerson = fileRead();
            addPerson.add(personData);
            writeJson();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personData;
    }
    @Override
    public void editInfo(Person person) {

    }

    @Override
    public void deletePerson(Person person) {

    }

    @Override
    public void sortByLastName(Person person) {

    }

    @Override
    public void sortByZipCode(Person person) {

    }

    @Override
    public void writeJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(addPerson);
        try (FileWriter file = new FileWriter(filepath)) {
            file.write(json);
            System.out.println("written to json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Add person detail:" + json);
    }

    @Override
    public void printEntries() {

    }

    @Override
    public ArrayList<Person> fileRead() throws IOException {
       ObjectMapper objectMapper=new ObjectMapper();
       ArrayList<Person> personList = objectMapper.readValue(new File(filepath), new TypeReference<ArrayList<Person>>() {});
       return personList;
    }
}
