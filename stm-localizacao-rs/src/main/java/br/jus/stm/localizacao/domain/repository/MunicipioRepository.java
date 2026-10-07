package br.jus.stm.localizacao.domain.repository;

import br.jus.stm.localizacao.domain.entity.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MunicipioRepository extends JpaRepository<Municipio, Long> {

	Municipio findByCodigoIBGECompleto(String codigoIBGE);
	
	List<Municipio> findByUfSiglaOrderByNome(String uf);

	List<Municipio> findByUfRegiaoSigla(String uf);
	
	List<Municipio> findByMicroRegiaoCodigoIBGECompleto(String codigoIBGE);
	
	List<Municipio> findByMicroRegiaoMesoRegiaoCodigoIBGECompleto(String codigoIBGE);
	
}
