package com.demo.propertyTax;

import java.util.List;

public interface ContactService {
    String createContact(Contact contact);

    String deleteContact(int index);

    List<Contact> getAllContacts();

    List<Contact> searchContacts(String name, String phoneNumber);

    String updateContact(int index, Contact updatedContact);

    String exportContactsToCSV();
}
