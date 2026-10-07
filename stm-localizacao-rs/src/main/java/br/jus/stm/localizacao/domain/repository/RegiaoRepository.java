package br.jus.stm.localizacao.domain.repository;

import br.jus.stm.localizacao.domain.entity.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegiaoRepository extends JpaRepository<Regiao, Long> {

	Regiao findByNome(String nome);

	Regiao findBySigla(String sigla);
	
}
