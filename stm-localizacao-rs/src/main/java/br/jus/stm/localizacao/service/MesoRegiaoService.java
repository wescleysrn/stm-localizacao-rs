package br.jus.stm.localizacao.service;

import br.jus.stm.common.localizacao.dto.MesoRegiaoDTO;
import br.jus.stm.localizacao.domain.repository.MesoRegiaoRepository;
import br.jus.stm.localizacao.exception.LocalizacaoAPIException;
import br.jus.stm.localizacao.mapper.MesoRegiaoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service responsável por chamadas dao a entidade MesoRegiao
 * @author wescley.sousa
 * @since 02 de abril de 2024
 */
@Service
@Slf4j
public class MesoRegiaoService {

	@Autowired
	private MesoRegiaoRepository mesoRegiaoRepository;

	@Autowired
	private MesoRegiaoMapper mesoRegiaoMapper;

	/**
	 * Metodo responsável por recuperar meso região pelo código IBGE
	 * @param codigoIBGE
	 * @return MesoRegiaoDTO meso região recuperada
	 * @throws LocalizacaoAPIException
	 */
	public MesoRegiaoDTO buscarPorCodigoIBGE(final String codigoIBGE) throws LocalizacaoAPIException {
		try {
			return mesoRegiaoMapper.toDTO(this.mesoRegiaoRepository.findByCodigoIBGECompleto(codigoIBGE));
		} catch (Exception ex) {
			log.error("Erro ao recuperar meso região pelo código IBGE", ex);
			throw new LocalizacaoAPIException("Erro ao recuperar meso região pelo código IBGE");
		}
	}
	
	/**
	 * Metodo responsável por recuperar meso regiões por UF
	 * @param uf
	 * @return List<MesoRegiaoDTO> meso regiões recuperados
	 * @throws LocalizacaoAPIException
	 */
	public List<MesoRegiaoDTO> buscarPorUf(final String uf) throws LocalizacaoAPIException {
		try {
			return this.mesoRegiaoMapper.toDTOList(this.mesoRegiaoRepository.findByUfSigla(uf));
		} catch (Exception ex) {
			log.error("Erro ao recuperar meso regiões por UF", ex);
			throw new LocalizacaoAPIException("Erro ao recuperar meso regiões por UF");
		}
	}

	/**
	 * Metodo responsável por recuperar meso regiões por sigla de região
	 * @param sigla da região
	 * @return List<MesoRegiaoDTO> meso regiões recuperados
	 * @throws LocalizacaoAPIException
	 */
	public List<MesoRegiaoDTO> buscarPorSiglaRegiao(final String sigla) throws LocalizacaoAPIException {
		try {
			return this.mesoRegiaoMapper.toDTOList(this.mesoRegiaoRepository.findByUfRegiaoSigla(sigla));
		} catch (Exception ex) {
			log.error("Erro ao recuperar meso regiões por sigla de região", ex);
			throw new LocalizacaoAPIException("Erro ao recuperar meso regiões por sigla de região");
		}
	}

	/**
	 * Metodo responsável por recuperar meso região pelo código IBGE de Municipio
	 * @param codigoIBGE
	 * @return MesoRegiaoDTO meso região recuperada
	 * @throws LocalizacaoAPIException
	 */
	public MesoRegiaoDTO buscarPorMunicipioCodigoIBGE(final String codigoIBGE) throws LocalizacaoAPIException {
		try {
			return this.mesoRegiaoMapper.toDTO(this.mesoRegiaoRepository.findByMunicipioCodigoIBGE(codigoIBGE));
		} catch (Exception ex) {
			log.error("Erro ao recuperar meso região pelo código IBGE de Municipio", ex);
			throw new LocalizacaoAPIException("Erro ao recuperar meso região pelo código IBGE de Municipio");
		}
	}
	
}
