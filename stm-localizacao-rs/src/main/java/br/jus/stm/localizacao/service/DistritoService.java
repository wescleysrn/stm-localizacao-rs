package br.jus.stm.localizacao.service;

import br.jus.stm.common.localizacao.dto.DistritoDTO;
import br.jus.stm.localizacao.domain.repository.DistritoRepository;
import br.jus.stm.localizacao.exception.LocalizacaoAPIException;
import br.jus.stm.localizacao.mapper.DistritoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service responsável por chamadas dao a entidade Distrito
 * @author wescley.sousa
 * @since 02 de abril de 2024
 */
@Service
@Slf4j
public class DistritoService {

	@Autowired
	private DistritoRepository distritoRepository;

	@Autowired
	private DistritoMapper distritoMapper;

	/**
	 * Metodo responsável por recuperar distritos pelo código IBGE de um municipio
	 * @param codigoIBGE
	 * @return List<DistritoDTO> distritos recuperados
	 * @throws LocalizacaoAPIException
	 */
	public List<DistritoDTO> buscarPorMunicipioCodigoIBGE(final String codigoIBGE) throws LocalizacaoAPIException {
		try {
			return this.distritoMapper.toDTOList(this.distritoRepository.findByMunicipioCodigoIBGECompleto(codigoIBGE));
		} catch (Exception ex) {
			log.error("Erro ao recuperar distritos pelo código IBGE de um municipio", ex);
			throw new LocalizacaoAPIException("Erro ao recuperar distritos pelo código IBGE de um municipio");
		}
	}
	
	/**
	 * Metodo responsável por recuperar distrito pelo código IBGE
	 * @param codigoIBGE
	 * @return DistritoDTO distritos recuperados
	 * @throws LocalizacaoAPIException
	 */
	public DistritoDTO buscarPorCodigoIBGE(final String codigoIBGE) throws LocalizacaoAPIException {
		try {
			return this.distritoMapper.toDTO(this.distritoRepository.findByCodigoIBGECompleto(codigoIBGE));
		} catch (Exception ex) {
			log.error("Erro ao recuperar distrito pelo código IBGE", ex);
			throw new LocalizacaoAPIException("Erro ao recuperar distrito pelo código IBGE");
		}
	}
	
}
