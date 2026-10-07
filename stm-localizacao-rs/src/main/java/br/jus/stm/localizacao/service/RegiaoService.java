package br.jus.stm.localizacao.service;

import br.jus.stm.common.localizacao.dto.RegiaoDTO;
import br.jus.stm.localizacao.domain.repository.RegiaoRepository;
import br.jus.stm.localizacao.exception.LocalizacaoAPIException;
import br.jus.stm.localizacao.mapper.RegiaoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service responsável por chamadas dao a entidade Região
 * @author wescley.sousa
 * @since 23 de jul de 2019
 */
@Service
@Slf4j
public class RegiaoService {

	@Autowired
	private RegiaoRepository regiaoRepository;

	@Autowired
	private RegiaoMapper regiaoMapper;

	/**
	 * Metodo responsável por recuperar todas as regiões
	 * @return List<RegiaoDTO> todas as regiões
	 * @throws LocalizacaoAPIException
	 */
	public List<RegiaoDTO> buscarTodos() throws LocalizacaoAPIException {
		try {
			return this.regiaoMapper.toDTOList(this.regiaoRepository.findAll());
		} catch (Exception ex) {
			log.error("Erro ao recuperar todas as regiões", ex);
			throw new LocalizacaoAPIException("Erro ao recuperar todas as regiões");
		}
	}

	/**
	 * Metodo responsável por recuperar região por nome
	 * @param nome
	 * @return RegiaoDTO região recuperada
	 * @throws LocalizacaoAPIException
	 */
	public RegiaoDTO buscarPorNome(final String nome) throws LocalizacaoAPIException {
		try {
			return this.regiaoMapper.toDTO(this.regiaoRepository.findByNome(nome));
		} catch (Exception ex) {
			log.error("Erro ao recuperar região por nome", ex);
			throw new LocalizacaoAPIException("Erro ao recuperar região por nome");
		}
	}

	/**
	 * Metodo responsável por recuperar região por sigla
	 * @param sigla
	 * @return RegiaoDTO região recuperada
	 * @throws LocalizacaoAPIException
	 */
	public RegiaoDTO buscarPorSigla(final String sigla) throws LocalizacaoAPIException {
		try {
			return this.regiaoMapper.toDTO(this.regiaoRepository.findBySigla(sigla));
		} catch (Exception ex) {
			log.error("Erro ao recuperar região por sigla", ex);
			throw new LocalizacaoAPIException("Erro ao recuperar região por sigla");
		}
	}

}
