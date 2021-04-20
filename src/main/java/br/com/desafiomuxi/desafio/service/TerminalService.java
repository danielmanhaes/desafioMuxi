package br.com.desafiomuxi.desafio.service;

import br.com.desafiomuxi.desafio.Exception.NotFoundException;
import br.com.desafiomuxi.desafio.model.dto.TerminalDto;
import br.com.desafiomuxi.desafio.model.entity.Terminal;
import br.com.desafiomuxi.desafio.repository.TerminalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Optional;
import java.util.Set;

@Service
public class TerminalService {

    @Autowired
    private Validator validator;

    @Autowired
    private TerminalRepository terminalRepository;

    public TerminalDto insert(TerminalDto terminalDto) throws Exception {
        Terminal terminal = null;
        Set<ConstraintViolation<TerminalDto>> violations = validator.validate(terminalDto);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        terminal = terminalDto.toEntity();
        terminal = terminalRepository.save(terminal);
        return terminal.toDto();
    }

    public Optional<TerminalDto> consult(Long id) {
        Optional<Terminal> terminalOptional = terminalRepository.findById(id);
        Optional<TerminalDto> terminalDtoOptional = terminalOptional.get().toDtoOptional();
        return terminalDtoOptional;
    }

    public TerminalDto consultByLogic(Integer logic) throws NotFoundException {
        Terminal terminal = terminalRepository.findByLogic(logic);
        if(terminal == null){
            throw new NotFoundException();
        }
        return terminal.toDto();
    }

    public TerminalDto update(Long Id, TerminalDto terminalDto) {
        return terminalRepository.findById(Id)
                .map(terminal -> {
                    terminal = terminalDto.toEntity();
                    terminal.setId(Id);
                    terminalRepository.save(terminal);
                    return terminal.toDto();
                }).orElseGet(() -> {
                    Terminal terminalEntity = terminalDto.toEntity();
                    terminalEntity.setId(Id);
                    terminalEntity = terminalRepository.save(terminalEntity);
                    return terminalEntity.toDto();
                });
    }

}
