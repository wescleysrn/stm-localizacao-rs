package br.jus.stm.localizacao.web;

import br.jus.stm.common.localizacao.dto.SubDistritoDTO;
import br.jus.stm.localizacao.annotation.OpenAPICommonGet;
import br.jus.stm.localizacao.service.SubDistritoService;
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
@RequestMapping(value = "/api/subdistrito")
@Tag(name = "STM Localização IBGE - Sub-Distrito", description = "Fornece as operações de busca e manipulação no domínio Sub-Distrito")
@Log4j2
public class SubDistritoController {

	@Autowired
	private SubDistritoService service;

	@OpenAPICommonGet(summary = "Recupera o sub-distrito pelo código IBGE")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Sub-Distrito recuperada com sucesso.", content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = SubDistritoDTO.class)) }),
	})
	@GetMapping(value = "/{codigoIBGE}")
	public ResponseEntity<SubDistritoDTO> buscarPorCodigoIBGE(
			@Parameter(description = "Código IBGE do Sub-Distrito", in = ParameterIn.PATH)
			@PathVariable("codigoIBGE") final String codigoIBGE) {
		
		log.info("Recuperando distrito por código IBGE " + codigoIBGE);
		final SubDistritoDTO subDistrito = service.buscarPorCodigoIBGE(codigoIBGE);
		if(subDistrito == null)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<SubDistritoDTO>(subDistrito, HttpStatus.OK);
		
	}

	@OpenAPICommonGet(summary = "Recupera os sub-distritos pelo código IBGE de um distrito")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Sub-Distritos recuperados com sucesso.", content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = SubDistritoDTO.class)) }),
	})
	@GetMapping(value = "/distrito/{codigoIBGE}")
	public ResponseEntity<List<SubDistritoDTO>> buscarPorDistritoCodigoIBGE(
			@Parameter(description = "Código IBGE do Distrito", in = ParameterIn.PATH)
			@PathVariable("codigoIBGE") final String codigoIBGE) {
		
		log.info("Recuperando sub-distritos por Distrito código IBGE " + codigoIBGE);
		final List<SubDistritoDTO> subDistritos = this.service.buscarPorDistritoCodigoIBGE(codigoIBGE);
		if(subDistritos.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<SubDistritoDTO>>(subDistritos, HttpStatus.OK);
		
	}

	@OpenAPICommonGet(summary = "Recupera uma lista de subDistritos por código IBGE de Municipio")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Lista de subDistritos recuperada com sucesso.", content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = SubDistritoDTO.class)) }),
	})
	@GetMapping(value = "/municipio/{codigoIBGE}")
	public ResponseEntity<List<SubDistritoDTO>> buscarPorMunicipioCodigoIBGE(
			@Parameter(description = "Código IBGE do municipio", in = ParameterIn.PATH)
			@PathVariable("codigoIBGE") final String codigoIBGE) {
		
		log.info("Recuperando subDistritos por código IBGE de Municipio " + codigoIBGE);
		final List<SubDistritoDTO> subDistritos = this.service.buscarPorMunicipioCodigoIBGE(codigoIBGE);
		if(subDistritos.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<SubDistritoDTO>>(subDistritos, HttpStatus.OK);
		
	}
	
}
