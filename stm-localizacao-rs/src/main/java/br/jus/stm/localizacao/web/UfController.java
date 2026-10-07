package br.jus.stm.localizacao.web;

import br.jus.stm.common.localizacao.dto.UnidadeFederacaoDTO;
import br.jus.stm.localizacao.annotation.OpenAPICommonGet;
import br.jus.stm.localizacao.service.UnidadeFederacaoService;
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
 * @since 22 de jul de 2019
 */
@RestController
@RequestMapping(value = "/api/uf")
@Tag(name = "STM Localização IBGE - UF", description = "Fornece as operações de busca e manipulação no domínio UF")
@Log4j2
public class UfController {

	@Autowired
	private UnidadeFederacaoService service;

	@OpenAPICommonGet(summary = "Recupera a lista de UF")
	@ApiResponses({@ApiResponse(responseCode = "200", description = "Lista de UF's recuperada com sucesso.", content = {
		@Content(mediaType = "application/json", schema = @Schema(implementation=UnidadeFederacaoDTO.class))}),
	})
	@GetMapping
	public ResponseEntity<List<UnidadeFederacaoDTO>> buscarTodos() {
		log.info("Recuperando UF's ");
		final List<UnidadeFederacaoDTO> ufs = this.service.buscarTodos();
		if(ufs.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<UnidadeFederacaoDTO>>(ufs, HttpStatus.OK);
		
	}

	@OpenAPICommonGet(summary = "Recupera UF's pela sigla da Região")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Lista de UF's recuperada com sucesso.", content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = UnidadeFederacaoDTO.class)) }),
	})
	@GetMapping(value = "/regiao/{sigla}")
	public ResponseEntity<List<UnidadeFederacaoDTO>> buscarPorRegiaoSigla(
			@Parameter(description = "Sigla da Região", in = ParameterIn.PATH)
			@PathVariable("sigla") String sigla) {
		log.info("Recuperando UF's por sigla região " + sigla);
		final List<UnidadeFederacaoDTO> ufs = this.service.buscarPorRegiaoSigla(sigla);
		if(ufs.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<UnidadeFederacaoDTO>>(ufs, HttpStatus.OK);
		
	}

	@OpenAPICommonGet(summary = "Recupera UF por código IBGE")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "UF recuperada com sucesso.", content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = UnidadeFederacaoDTO.class)) }),
	})
	@GetMapping(value = "/{codigoIBGE}")
	public ResponseEntity<UnidadeFederacaoDTO> buscarPorCodigoIbge(
			@Parameter(description = "Código IBGE da UF", in = ParameterIn.PATH)
			@PathVariable("codigoIBGE") String codigoIBGE) {
		log.info("Recuperando UF's por código IBGE " + codigoIBGE);
		final UnidadeFederacaoDTO uf = this.service.buscarPorCodigoIbge(codigoIBGE);
		if(uf == null) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<UnidadeFederacaoDTO>(uf, HttpStatus.OK);
		
	}
	
	// TODO Modificar busca por código IBGE por sigla
	// TODO Metodo buscar todas retornar ordenado por sigla
	// public List<UnidadeFederacao> recuperarTodasUFSigla(Collection siglasUfDesprezar);
	
}
