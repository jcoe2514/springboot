package com.udemy.service;

import java.util.List;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;

public interface ContactService {

	abstract ContactModel save(ContactModel contactModel);

	abstract List<ContactModel> listtAll();

	abstract ContactModel findContactModelById(Integer id);

	abstract Contact findContactById(Integer id);

	abstract void delete(Integer id);

}
