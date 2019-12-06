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
import java.util.List;

public class PersonaServiceImp implements PersonServicesInf {
    public static String filepath = "/home/admin265/IdeaProjects/AddressBookProblem/src/main/java/com/bridgelabz/addressbookproblem/json/AddressBook.json";
    ArrayList<Person> personInformation = new ArrayList<>();

    @Override
    public boolean addPerson(Person personData) throws IOException {
        try {
            personInformation = fileRead();
            personInformation.add(personData);
            writeIntoJson();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String editInfo(Person person) throws IOException {
        List<Person> personInformation = fileRead();
        for (int i = 0; i < personInformation.size(); i++) {
            if (personInformation.get(i).getFirstName().equals(person.getFirstName())) {
                personInformation.get(i).setLastName(person.getLastName());
                personInformation.get(i).setAddress(person.getAddress());
                personInformation.get(i).setCity(person.getCity());
                personInformation.get(i).setState(person.getState());
                personInformation.get(i).setZip(person.getZip());
                personInformation.get(i).setPhoneNumber(person.getPhoneNumber());
            }
        }
        writeIntoJson();
        return "Edit Successfully";
    }

    @Override
    public Boolean deletePerson(String firstName) throws IOException {
      //  List<Person> personInformation = fileRead();
       // for (Person personInfo:personInformation)
        personInformation.removeIf(addressBook1 -> addressBook1.getFirstName().equals(firstName));
        writeIntoJson();
        return true;
    }

    @Override
    public void sortByLastName(Person person) {

    }

    @Override
    public void sortByZipCode(Person person) {

    }

    @Override
    public void writeIntoJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(personInformation);
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
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Person> personList = objectMapper.readValue(new File(filepath), new TypeReference<ArrayList<Person>>() {
        });
        return personList;
    }
}
