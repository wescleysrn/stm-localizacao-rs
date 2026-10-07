package br.jus.stm.common.localizacao.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MicroRegiaoDTO implements Serializable {

    private String codigoIBGECompleto;

    private String codigoIBGE;

    private String nome;

    private MesoRegiaoDTO mesoRegiao;

}
