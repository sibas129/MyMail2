package com.example.mymail2.repository;

import com.example.mymail2.model.Folder;
import com.example.mymail2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {
    List<Folder> findByUser(User user);
}