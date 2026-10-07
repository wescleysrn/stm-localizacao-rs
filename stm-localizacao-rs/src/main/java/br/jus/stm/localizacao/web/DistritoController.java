package br.jus.stm.localizacao.web;

import br.jus.stm.common.localizacao.dto.DistritoDTO;
import br.jus.stm.localizacao.annotation.OpenAPICommonGet;
import br.jus.stm.localizacao.service.DistritoService;
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
 * @since 02 de abril de 2024
 */
@RestController
@RequestMapping(value = "/api/distrito")
@Tag(name = "STM Localização IBGE - Distrito", description = "Fornece as operações de busca e manipulação no domínio Distrito")
@Log4j2
public class DistritoController {

	@Autowired
	private DistritoService service;

	@OpenAPICommonGet(summary = "Recupera o distrito pelo código IBGE")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Distrito recuperada com sucesso.", content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = DistritoDTO.class)) }),
	})
	@GetMapping(value = "/{codigoIBGE}")
	public ResponseEntity<DistritoDTO> buscarPorCodigoIBGE(
			@Parameter(description = "Código IBGE do Distrito", in = ParameterIn.PATH)
			@PathVariable("codigoIBGE") final String codigoIBGE) {
		log.info("Recuperando distrito por código IBGE " + codigoIBGE);
		final DistritoDTO distrito = this.service.buscarPorCodigoIBGE(codigoIBGE);
		if(distrito == null) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<DistritoDTO>(distrito, HttpStatus.OK);
	}

	@OpenAPICommonGet(summary = "Recupera uma lista de distritos por código IBGE de Municipio")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Lista de distritos recuperada com sucesso.", content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = DistritoDTO.class)) }),
	})
	@GetMapping(value = "/municipio/{codigoIBGE}")
	public ResponseEntity<List<DistritoDTO>> buscarPorMunicipioCodigoIBGE(
			@Parameter(description = "Código IBGE do municipio", in = ParameterIn.PATH)
			@PathVariable("codigoIBGE") final String codigoIBGE) {
		
		log.info("Recuperando distritos por código IBGE de Municipio " + codigoIBGE);
		final List<DistritoDTO> distritos = this.service.buscarPorMunicipioCodigoIBGE(codigoIBGE);
		if(distritos.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);			
		return new ResponseEntity<List<DistritoDTO>>(distritos, HttpStatus.OK);
		
	}
	
}
