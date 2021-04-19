package br.com.desafiomuxi.desafio.repository;

import br.com.desafiomuxi.desafio.model.entity.Terminal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@Repository
public interface TerminalRepository extends JpaRepository<Terminal, Long> {

    @Query("select t from Terminal t where t.logic == %?1")
    List<Terminal> findByFirstnameEndsWith(String firstname);

}
