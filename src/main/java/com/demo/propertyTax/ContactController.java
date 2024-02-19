package com.demo.propertyTax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/save")
    public String createContact(@RequestBody Contact contact) {
        return contactService.createContact(contact);
    }

    @DeleteMapping("/{index}")
    public String deleteContact(@PathVariable int index) {
        return contactService.deleteContact(index);
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/search")
    public List<Contact> searchContacts(@RequestParam(required = false) String name,
            @RequestParam(required = false) String phoneNumber) {
        return contactService.searchContacts(name, phoneNumber);
    }

    @PutMapping("/{index}")
    public String updateContact(@PathVariable int index, @RequestBody Contact updatedContact) {
        return contactService.updateContact(index, updatedContact);
    }

    @GetMapping("/export/csv")
    public String exportContactsToCSV() {
        return contactService.exportContactsToCSV();
    }
}
