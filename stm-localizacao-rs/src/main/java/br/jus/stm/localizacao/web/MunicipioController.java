package br.jus.stm.localizacao.web;

import br.jus.stm.common.localizacao.dto.MunicipioDTO;
import br.jus.stm.localizacao.annotation.OpenAPICommonGet;
import br.jus.stm.localizacao.service.MunicipioService;
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
@RequestMapping(value = "/api/municipio")
@Tag(name = "STM Localização IBGE - Municipio", description = "Fornece as operações de busca e manipulação no domínio Municipio")
@Log4j2
public class MunicipioController {

	@Autowired
	private MunicipioService service;

	@OpenAPICommonGet(summary = "Recupera uma lista de municipios por UF")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Lista de municipios recuperada com sucesso.", content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = MunicipioDTO.class)) }),
	})
	@GetMapping(value = "/uf/{sigla}")
	public ResponseEntity<List<MunicipioDTO>> buscarPorUf(
			@Parameter(description = "Sigla da Unidade da Federação", in = ParameterIn.PATH)
			@PathVariable("sigla") final String sigla) {
		
		log.info("Recuperando municipios da UF " + sigla);
		final List<MunicipioDTO> municipios = this.service.buscarPorSiglaUf(sigla);
		if(municipios.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<MunicipioDTO>>(municipios, HttpStatus.OK);
		
	}

	@OpenAPICommonGet(summary = "Recupera municipios pela sigla da Região")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Lista de municipios recuperada com sucesso.", content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = MunicipioDTO.class)) }),
	})
	@GetMapping(value = "/regiao/{sigla}")
	public ResponseEntity<List<MunicipioDTO>> buscarPorRegiaoSigla(
			@Parameter(description = "Sigla da Região", in = ParameterIn.PATH)
			@PathVariable("sigla") String sigla) {
		
		log.info("Recuperando municipios pela sigla da Região " + sigla);
		final List<MunicipioDTO> municipios = this.service. buscarPorSiglaRegiao(sigla);
		if(municipios.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);			
		return new ResponseEntity<List<MunicipioDTO>>(municipios, HttpStatus.OK);
		
	}

	@OpenAPICommonGet(summary = "Recupera Municipio por código IBGE")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Municipio recuperado com sucesso.", content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = MunicipioDTO.class)) }),
	})
	@GetMapping(value = "/{codigoIBGE}")
	public ResponseEntity<MunicipioDTO> buscarPorCodigoIbge(
			@Parameter(description = "Código IBGE do Municipio", in = ParameterIn.PATH)
			@PathVariable("codigoIBGE") String codigoIBGE) {

		log.info("Recuperando municipio por código IBGE " + codigoIBGE);
		final MunicipioDTO municipio = this.service.buscarPorCodigoIbge(codigoIBGE);
		if(municipio == null) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<MunicipioDTO>(municipio, HttpStatus.OK);

	}

	@OpenAPICommonGet(summary = "Recupera municipios pelo código IBGE de Meso Região")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Lista de municipios recuperada com sucesso.", content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = MunicipioDTO.class)) }),
	})
	@GetMapping(value = "/mesoregiao/{codigoIBGE}")
	public ResponseEntity<List<MunicipioDTO>> buscarPorMesoRegiaoCodigoIBGE(
			@Parameter(description = "Código IBGE de Micro Região", in = ParameterIn.PATH)
			@PathVariable("codigoIBGE") String codigoIBGE) {
		
		log.info("Recuperando municipios pelo código IBGE de Micro Região " + codigoIBGE);
		final List<MunicipioDTO> municipios = this.service.buscarPorMesoRegiaoCodigoIBGE(codigoIBGE);
		if(municipios.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);			
		return new ResponseEntity<List<MunicipioDTO>>(municipios, HttpStatus.OK);
		
	}

	@OpenAPICommonGet(summary = "Recupera municipios pelo código IBGE de Micro Região")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Lista de municipios recuperada com sucesso.", content = { @Content(mediaType = "application/json",
					schema = @Schema(implementation = MunicipioDTO.class)) }),
	})
	@GetMapping(value = "/microregiao/{codigoIBGE}")
	public ResponseEntity<List<MunicipioDTO>> buscarPorMicroRegiaoCodigoIBGE(
			@Parameter(description = "Código IBGE de Micro Região", in = ParameterIn.PATH)
			@PathVariable("codigoIBGE") String codigoIBGE) {
		
		log.info("Recuperando municipios pelo código IBGE de Micro Região " + codigoIBGE);
		final List<MunicipioDTO> municipios = this.service.buscarPorMicroRegiaoCodigoIBGE(codigoIBGE);
		if(municipios.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);			
		return new ResponseEntity<List<MunicipioDTO>>(municipios, HttpStatus.OK);
		
	}

	// TODO public String[] consultaMunicipiosPorCodZoneamento(String codZoneamento);

	// TODO public String[] consultaMunicipioNumMunic(String[] numMu);

	
}
