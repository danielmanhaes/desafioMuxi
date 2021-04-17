package br.com.desafiomuxi.desafio.service;

import br.com.desafiomuxi.desafio.model.dto.TerminalDto;
import br.com.desafiomuxi.desafio.model.entity.Terminal;
import br.com.desafiomuxi.desafio.repository.TerminalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/*
Esta classe é responsabel pela parte de negocio
 */

@Service
public class TerminalService {

    @Autowired
    private Validator validator;

    @Autowired
    private TerminalRepository terminalRepository;

    public TerminalDto insert(TerminalDto terminalDto) throws Exception {

        /* verifica se o objeto montado com as informaçoes da requisiçao esta preenchido corretamente */
        Set<ConstraintViolation<TerminalDto>> violations = validator.validate(terminalDto);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        Terminal terminal = terminalDto.toEntity();

        terminal = terminalRepository.save(terminal);
        return terminal.toDto();
    }

    public Optional<TerminalDto> consult(Long id) {
        Optional<Terminal> terminalOptional = terminalRepository.findById(id);
        Optional<TerminalDto> terminalDtoOptional = terminalOptional.get().toDtoOptional();
        return terminalDtoOptional;
    }

//    public TerminalDto update(TerminalDto terminalDto){
//       return terminalRepository.findById(terminalDto.getId())
//                .map( terminal -> {
//                     terminal.setLogic(terminalDto.getLogic());
//                     return terminal.toDto();
//                }).orElse();
//    }

}
