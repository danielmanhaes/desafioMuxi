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

    @RequestMapping(value = "/{Ids}", method = RequestMethod.GET)
    public Optional<TerminalDto> consult(@PathVariable @NotNull @DecimalMin("0") Long Ids){
        Optional<TerminalDto> terminalDto = terminalService.consult(Ids);
        return terminalDto;
    }

//    @PutMapping(value = "/{Id}")
//    public TerminalDto update(@PathVariable Integer id, @RequestBody TerminalDto terminalDto){
//        return terminalSegrvice.update(terminalDto);
//    }

}
