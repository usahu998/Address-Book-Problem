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
            writeIntoJson(personInformation);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean editInfo(Person person, String firstName) throws IOException {
        ArrayList<Person> personInformation = fileRead();

        for (Person personInfo : personInformation) {
            if (personInfo.getFirstName().equals(firstName)) {

                personInfo.setLastName(person.getLastName());
                personInfo.setAddress(person.getAddress());
                personInfo.setCity(person.getCity());
                personInfo.setState(person.getState());
                personInfo.setZip(person.getZip());
                personInfo.setPhoneNumber(person.getPhoneNumber());

            }
        }
        writeIntoJson(personInformation);
        return true;
    }

    @Override
    public boolean deletePerson(String firstName) throws IOException {
        ArrayList<Person> personInformation = fileRead();
        personInformation.removeIf(personDetail -> personDetail.getFirstName().equals(firstName));
        writeIntoJson(personInformation);
        return true;
    }

    @Override
    public void sortByLastName(Person person) {

    }

    @Override
    public void sortByZipCode(Person person) {

    }

    @Override
    public void writeIntoJson(ArrayList<Person> list) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(list);
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
