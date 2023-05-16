package com.example.mymail2.service;

import com.example.mymail2.model.Folder;
import com.example.mymail2.model.Mail;
import com.example.mymail2.model.User;
import com.example.mymail2.repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService {

    @Autowired
    private MailRepository mailRepository;

    private Folder folder;

    public boolean sendMail(User sender, User recipient, String subject, String body, Folder folder) {
        Mail mail = new Mail(sender, recipient, subject, body, folder);
        return mailRepository.saveMail(mail);
    }

    public List<Mail> getInboxMails(User user) {
        Folder inboxFolder = new Folder(Folder.FolderType.INBOX, user);
        return mailRepository.findByFolder(inboxFolder);
    }

//    public boolean saveDraft(User sender, User recipient, String subject, String body, Folder folder) {
//        Mail mail = new Mail(sender, recipient, subject, body, folder);
//        mail.setFolder(Folder.FolderType.DRAFTS);
//        return mailRepository.saveMail(mail);
//    }

    public boolean deleteMail(Mail mail) {
        return mailRepository.deleteMail(mail);
    }

//    public boolean markAsRead(Mail mail) {
//        mail.setRead(true);
//        return mailRepository.saveMail(mail);
//    }
}
