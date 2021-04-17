package br.com.desafiomuxi.desafio.repository;

import br.com.desafiomuxi.desafio.model.entity.Terminal;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface TerminalRepository extends JpaRepository<Terminal, Long> {
}
