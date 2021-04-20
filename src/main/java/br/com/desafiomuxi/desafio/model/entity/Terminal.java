package br.com.desafiomuxi.desafio.model.entity;

import br.com.desafiomuxi.desafio.model.dto.*;


import javax.persistence.*;
import java.util.Optional;


@Entity
public class Terminal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private Integer logic;

    private String serial;
    private String model;
    private String version;
    private Integer sam;
    private String ptid;
    private Integer plat;
    private Integer mxr;
    private Integer mxf;
    private String verfm;

    public TerminalDto toDto (){
        TerminalDto dto = new TerminalDto();
        dto.setId(id)
                .setLogic(logic)
                .setSerial(serial)
                .setModel(model)
                .setVersion(version)
                .setSam(sam)
                .setPtid(ptid)
                .setPlat(plat)
                .setMxr(mxr)
                .setMxf(mxf)
                .setVerfm(verfm);
        return dto;
    }

    public Optional<TerminalDto> toDtoOptional (){
        return Optional.of(this.toDto());
    }

    public Long getId() {
        return id;
    }

    public Terminal setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getLogic() {
        return logic;
    }

    public Terminal setLogic(Integer logic) {
        this.logic = logic;
        return this;
    }

    public String getSerial() {
        return serial;
    }

    public Terminal setSerial(String serial) {
        this.serial = serial;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Terminal setModel(String model) {
        this.model = model;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public Terminal setVersion(String version) {
        this.version = version;
        return this;
    }

    public Integer getSam() {
        return sam;
    }

    public Terminal setSam(Integer sam) {
        this.sam = sam;
        return this;
    }

    public String getPtid() {
        return ptid;
    }

    public Terminal setPtid(String ptid) {
        this.ptid = ptid;
        return this;
    }

    public Integer getPlat() {
        return plat;
    }

    public Terminal setPlat(Integer plat) {
        this.plat = plat;
        return this;
    }

    public Integer getMxr() {
        return mxr;
    }

    public Terminal setMxr(Integer mxr) {
        this.mxr = mxr;
        return this;
    }

    public Integer getMxf() {
        return mxf;
    }

    public Terminal setMxf(Integer mxf) {
        this.mxf = mxf;
        return this;
    }

    public String getVerfm() {
        return verfm;
    }

    public Terminal setVerfm(String verfm) {
        this.verfm = verfm;
        return this;
    }

}
