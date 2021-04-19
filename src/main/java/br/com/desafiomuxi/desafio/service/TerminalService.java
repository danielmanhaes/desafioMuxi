package br.com.desafiomuxi.desafio.service;

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

//    public TerminalDto updateTerminal(Integer logic, TerminalDto terminalDto){
//        return terminalRepository.
//    }

    public TerminalDto update(Long Id, TerminalDto terminalDto){
       return terminalRepository.findById(Id)
                .map( terminal -> {
//                     terminal.setLogic(terminalDto.getLogic());
//                     terminal.setSerial(terminalDto.getSerial());
//                     terminal.setVersion(terminalDto.getVersion());
//                     terminal.setSam(terminalDto.getSam());
//                     terminal.setPtid(terminalDto.getPtid());
//                     terminal.setPlat(terminalDto.getPlat());
//                     terminal.setMxr(terminalDto.getMxr());
//                     terminal.setMxf(terminalDto.getMxf());
//                     terminal.setVerfm(terminalDto.getVerfm());
                     terminal = terminalDto.toEntity();
                     terminal.setId(Id);
                     terminalRepository.save(terminal);
                     return terminal.toDto();
                }).orElseGet( () -> {
                    Terminal terminalEntity = terminalDto.toEntity();
                    terminalEntity.setId(Id);
                    terminalEntity = terminalRepository.save(terminalEntity);
                   return terminalEntity.toDto();
               });
    }

//       .setLogic(logic)
//                .setSerial(serial)
//                .setModel(model)
//                .setVersion(version)
//                .setSam(sam)
//                .setPtid(ptid)
//                .setPlat(plat)
//                .setMxr(mxr)
//                .setMxf(mxf)
//                .setVerfm(verfm);

//     return repository.findById(id)
//            .map(employee -> {
//        employee.setName(newEmployee.getName());
//        employee.setRole(newEmployee.getRole());
//        return repository.save(employee);
//    })
//            .orElseGet(() -> {
//        newEmployee.setId(id);
//        return repository.save(newEmployee);
//    });

}
