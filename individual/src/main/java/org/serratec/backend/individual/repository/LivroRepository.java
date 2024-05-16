package org.serratec.backend.individual.repository;

import org.serratec.backend.individual.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
