package pl.gjahn.phonebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.gjahn.phonebook.database.Contacts;
import pl.gjahn.phonebook.model.ContactForm;
import pl.gjahn.phonebook.model.UserCheckerService;

@Controller
public class PhoneBookController {

    @Autowired
    UserCheckerService userCheckerService;

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @GetMapping("/add_form")
    public String addForm(Model model) {
        model.addAttribute("ContactForm", new ContactForm());

        return "add_form";
    }

    @GetMapping("/print_contacts")
    public String printContacts(Model model) {

        model.addAttribute("print_form", Contacts.printContacts());

        return "print_form";
    }

    @PostMapping("/add_form")
    public String addForm(@ModelAttribute ContactForm contactForm, Model model) {

        if (userCheckerService.checkUser(contactForm)) {
            return "blind_way";
        } else {
            Contacts.contactAdd(contactForm);
            model.addAttribute("contactForm", contactForm);

            return "hello";
        }
    }


}
