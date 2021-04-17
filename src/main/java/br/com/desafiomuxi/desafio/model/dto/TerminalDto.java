package br.com.desafiomuxi.desafio.model.dto;

import br.com.desafiomuxi.desafio.model.entity.Terminal;
import org.apache.commons.lang3.StringUtils;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TerminalDto {

    private Long id;

    @NotNull
    private Integer logic;

    @NotNull
    @NotEmpty
    @NotBlank
    private String serial;

    @NotNull
    @NotEmpty
    @NotBlank
    private String model;

    @NotNull
    @NotEmpty
    @NotBlank
    private String version;

    @Min(value = 0, message = "sam should not be less than 0")
    private Integer sam;

    private String ptid;
    private Integer plat;
    private Integer mxr;
    private Integer mxf;
    private String verfm;

    public TerminalDto(String message) throws Exception {

        String[] msg = message.split(";");
        this.setLogic(checkInt(msg[0]));
        this.setSam(Integer.parseInt(msg[3]));
        this.setPlat(Integer.parseInt(msg[5]));
        this.setMxr(Integer.parseInt(msg[7]));
        this.setMxf(Integer.parseInt(msg[8]));
        this.setSerial(msg[1]);
        this.setModel(msg[2]);
        this.setPtid(msg[4]);
        this.setVersion(msg[6]);
        this.setVerfm(msg[9]);

    }

    private Integer checkInt(String value) throws Exception {
        if(StringUtils.isNumeric(value))
            return Integer.parseInt(value);
        else
            throw new Exception();
    }

    public TerminalDto() {
    }

    public Terminal toEntity() {
        Terminal terminal = new Terminal();
        terminal.setLogic(logic)
                .setSerial(serial)
                .setModel(model)
                .setSam(sam)
                .setPtid(ptid)
                .setPlat(plat)
                .setVersion(version)
                .setMxr(mxr)
                .setMxf(mxf)
                .setVerfm(verfm);

        return terminal;
    }

    public Long getId() {
        return id;
    }

    public TerminalDto setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getLogic() {
        return logic;
    }

    public TerminalDto setLogic(Integer logic) {
        this.logic = logic;
        return this;
    }

    public String getSerial() {
        return serial;
    }

    public TerminalDto setSerial(String serial) {
        this.serial = serial;
        return this;
    }

    public String getModel() {
        return model;
    }

    public TerminalDto setModel(String model) {
        this.model = model;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public TerminalDto setVersion(String version) {
        this.version = version;
        return this;
    }

    public Integer getSam() {
        return sam;
    }

    public TerminalDto setSam(Integer sam) {
        this.sam = sam;
        return this;
    }

    public String getPtid() {
        return ptid;
    }

    public TerminalDto setPtid(String ptid) {
        this.ptid = ptid;
        return this;
    }

    public Integer getPlat() {
        return plat;
    }

    public TerminalDto setPlat(Integer plat) {
        this.plat = plat;
        return this;
    }

    public Integer getMxr() {
        return mxr;
    }

    public TerminalDto setMxr(Integer mxr) {
        this.mxr = mxr;
        return this;
    }

    public Integer getMxf() {
        return mxf;
    }

    public TerminalDto setMxf(Integer mxf) {
        this.mxf = mxf;
        return this;
    }

    public String getVerfm() {
        return verfm;
    }

    public TerminalDto setVerfm(String verfm) {
        this.verfm = verfm;
        return this;
    }
}
