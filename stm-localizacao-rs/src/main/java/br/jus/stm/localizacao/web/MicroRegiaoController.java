package br.jus.stm.localizacao.web;

import br.jus.stm.common.localizacao.dto.MicroRegiaoDTO;
import br.jus.stm.localizacao.annotation.OpenAPICommonGet;
import br.jus.stm.localizacao.service.MicroRegiaoService;
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
@RequestMapping(value = "/api/microregiao")
@Tag(name = "STM Localização IBGE - Micro Região", description = "Fornece as operações de busca e manipulação no domínio Micro Região")
@Log4j2
public class MicroRegiaoController {

	@Autowired
	private MicroRegiaoService service;

	@OpenAPICommonGet(summary = "Recupera micro região pelo código IBGE")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Micro Região recuperada com sucesso.", content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = MicroRegiaoDTO.class)) }),
	})
	@GetMapping(value = "/{codigoIBGE}")
	public ResponseEntity<MicroRegiaoDTO> buscarPorCodigoIBGE(
			@Parameter(description = "Código IBGE da Micro Região", in = ParameterIn.PATH)
			@PathVariable("codigoIBGE") final String codigoIBGE) {
		
		log.info("Recuperando micro região por código IBGE " + codigoIBGE);
		final MicroRegiaoDTO microRegiao = this.service.buscarPorCodigoIBGE(codigoIBGE);
		if(microRegiao == null) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<MicroRegiaoDTO>(microRegiao, HttpStatus.OK);
		
	}

	@OpenAPICommonGet(summary = "Recupera uma lista de micro regiões por UF")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Lista de micro regiões recuperadas com sucesso.", content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = MicroRegiaoDTO.class)) }),
	})
	@GetMapping(value = "/uf/{sigla}")
	public ResponseEntity<List<MicroRegiaoDTO>> buscarPorUf(
			@Parameter(description = "Unidade da Federação", in = ParameterIn.PATH)
			@PathVariable("sigla") final String sigla) {
		
		log.info("Recuperando Micro Regiões da UF " + sigla);
		final List<MicroRegiaoDTO> microRegioes = this.service.buscarPorUfSigla(sigla);
		if(microRegioes.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);			
		return new ResponseEntity<List<MicroRegiaoDTO>>(microRegioes, HttpStatus.OK);
		
	}

	@OpenAPICommonGet(summary = "Recupera micro regiões pela sigla da Região")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Lista de micro regiões recuperada com sucesso.", content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = MicroRegiaoDTO.class)) }),
	})
	@GetMapping(value = "/regiao/{sigla}")
	public ResponseEntity<List<MicroRegiaoDTO>> buscarPorRegiaoSigla(
			@Parameter(description = "Sigla da Região", in = ParameterIn.PATH)
			@PathVariable("sigla") String sigla) {
		log.info("Recuperando micro regiões pela sigla da Região " + sigla);
		final List<MicroRegiaoDTO> microRegioes = this.service. buscarPorSiglaRegiao(sigla);
		if(microRegioes.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<MicroRegiaoDTO>>(microRegioes, HttpStatus.OK);
	}

	@OpenAPICommonGet(summary = "Recupera micro regiões pelo código IBGE da Meso Região")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Lista de micro regiões recuperada com sucesso.", content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = MicroRegiaoDTO.class)) }),
	})
	@GetMapping(value = "/mesoregiao/{codigoIBGE}")
	public ResponseEntity<List<MicroRegiaoDTO>> buscarPorMesoRegiaoCodigoIBGE(
			@Parameter(description = "Código IBGE da Meso Região", in = ParameterIn.PATH)
			@PathVariable("codigoIBGE") String codigoIBGE) {

		log.info("Recuperando micro regiões pelo código IBGE da meso região " + codigoIBGE);
		final List<MicroRegiaoDTO> microRegioes = this.service. buscarPorMesoRegiaoCodigoIBGE(codigoIBGE);
		if(microRegioes.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);			
		return new ResponseEntity<List<MicroRegiaoDTO>>(microRegioes, HttpStatus.OK);

	}

}
