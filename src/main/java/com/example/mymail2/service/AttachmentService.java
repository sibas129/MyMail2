package com.example.mymail2.service;

import com.example.mymail2.model.Attachment;
import com.example.mymail2.model.Mail;
import com.example.mymail2.repository.AttachmentRepository;

import java.util.List;

public class AttachmentService {

    private final AttachmentRepository attachmentRepository;

    public AttachmentService(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    public Attachment getAttachmentById(Long id) {
        return attachmentRepository.getAttachmentById(id);
    }

    public List<Attachment> getAttachmentsForMail(Mail mail) {
        return attachmentRepository.getAttachmentsForMail(mail);
    }

    public Attachment uploadAttachment(Attachment attachment) {
        return attachmentRepository.uploadAttachment(attachment);
    }

    public void deleteAttachment(Attachment attachment) {
        attachmentRepository.deleteAttachment(attachment);
    }
}