package br.jus.stm.localizacao.domain.repository;

import br.jus.stm.localizacao.domain.entity.MicroRegiao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MicroRegiaoRepository extends JpaRepository<MicroRegiao, Long> {

	MicroRegiao findByCodigoIBGECompleto(String codigoIBGE);

	List<MicroRegiao> findByMesoRegiaoUfCodigoIBGE(String codigoIBGE);
	
	List<MicroRegiao> findByMesoRegiaoCodigoIBGECompleto(String codigoIBGE);

	List<MicroRegiao> findByMesoRegiaoUfSigla(String uf);

	List<MicroRegiao> findByMesoRegiaoUfRegiaoSigla(String uf);

}
