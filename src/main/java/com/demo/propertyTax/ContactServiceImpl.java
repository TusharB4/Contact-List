package com.demo.propertyTax;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    private List<Contact> contacts = new ArrayList<>();

    @Override
    public String createContact(Contact contact) {
        if (contacts.stream().anyMatch(c -> c.getPhoneNumbers().containsAll(contact.getPhoneNumbers()))) {
            return "Contact with same phone number already exists.";
        }
        contacts.add(contact);
        return "Contact added successfully.";
    }

    @Override
    public String deleteContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
            return "Contact deleted successfully.";
        }
        return "Contact not found.";
    }

    @Override
    public List<Contact> getAllContacts() {
        return contacts;
    }

    @Override
    public List<Contact> searchContacts(String name, String phoneNumber) {
        if (name != null && !name.isEmpty()) {
            return contacts.stream().filter(c -> c.getName().contains(name)).collect(Collectors.toList());
        } else if (phoneNumber != null && !phoneNumber.isEmpty()) {
            return contacts.stream().filter(c -> c.getPhoneNumbers().contains(phoneNumber))
                    .collect(Collectors.toList());
        }
        return contacts;
    }

    @Override
    public String updateContact(int index, Contact updatedContact) {
        if (index >= 0 && index < contacts.size()) {
            Contact existingContact = contacts.get(index);
            existingContact.setName(updatedContact.getName());
            existingContact.setPhoneNumbers(updatedContact.getPhoneNumbers());
            existingContact.setImage(updatedContact.getImage());
            return "Contact updated successfully.";
        }
        return "Contact not found.";
    }

    @Override
    public String exportContactsToCSV() {
        StringBuilder csv = new StringBuilder();
        csv.append("Name,Phone Numbers,Image\n");
        for (Contact contact : contacts) {
            csv.append(contact.getName()).append(",");
            csv.append(String.join(";", contact.getPhoneNumbers())).append(",");
            csv.append(contact.getImage()).append("\n");
        }
        return csv.toString();
    }
}
