package br.jus.stm.common.localizacao.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DistritoDTO implements Serializable {

    private String codigoIBGECompleto;

    private String codigoIBGE;

    private String nome;

    private MunicipioDTO municipio;

    private List<SubDistritoDTO> subDistritos;

}
