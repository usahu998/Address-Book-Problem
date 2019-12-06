package com.bridgelabz.addressbookproblem.service;

import com.bridgelabz.addressbookproblem.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AddressBookServiceImp implements AddressBookServiceInf {
    public static String newDirectoryPath = "/home/admin265/IdeaProjects/AddressBookProblem/src/main/java/com/bridgelabz/addressbookproblem/json/";

    @Override
    public boolean createNewAddressBook(String files) {

        File file = new File(newDirectoryPath + files + ".json");
        boolean existence = file.exists();
        if (existence) {
            System.out.println("File already Exist");
            return true;
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean openExistingAddressBook(String addressBookName) throws IOException {
        ObjectMapper map = new ObjectMapper();
        File file = new File(newDirectoryPath+ addressBookName + ".json");
        FileReader file1 = new FileReader(file);
        BufferedReader br = new BufferedReader(file1);
        boolean existence = file.exists();
        if (existence) {
            return true;
        }
        return false;
    }

    @Override
    public boolean saveAddressBook() throws IOException {
       try {
           PersonServicesInf personServicesInf = new PersonaServiceImp();
           ArrayList<Person> personInformation = personServicesInf.fileRead();
           personServicesInf.writeIntoJson(personInformation);
           return true;
       } catch (IOException e) {
           e.printStackTrace();
       }
        return false;
    }

    @Override
    public void saveAddressBookAs() {

    }

    @Override
    public void quitProgram() {

    }
}
