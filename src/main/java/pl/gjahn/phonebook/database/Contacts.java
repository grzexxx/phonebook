package pl.gjahn.phonebook.database;

import lombok.Data;
import pl.gjahn.phonebook.model.ContactForm;

import java.util.ArrayList;
import java.util.List;

@Data
public class Contacts {

    static List<ContactForm> contacts = new ArrayList<>();


    public static boolean nameCheck(ContactForm contactForm) {
        for (ContactForm contact : contacts) {
            if (contact.getName().equals(contactForm.getName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean contactAdd(ContactForm contactForm) {
        contacts.add(contactForm);
        return true;
    }

    public static List<ContactForm> printContacts() {
        return contacts;
    }
}
