package com.bridgelabz.addressbookproblem.service;

import java.io.File;
import java.io.IOException;

public class AddressBookServiceImp implements AddressBookServiceInf {

    @Override
    public boolean createNewAddressBook(String files) {
        String newDirectoryPath="/home/admin265/IdeaProjects/AddressBookProblem/src/main/java/com/bridgelabz/addressbookproblem/json/";
        File file = new File( newDirectoryPath + files + ".json");
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
    public void openExistingAddressBook() {

    }

    @Override
    public void saveAddressBook() {

    }

    @Override
    public void saveAddressBookAs() {

    }

    @Override
    public void quitProgram() {

    }
}
