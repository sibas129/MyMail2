package com.example.mymail2.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "folders")
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Mail> mails = new HashSet<>();

    public enum FolderType {
        INBOX("Inbox"),
        SENT("Sent"),
        DRAFTS("Drafts"),
        TRASH("Trash"),
        SPAM("Spam");

        private final String displayName;

        FolderType(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }

        public static FolderType fromDisplayName(String displayName) {
            for (FolderType type : FolderType.values()) {
                if (type.displayName.equals(displayName)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Invalid FolderType display name: " + displayName);
        }
    }

    @Enumerated(EnumType.STRING)
    @Column
    private FolderType type;

    // Constructors, Getters, and Setters

    public Folder() {
    }

    public Folder(FolderType type, User user) {
        this.type = type;
        this.user = user;
        this.name = type.getDisplayName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FolderType getType() {
        return type;
    }

    public void setType(FolderType type) {
        this.type = type;
    }

    public Set<Mail> getMails() {
        return mails;
    }

    public void setMails(Set<Mail> mails) {
        this.mails = mails;
    }

    public void addMail(Mail mail) {
        this.mails.add(mail);
        mail.setFolder(this);
    }

    public void removeMail(Mail mail) {
        this.mails.remove(mail);
        mail.setFolder(null);
    }
}
