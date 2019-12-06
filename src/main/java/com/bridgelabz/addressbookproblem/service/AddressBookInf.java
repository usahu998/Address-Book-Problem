package com.bridgelabz.addressbookproblem.service;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

import java.io.IOException;

public interface AddressBookInf {
    public void createNewAddressBook();
    public void openExistingAddressBook();
    public void saveAddressBook();
    public void saveAddressBookAs();
    public void quitProgram();

}
