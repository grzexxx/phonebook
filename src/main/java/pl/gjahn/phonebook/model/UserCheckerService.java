package pl.gjahn.phonebook.model;

import org.springframework.stereotype.Service;
import pl.gjahn.phonebook.database.Contacts;

@Service
public class UserCheckerService {

    public boolean checkUser(ContactForm contactForm) {

        return Contacts.nameCheck(contactForm);
    }
}
