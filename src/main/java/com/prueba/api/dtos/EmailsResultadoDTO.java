package com.prueba.api.dtos;

import java.util.List;

public class EmailsResultadoDTO extends ResultadoDTO {
    private List<String> emails;


    public EmailsResultadoDTO(boolean exitoso, List<String> emails) {
        super(exitoso);
        this.emails = emails;
    }

    public List<String>  getClientes() {
        return emails;
    }

    public void setEmails(List<String>  emails) {
        this.emails = emails;
    }
}