package br.jus.stm.localizacao.domain.repository;

import br.jus.stm.localizacao.domain.entity.MesoRegiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MesoRegiaoRepository extends JpaRepository<MesoRegiao, Long> {

	MesoRegiao findByCodigoIBGECompleto(String codigoIBGE);
	
	List<MesoRegiao> findByUfSigla(String uf);

	List<MesoRegiao> findByUfRegiaoSigla(String uf);

	@Query("select meso from Municipio m join m.microRegiao mr join mr.mesoRegiao meso where m.codigoIBGECompleto = :codigoIBGE")
	MesoRegiao findByMunicipioCodigoIBGE(@Param("codigoIBGE") String codigoIBGE);
	
}
