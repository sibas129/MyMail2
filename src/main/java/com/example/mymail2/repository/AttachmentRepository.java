package com.example.mymail2.repository;

import com.example.mymail2.model.Attachment;
import com.example.mymail2.model.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
    Attachment findByFilename(String filename);
}
