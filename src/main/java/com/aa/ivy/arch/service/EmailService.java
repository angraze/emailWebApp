package com.aa.ivy.arch.service;

import com.aa.ivy.arch.model.Email;

import java.util.List;

public interface EmailService {
    public void addEmail(Email email);

    public List<Email> getAllEmails();

    public void deleteEmail(Integer emailId);

    public Email getEmail(int emailid);

    public Email updateEmail(Email email);
}
