package br.jus.stm.localizacao.web;

import br.jus.stm.common.localizacao.dto.RegiaoDTO;
import br.jus.stm.localizacao.annotation.OpenAPICommonGet;
import br.jus.stm.localizacao.service.RegiaoService;
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
 * @since 23 de jul de 2019
 */
@RestController
@RequestMapping(value = "/api/regiao")
@Tag(name = "STM Localização IBGE - Região", description = "Fornece as operações de busca e manipulação no domínio Região")
@Log4j2
public class RegiaoController {

	@Autowired
	private RegiaoService service;

	@OpenAPICommonGet(summary = "Recupera todas as regiões")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Região recuperada com sucesso.", content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = RegiaoDTO.class)) }),
	})
	@GetMapping()
	public ResponseEntity<List<RegiaoDTO>> buscarTodos() {
		log.info("Recuperando todas as regiões ");
		List<RegiaoDTO> regioes = this.service.buscarTodos();
		if(regioes.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<RegiaoDTO>>(regioes, HttpStatus.OK);
		
	}

	@OpenAPICommonGet(summary = "Recupera uma região por nome")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Região recuperada com sucesso.", content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = RegiaoDTO.class)) }),
	})
	@GetMapping(value = "/nome/{nome}")
	public ResponseEntity<RegiaoDTO> buscarPorNome(
			@Parameter(description = "Nome da Região", in = ParameterIn.PATH)
			@PathVariable("nome") final String nome) {
		log.info("Recuperando região por nome " + nome);
		final RegiaoDTO regiao = this.service.buscarPorNome(nome);
		if(regiao == null) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<RegiaoDTO>(regiao, HttpStatus.OK);
		
	}

	@OpenAPICommonGet(summary = "Recupera uma região por sigla")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Região recuperada com sucesso.", content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = RegiaoDTO.class)) }),
	})
	@GetMapping(value = "/sigla/{sigla}")
	public ResponseEntity<RegiaoDTO> buscarPorSigla(
			@Parameter(description = "Sigla da Região", in = ParameterIn.PATH)
			@PathVariable("sigla") final String sigla) {
		
		log.info("Recuperando região por sigla " + sigla);
		final RegiaoDTO regiao = this.service.buscarPorSigla(sigla);
		if(regiao == null) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<RegiaoDTO>(regiao, HttpStatus.OK);
		
	}

}
