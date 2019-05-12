package pl.gjahn.phonebook.model;

import lombok.Data;

@Data
public class ContactForm {
    private String name;
    private String surname;
    private String phoneNum;

    @Override
    public String toString() {
        return "Name: " + name +
                " Surname: " + surname  +
                " Number: " + phoneNum  + " ";
    }
}
