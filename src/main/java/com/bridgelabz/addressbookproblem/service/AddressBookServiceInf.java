package com.bridgelabz.addressbookproblem.service;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

import java.io.IOException;

public interface AddressBookServiceInf {
    public boolean createNewAddressBook(String files);
    public boolean openExistingAddressBook(String addressBookName) throws IOException;
    public boolean saveAddressBook() throws IOException;
    public boolean saveAddressBookAs(String addressBookName);
    public void quitProgram();

}
