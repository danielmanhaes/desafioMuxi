package br.com.desafiomuxi.desafio.controller;

import br.com.desafiomuxi.desafio.Exception.NotFoundException;
import br.com.desafiomuxi.desafio.model.dto.TerminalDto;
import br.com.desafiomuxi.desafio.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("${version}")
public class TerminalController {

    /*
        assim que a terminal controller for instanciada o spring vai injetar uma instancia do terminal service
     */
    private final TerminalService terminalService;

    @Autowired
    public TerminalController(TerminalService terminalService) {
        this.terminalService = terminalService;
    }

    @RequestMapping(value = "/terminal/insert", method = RequestMethod.POST, consumes = MediaType.TEXT_HTML_VALUE)
    public TerminalDto insert(@RequestBody String message) throws Exception {
        TerminalDto terminalDto = new TerminalDto(message);
        terminalDto = terminalService.insert(terminalDto);
        return terminalDto;
    }

    @RequestMapping(value = "/terminal/{logic}", method = RequestMethod.GET)
    public TerminalDto consult(@PathVariable @NotNull @DecimalMin("0") Integer logic ) throws NotFoundException {
        TerminalDto terminalDto = terminalService.consultByLogic(logic);
        return terminalDto;
    }

    @RequestMapping(value = "/terminal/{logic}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TerminalDto update(@PathVariable @NotNull @DecimalMin("0") Long logic, @RequestBody TerminalDto terminalDto){
        return terminalService.update(logic, terminalDto);
    }

}
