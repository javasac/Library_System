package org.gfg.JBDL_76_Minor1.repository;

import org.gfg.JBDL_76_Minor1.model.Author;
import org.gfg.JBDL_76_Minor1.model.AuthorCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, AuthorCompositeKey> {

    Author findByEmail(String email);
}
