package br.jus.stm.common.localizacao.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MesoRegiaoDTO implements Serializable {

    private String codigoIBGECompleto;

    private String codigoIBGE;

    private String nome;

    private UnidadeFederacaoDTO uf;

    private Set<MicroRegiaoDTO> microRegiaos;

}
