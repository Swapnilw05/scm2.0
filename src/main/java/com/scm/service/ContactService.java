package com.scm.service;

import java.util.List;

import com.scm.entities.Contact;

public interface ContactService {

    // save contacts
    Contact save(Contact contact);

    // update
    Contact update(Contact contact);

    // get all contacts
    List<Contact> getAll();

    // get contact by id
    Contact getById(String id);

    // delete contact
    void delete(String id);

    // search contact
    List<Contact> search(String name, String email, String phoneNumber);

    // get contacts by userId
    List<Contact> getByUserId(String userId);
    

}
