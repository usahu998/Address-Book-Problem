package com.bridgelabz.addressbookproblem.service;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

import java.io.IOException;

public interface AddressBookServiceInf {
    public boolean createNewAddressBook(String files);
    public boolean openExistingAddressBook(String addressBookName) throws IOException;
    public void saveAddressBook();
    public void saveAddressBookAs();
    public void quitProgram();

}
