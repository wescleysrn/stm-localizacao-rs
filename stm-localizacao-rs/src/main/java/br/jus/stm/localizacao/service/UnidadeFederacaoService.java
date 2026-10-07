package br.jus.stm.localizacao.service;

import br.jus.stm.common.localizacao.dto.UnidadeFederacaoDTO;
import br.jus.stm.localizacao.domain.repository.UnidadeFederacaoRepository;
import br.jus.stm.localizacao.exception.LocalizacaoAPIException;
import br.jus.stm.localizacao.mapper.UnidadeFederacaoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wescley.sousa
 * @since 22 de jul de 2019
 */
@Service
@Slf4j
public class UnidadeFederacaoService {

	@Autowired
	private UnidadeFederacaoRepository daoUnidadeFederacao;

	@Autowired
	private UnidadeFederacaoMapper unidadeFederacaoMapper;

	/**
	 * Metodo responsável por recuperar todas as UF's
	 * @return List<UfDTO> uf's recuperadas
	 * @throws LocalizacaoAPIException
	 */
	public List<UnidadeFederacaoDTO> buscarTodos() throws LocalizacaoAPIException {
		try {
			return this.unidadeFederacaoMapper.toDTOList(this.daoUnidadeFederacao.findAll(Sort.by(Sort.Direction.ASC, "sigla")));
		} catch (Exception ex) {
			log.error("Erro ao recuperar todas as UF's", ex);
			throw new LocalizacaoAPIException("Erro ao recuperar todas as UF's");
		}
	}

	/**
	 * Metodo responsável por recuperar UF por Código IBGE
	 * @param codigoIBGE
	 * @return UfDTO recuperada
	 * @throws LocalizacaoAPIException
	 */
	public UnidadeFederacaoDTO buscarPorCodigoIbge(final String codigoIBGE) throws LocalizacaoAPIException {
		try {
			return this.unidadeFederacaoMapper.toDTO(this.daoUnidadeFederacao.findByCodigoIBGE(codigoIBGE));
		} catch (Exception ex) {
			log.error("Erro ao recuperar UF por Código IBGE", ex);
			throw new LocalizacaoAPIException("Erro ao recuperar UF por Código IBGE");
		}
	}

	/**
	 * Metodo responsável por recuperar UF' por Sigla de Região 
	 * @param sigla da região
	 * @return List<UfDTO> UF's recuperadas
	 * @throws LocalizacaoAPIException
	 */
	public List<UnidadeFederacaoDTO> buscarPorRegiaoSigla(final String sigla) throws LocalizacaoAPIException {
		try {
			return this.unidadeFederacaoMapper.toDTOList(this.daoUnidadeFederacao.findByRegiaoSigla(sigla));
		} catch (Exception ex) {
			log.error("Erro ao recuperar UF' por Sigla de Região", ex);
			throw new LocalizacaoAPIException("Erro ao recuperar UF' por Sigla de Região");
		}
	}

}
