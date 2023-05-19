package com.example.mymail2.service;

import com.example.mymail2.model.Folder;
import com.example.mymail2.model.Mail;
import com.example.mymail2.model.User;
import com.example.mymail2.repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService {

    @Autowired
    private MailRepository mailRepository;

    JavaMailSender mailSender;

    private Folder folder;

    public void sendMail(User sender, User recipient, String subject, String body, Folder folder) {
        Mail mail = new Mail(sender, recipient, subject, body, folder);
        mailRepository.save(mail);
    }

    public List<Mail> getInboxMails(User user) {
        Folder inboxFolder = new Folder("INBOX", user);
        return mailRepository.findByFolder(inboxFolder);
    }

    public void saveDraft(User sender, User recipient, String subject, String body, Folder folder) {
        Mail mail = new Mail(sender, recipient, subject, body, folder);
        // Хранилище
        mailRepository.save(mail);
    }

    public void deleteMail(Mail mail) {
        mailRepository.deleteById(mail.getId());
    }

//    public boolean markAsRead(Mail mail) {
//        mail.setRead(true);
//        return mailRepository.saveMail(mail);
//    }
}
