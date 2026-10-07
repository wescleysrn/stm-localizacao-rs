package br.jus.stm.localizacao.service;

import br.jus.stm.common.localizacao.dto.MunicipioDTO;
import br.jus.stm.localizacao.domain.repository.MunicipioRepository;
import br.jus.stm.localizacao.exception.LocalizacaoAPIException;
import br.jus.stm.localizacao.mapper.MunicipioMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wescley.sousa
 * @since 22 de jul de 2019
 */
@Service
@Slf4j
public class MunicipioService {

	@Autowired
	private MunicipioRepository municipioRepository;

	@Autowired
	private MunicipioMapper municipioMapper;

	/**
	 * Metodo responsável por recuperar todos os municipios
	 * @return List<MunicipioDTO> todos os municipios
	 * @throws LocalizacaoAPIException
	 */
	public List<MunicipioDTO> buscarTodos() throws LocalizacaoAPIException {
		try {
			return this.municipioMapper.toDTOList(this.municipioRepository.findAll());
		} catch (Exception ex) {
			log.error("Erro ao recuperar todos os municipios", ex);
			throw new LocalizacaoAPIException("Erro ao recuperar todos os municipios");
		}
	}
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																					
	/**
	 * Metodo responsável por recuperar municipio por Código IBGE
	 * @param codigoIBGE
	 * @return MunicipioDTO municipio recuperado
	 * @throws LocalizacaoAPIException
	 */
	public MunicipioDTO buscarPorCodigoIbge(final String codigoIBGE) throws LocalizacaoAPIException {
		try {
			return this.municipioMapper.toDTO(this.municipioRepository.findByCodigoIBGECompleto(codigoIBGE));
		} catch (Exception ex) {
			log.error("Erro ao recuperar municipio por Código IBGE", ex);
			throw new LocalizacaoAPIException("Erro ao recuperar municipio por Código IBGE");
		}
	}

	/**
	 * Metodo responsável por recuperar municipios por UF
	 * @param uf
	 * @return List<MunicipioDTO> municipios recuperados
	 * @throws LocalizacaoAPIException
	 */
	public List<MunicipioDTO> buscarPorSiglaUf(final String uf) throws LocalizacaoAPIException {
		try {
			return this.municipioMapper.toDTOList(this.municipioRepository.findByUfSiglaOrderByNome(uf));
		} catch (Exception ex) {
			log.error("Erro ao recuperar municipios por UF", ex);
			throw new LocalizacaoAPIException("Erro ao recuperar municipios por UF");
		}
	}

	/**
	 * Metodo responsável por recuperar municipios por sigla de região
	 * @param sigla da região
	 * @return List<MunicipioDTO> municipios recuperados
	 * @throws LocalizacaoAPIException
	 */
	public List<MunicipioDTO> buscarPorSiglaRegiao(final String sigla) throws LocalizacaoAPIException {
		try {
			return this.municipioMapper.toDTOList(this.municipioRepository.findByUfRegiaoSigla(sigla));
		} catch (Exception ex) {
			log.error("Erro ao recuperar municipios por sigla de região", ex);
			throw new LocalizacaoAPIException("Erro ao recuperar municipios por sigla de região");
		}
	}

	/**
	 * Metodo responsável por recuperar municipios por código IBGE de Meso Região
	 * @param codigoIBGE de Meso Região
	 * @return List<MunicipioDTO> municipios recuperados
	 * @throws LocalizacaoAPIException
	 */
	public List<MunicipioDTO> buscarPorMesoRegiaoCodigoIBGE(String codigoIBGE) throws LocalizacaoAPIException {
		try {
			return this.municipioMapper.toDTOList(this.municipioRepository.findByMicroRegiaoMesoRegiaoCodigoIBGECompleto(codigoIBGE));
		} catch (Exception ex) {
			log.error("Erro ao recuperar municipios por código IBGE de Meso Região", ex);
			throw new LocalizacaoAPIException("Erro ao recuperar municipios por código IBGE de Meso Região");
		}
	}

	/**
	 * Metodo responsável por recuperar municipios por código IBGE de Micro Região
	 * @param codigoIBGE de Micro Região
	 * @return List<MunicipioDTO> municipios recuperados
	 * @throws LocalizacaoAPIException
	 */
	public List<MunicipioDTO> buscarPorMicroRegiaoCodigoIBGE(String codigoIBGE) throws LocalizacaoAPIException {
		try {
			return this.municipioMapper.toDTOList(this.municipioRepository.findByMicroRegiaoCodigoIBGECompleto(codigoIBGE));
		} catch (Exception ex) {
			log.error("Erro ao recuperar municipios por código IBGE de Micro Região", ex);
			throw new LocalizacaoAPIException("Erro ao recuperar municipios por código IBGE de Micro Região");
		}
	}

}
