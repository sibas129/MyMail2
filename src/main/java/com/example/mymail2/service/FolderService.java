package com.example.mymail2.service;

import com.example.mymail2.model.Folder;
import com.example.mymail2.model.Mail;
import com.example.mymail2.model.User;
import com.example.mymail2.repository.FolderRepository;
import com.example.mymail2.repository.MailRepository;

import java.util.List;
import java.util.stream.Collectors;


public class FolderService {

    private final FolderRepository folderRepository;
    private final MailRepository mailRepository;

    public FolderService(FolderRepository folderRepository, MailRepository mailRepository) {
        this.folderRepository = folderRepository;
        this.mailRepository = mailRepository;
    }

    public List<Mail> getMailsInFolder(User user, Folder folder) {
        List<Mail> mails = mailRepository.findBySender(user);
        return mails.stream()
                .filter(mail -> mail.getFolder().getId() == folder.getId())
                .collect(Collectors.toList());
    }

    public List<Folder> getFoldersForUser(User user) {
        return folderRepository.findAllByUser(user);
    }

    public Folder createFolder(User user, String folderName) {
        Folder folder = new Folder(folderName, user);
        return folderRepository.save(folder);
    }

    public void deleteFolder(User user, Folder folder) {
        List<Mail> mails = getMailsInFolder(user, folder);
        for (Mail mail : mails) {
            mail.getFolder().setId(null);
            mailRepository.save(mail);
        }
        folderRepository.delete(folder);
    }

    public void moveMailToFolder(Mail mail, Folder folder) {
        mail.getFolder().setId(folder.getId());
        mailRepository.save(mail);
    }
}
