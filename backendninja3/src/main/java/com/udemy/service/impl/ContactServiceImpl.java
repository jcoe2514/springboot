package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.component.ContactConverter;
import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;
import com.udemy.repository.ContactRepository;
import com.udemy.service.ContactService;

@Service(value = "contactService")
public class ContactServiceImpl implements ContactService {

	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;

	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;

	@Override
	public ContactModel save(ContactModel contactModel) {
		Contact contact = contactRepository.save(contactConverter.convertToContactModel(contactModel));
		;

		return contactConverter.contacModelToContact(contact);
	}

	@Override
	public List<ContactModel> listtAll() {
		List<Contact> listConta = contactRepository.findAll();
		List<ContactModel> listContactModel = new ArrayList<ContactModel>();
		for (Contact contact : listConta) {

			listContactModel.add(contactConverter.contacModelToContact(contact));

		}

		return listContactModel;
	}

	@Override
	public Contact findContactById(Integer id) {
		// TODO Auto-generated method stub
		return contactRepository.findById(id);
	}

	public ContactModel findContactModelById(Integer id) {
		return contactConverter.contacModelToContact(contactRepository.findById(id));

	}

	@Override
	public void delete(Integer id) {
		Contact contact = this.findContactById(id);
		if (null != contact)
			contactRepository.delete(contact);

	}

}
