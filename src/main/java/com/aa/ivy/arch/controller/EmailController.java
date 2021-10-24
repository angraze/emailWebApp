package com.aa.ivy.arch.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.aa.ivy.arch.model.Email;
import com.aa.ivy.arch.service.EmailService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {

    private static final Logger logger = Logger
            .getLogger(EmailController.class);

    public EmailController() {
        System.out.println("EmailController()");
    }

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/")
    public ModelAndView listEmail(ModelAndView model) throws IOException {
        List<Email> listEmail = emailService.getAllEmails();
        model.addObject("listEmail", listEmail);
        model.setViewName("home");
        return model;
    }

    @RequestMapping(value = "/newEmail", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        Email Email = new Email();
        model.addObject("email", Email);
        model.setViewName("emailForm");
        return model;
    }

    @RequestMapping(value = "/saveEmail", method = RequestMethod.POST)
    public ModelAndView saveEmail(@ModelAttribute Email Email) {
        if (Email.getId() == 0) { // if Email id is 0 then creating the
            // Email other updating the Email
            emailService.addEmail(Email);
        } else {
            emailService.updateEmail(Email);
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/deleteEmail", method = RequestMethod.GET)
    public ModelAndView deleteEmail(HttpServletRequest request) {
        int EmailId = Integer.parseInt(request.getParameter("id"));
        emailService.deleteEmail(EmailId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/editEmail", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int EmailId = Integer.parseInt(request.getParameter("id"));
        Email Email = emailService.getEmail(EmailId);
        ModelAndView model = new ModelAndView("emailForm");
        model.addObject("email", Email);

        return model;
    }    
}
