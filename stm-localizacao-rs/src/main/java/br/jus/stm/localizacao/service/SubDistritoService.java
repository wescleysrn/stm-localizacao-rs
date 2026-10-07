package br.jus.stm.localizacao.service;

import br.jus.stm.common.localizacao.dto.SubDistritoDTO;
import br.jus.stm.localizacao.domain.repository.SubDistritoRepository;
import br.jus.stm.localizacao.exception.LocalizacaoAPIException;
import br.jus.stm.localizacao.mapper.SubDistritoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service responsável por chamadas dao a entidade SubDistrito
 * @author wescley.sousa
 * @since 25 de jul de 2019
 */
@Service
@Slf4j
public class SubDistritoService {

	@Autowired
	private SubDistritoRepository daoSubDistrito;

	@Autowired
	private SubDistritoMapper subDistritoMapper;

	/**
	 * Metodo responsável por recuperar sub-distritos pelo código IBGE
	 * @param codigoIBGE
	 * @return
	 * @throws LocalizacaoAPIException
	 */
	public SubDistritoDTO buscarPorCodigoIBGE(String codigoIBGE) throws LocalizacaoAPIException {
		try {
			return this.subDistritoMapper.toDTO(this.daoSubDistrito.findByCodigoIBGECompleto(codigoIBGE));
		} catch (Exception ex) {
			log.error("Erro ao recuperar sub-distritos pelo código IBGE", ex);
			throw new LocalizacaoAPIException("Erro ao recuperar sub-distritos pelo código IBGE");
		}
	}
	
	/**
	 * Metodo responsável por recuperar sub-distritos pelo código IBGE de um Distrito
	 * @param codigoIBGE
	 * @return List<SubDistritoDTO> sub-distritos recuperadas
	 * @throws LocalizacaoAPIException
	 */
	public List<SubDistritoDTO> buscarPorDistritoCodigoIBGE(final String codigoIBGE) throws LocalizacaoAPIException {
		try {
			return this.subDistritoMapper.toDTOList(this.daoSubDistrito.findByDistritoCodigoIBGECompleto(codigoIBGE));
		} catch (Exception ex) {
			log.error("Erro ao recuperar sub-distritos pelo código IBGE de um Distrito", ex);
			throw new LocalizacaoAPIException("Erro ao recuperar sub-distritos pelo código IBGE de um Distrito");
		}
	}

	/**
	 * Metodo responsável por recuperar distritos pelo código IBGE de um municipio
	 * @param codigoIBGE
	 * @return List<SubDistritoDTO> distritos recuperados
	 * @throws LocalizacaoAPIException
	 */
	public List<SubDistritoDTO> buscarPorMunicipioCodigoIBGE(final String codigoIBGE) throws LocalizacaoAPIException {
		try {
			return this.subDistritoMapper.toDTOList(this.daoSubDistrito.findByDistritoMunicipioCodigoIBGECompleto(codigoIBGE));
		} catch (Exception ex) {
			log.error("Erro ao recuperar distritos pelo código IBGE de um municipio", ex);
			throw new LocalizacaoAPIException("Erro ao recuperar distritos pelo código IBGE de um municipio");
		}
	}

}
