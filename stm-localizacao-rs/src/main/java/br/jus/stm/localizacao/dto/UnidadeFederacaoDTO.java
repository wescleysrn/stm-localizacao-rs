package br.jus.stm.common.localizacao.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UnidadeFederacaoDTO implements Serializable {

    private String codigoIBGE;

    private String sigla;

    private String nome;

    private Long idSei;

    private RegiaoDTO regiao;

}
