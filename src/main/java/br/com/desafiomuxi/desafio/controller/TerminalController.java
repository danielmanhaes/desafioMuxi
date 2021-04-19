package br.com.desafiomuxi.desafio.controller;

import br.com.desafiomuxi.desafio.model.dto.TerminalDto;
import br.com.desafiomuxi.desafio.model.entity.Terminal;
import br.com.desafiomuxi.desafio.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("terminal")
public class TerminalController {

    /*
        assim que a terminal controller for instanciada o spring vai injetar uma instancia do terminal service
     */
    private final TerminalService terminalService;

    /* TODO estudar o mais sobre o Autowired */
    @Autowired
    public TerminalController(TerminalService terminalService) {
        this.terminalService = terminalService;
    }

    @RequestMapping(value = "/challenge", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
    public TerminalDto challenge(@RequestBody String message) throws Exception {
        TerminalDto terminalDto = new TerminalDto(message);
        terminalDto = terminalService.insert(terminalDto);
        return terminalDto;
    }

    @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
    public Optional<TerminalDto> consult(@PathVariable @NotNull @DecimalMin("0") Long Id){
        Optional<TerminalDto> terminalDto = terminalService.consult(Id);
        return terminalDto;
    }

    @RequestMapping(value = "/{Id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TerminalDto update(@PathVariable @NotNull @DecimalMin("0") Long Id, @RequestBody TerminalDto terminalDto){
        return terminalService.update(Id, terminalDto);
    }

    @RequestMapping(value = "terminal/{Id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TerminalDto updateTerminal(@PathVariable @NotNull @DecimalMin("0") Long Id, @RequestBody TerminalDto terminalDto){
        return terminalService.update(Id, terminalDto);
    }

}
