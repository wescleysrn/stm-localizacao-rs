package br.jus.stm.localizacao.domain.repository;

import br.jus.stm.localizacao.domain.entity.UnidadeFederacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnidadeFederacaoRepository extends JpaRepository<UnidadeFederacao, Long> {

	UnidadeFederacao findBySigla(String sigla);
	
	UnidadeFederacao findByNome(String nome);

	UnidadeFederacao findByCodigoIBGE(String codigoIBGE);

	List<UnidadeFederacao> findByRegiaoSigla(String sigla);

}
