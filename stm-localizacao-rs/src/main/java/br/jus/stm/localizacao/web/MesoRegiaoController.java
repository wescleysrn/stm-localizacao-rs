package br.jus.stm.localizacao.web;

import br.jus.stm.common.localizacao.dto.MesoRegiaoDTO;
import br.jus.stm.localizacao.annotation.OpenAPICommonGet;
import br.jus.stm.localizacao.service.MesoRegiaoService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wescley.sousa
 * @since 25 de jul de 2019
 */
@RestController
@RequestMapping(value = "/api/mesoregiao")
@Tag(name = "STM Localização IBGE - Meso Região", description = "Fornece as operações de busca e manipulação no domínio Meso Região")
@Log4j2
public class MesoRegiaoController {

	@Autowired
	private MesoRegiaoService service;

	@OpenAPICommonGet(summary = "Recupera meso região pelo código IBGE")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Meso Região recuperada com sucesso.", content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = MesoRegiaoDTO.class)) }),
	})
	@GetMapping(value = "/{codigoIBGE}")
	public ResponseEntity<MesoRegiaoDTO> buscarPorCodigoIBGE(
			@Parameter(description = "Código IBGE da Meso Região", in = ParameterIn.PATH)
			@PathVariable("codigoIBGE") final String codigoIBGE) {
		
		log.info("Recuperando meso região por código IBGE " + codigoIBGE);
		final MesoRegiaoDTO mesoRegiao = this.service.buscarPorCodigoIBGE(codigoIBGE);
		if(mesoRegiao == null) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<MesoRegiaoDTO>(mesoRegiao, HttpStatus.OK);
		
	}

	@OpenAPICommonGet(summary = "Recupera uma lista de meso regiões por UF")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Lista de meso regiões recuperadas com sucesso.", content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = MesoRegiaoDTO.class)) }),
	})
	@GetMapping(value = "/uf/{uf}")
	public ResponseEntity<List<MesoRegiaoDTO>> buscarPorUf(
			@Parameter(description = "Unidade da Federação", in = ParameterIn.PATH)
			@PathVariable("uf") final String uf) {

		log.info("Recuperando Meso Regiões da UF " + uf);
		final List<MesoRegiaoDTO> mesoRegioes = this.service.buscarPorUf(uf);
		if(mesoRegioes.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<MesoRegiaoDTO>>(mesoRegioes, HttpStatus.OK);

	}

	@OpenAPICommonGet(summary = "Recupera meso regiões pela sigla da Região")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Lista de meso regiões recuperada com sucesso.", content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = MesoRegiaoDTO.class)) }),
	})
	@GetMapping(value = "/regiao/{sigla}")
	public ResponseEntity<List<MesoRegiaoDTO>> buscarPorRegiaoSigla(
			@Parameter(description = "Sigla da Região", in = ParameterIn.PATH)
			@PathVariable("sigla") String sigla) {
		
		log.info("Recuperando meso regiões pela sigla da Região " + sigla);
		final List<MesoRegiaoDTO> mesoRegioes = this.service. buscarPorSiglaRegiao(sigla);
		if(mesoRegioes.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<MesoRegiaoDTO>>(mesoRegioes, HttpStatus.OK);
		
	}

	@OpenAPICommonGet(summary = "Recupera meso região pelo código IBGE de um municipio")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Meso Região recuperada com sucesso.", content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = MesoRegiaoDTO.class)) }),
	})
	@GetMapping(value = "/municipio/{codigoIBGE}")
	public ResponseEntity<MesoRegiaoDTO> buscarPorMunicipioCodigoIBGE(
			@Parameter(description = "Código IBGE de Municipio", in = ParameterIn.PATH)
			@PathVariable("codigoIBGE") final String codigoIBGE) {
	
		log.info("Recuperando meso região por código IBGE de Municipio " + codigoIBGE);
		final MesoRegiaoDTO mesoRegiao = this.service.buscarPorMunicipioCodigoIBGE(codigoIBGE);
		if(mesoRegiao == null) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);			
		return new ResponseEntity<MesoRegiaoDTO>(mesoRegiao, HttpStatus.OK);
	
	}

}
