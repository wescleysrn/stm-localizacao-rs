package br.jus.stm.localizacao.service;

import br.jus.stm.common.localizacao.dto.MicroRegiaoDTO;
import br.jus.stm.localizacao.domain.repository.MicroRegiaoRepository;
import br.jus.stm.localizacao.exception.LocalizacaoAPIException;
import br.jus.stm.localizacao.mapper.MicroRegiaoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service responsável por chamadas dao a entidade MicroRegiao
 * @author wescley.sousa
 * @since 25 de jul de 2019
 */
@Service
@Slf4j
public class MicroRegiaoService {

	@Autowired
	private MicroRegiaoRepository daoMicroRegiao;

	@Autowired
	private MicroRegiaoMapper microRegiaoMapper;

	/**
	 * Metodo responsável por recuperar micro região pelo código IBGE
	 * @param codigoIBGE
	 * @return MesoRegiaoDTO meso região recuperada
	 * @throws LocalizacaoAPIException
	 */
	public MicroRegiaoDTO buscarPorCodigoIBGE(final String codigoIBGE) throws LocalizacaoAPIException {
		try {
			return this.microRegiaoMapper.toDTO(this.daoMicroRegiao.findByCodigoIBGECompleto(codigoIBGE));
		} catch (Exception ex) {
			log.error("Erro ao recuperar micro região pelo código IBGE", ex);
			throw new LocalizacaoAPIException("Erro ao recuperar micro região pelo código IBGE");
		}
	}

	/**
	 * Metodo responsável por recuperar micro regiões pelo código IBGE de uma Meso Região
	 * @param codigoIBGE
	 * @return List<MesoRegiaoDTO> meso regiões recuperadas
	 * @throws LocalizacaoAPIException
	 */
	public List<MicroRegiaoDTO> buscarPorMesoRegiaoCodigoIBGE(final String codigoIBGE) throws LocalizacaoAPIException {
		try {
			return this.microRegiaoMapper.toDTOList(this.daoMicroRegiao.findByMesoRegiaoCodigoIBGECompleto(codigoIBGE));
		} catch (Exception ex) {
			log.error("Erro ao recuperar micro regiões pelo código IBGE de uma Meso Região", ex);
			throw new LocalizacaoAPIException("Erro ao recuperar micro regiões pelo código IBGE de uma Meso Região");
		}
	}

	/**
	 * Metodo responsável por recuperar meso regiões por Sigla de UF
	 * @param sigla
	 * @return List<MesoRegiaoDTO> micro regiões recuperados
	 * @throws LocalizacaoAPIException
	 */
	public List<MicroRegiaoDTO> buscarPorUfSigla(final String sigla) throws LocalizacaoAPIException {
		try {
			return this.microRegiaoMapper.toDTOList(this.daoMicroRegiao.findByMesoRegiaoUfSigla(sigla));
		} catch (Exception ex) {
			log.error("Erro ao recuperar meso regiões por Sigla de UF", ex);
			throw new LocalizacaoAPIException("Erro ao recuperar meso regiões por Sigla de UF");
		}
	}

	/**
	 * Metodo responsável por recuperar micro regiões por sigla de região
	 * @param sigla da região
	 * @return List<MicroRegiaoDTO> micro regiões recuperados
	 * @throws LocalizacaoAPIException
	 */
	public List<MicroRegiaoDTO> buscarPorSiglaRegiao(final String sigla) throws LocalizacaoAPIException {
		try {
			return this.microRegiaoMapper.toDTOList(this.daoMicroRegiao.findByMesoRegiaoUfRegiaoSigla(sigla));
		} catch (Exception ex) {
			log.error("Erro ao recuperar micro regiões por sigla de região", ex);
			throw new LocalizacaoAPIException("Erro ao recuperar micro regiões por sigla de região");
		}
	}

}
