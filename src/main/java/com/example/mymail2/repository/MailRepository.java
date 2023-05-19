package com.example.mymail2.repository;

import com.example.mymail2.model.Folder;
import com.example.mymail2.model.Mail;
import com.example.mymail2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MailRepository extends JpaRepository<Mail, Long> {
    List<Mail> findBySender(User sender);
    List<Mail> findByRecipient(User recipient);
    List<Mail> findByFolder(Folder folder);
}