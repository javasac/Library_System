package org.sachin.Library_System.repository;

import org.sachin.Library_System.model.Author;
import org.sachin.Library_System.model.AuthorCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, AuthorCompositeKey> {

    Author findByEmail(String email);
}
